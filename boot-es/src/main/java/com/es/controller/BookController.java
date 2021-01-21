package com.es.controller;

import com.es.entity.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.SneakyThrows;
import org.apache.commons.codec.Charsets;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.ResponseListener;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/********************************************************************************
 *
 * Title: es控制器
 *
 * Description:
 *
 * @author chenlm
 * create date on 2021/1/14 0014
 *
 *******************************************************************************/
@RestController
public class BookController {
    @Autowired
    private RestClient restClient;

    /**
     * 同步执行http请求
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/es")
    public ResponseEntity<String> getEsInfo() throws Exception {
        Request request = new Request(HttpMethod.GET.name(), "/");
        // 设置其他一些参数比如美化json
//        request.addParameter("pretty", "true");
//        // 设置请求体
//        request.setEntity(new NStringEntity("{\"json\":\"text\"}", ContentType.APPLICATION_JSON));
//        // 还可以将其设置为String，默认为ContentType为application/json
//        request.setJsonEntity("{\"json\":\"text\"}");

        /*
          /*
        performRequest是同步的，将阻塞调用线程并在请求成功时返回Response，如果失败则抛出异常
        内部属性可以取出来通过下面的方法
           */
        Response response = restClient.performRequest(request);
        // 获取请求行
//        RequestLine requestLine = response.getRequestLine();
//        // 获取host
//        HttpHost host = response.getHost();
//        // 获取状态码
//        int statusCode = response.getStatusLine().getStatusCode();
//        // 获取响应头
//        Header[] headers = response.getHeaders();
        // 获取响应体
        String responseBody = EntityUtils.toString(response.getEntity());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    /**
     * 异步请求
     * @return
     */
    @GetMapping("/es/asyn")
    public ResponseEntity<String> asynChronous(){
        Request request=new Request(HttpMethod.GET.name(),"/");
        restClient.performRequestAsync(request, new ResponseListener() {
            @SneakyThrows(value = IOException.class)
            @Override
            public void onSuccess(Response response) {
                System.out.println("异步执行HTTP请求并成功");
                String responseBody = EntityUtils.toString(response.getEntity());
                System.out.println(String.format("返回内容%s",responseBody));
            }

            @Override
            public void onFailure(Exception exception) {
                System.out.println("异步执行HTTP请求并失败");

            }
        });
        return ResponseEntity.of(Optional.of("ok"));
    }

    /**
     * 添加文档
     * @param book
     * @return
     */
    @PostMapping("/es")
    @SneakyThrows(Exception.class)
    public ResponseEntity<String> add(@RequestBody Book book){
        // 构造HTTP请求，第一个参数是请求方法，第二个参数是服务器的端点，host默认是http://localhost:9200，
        // endpoint直接指定为index/type的形式
        //restful
        Request request=new Request(HttpMethod.POST.name(), "/book/book/" + book.getBookId());
        request.addParameter("pretty","true");
        request.setEntity(new NStringEntity(new ObjectMapper().writeValueAsString(book), ContentType.APPLICATION_JSON));
        // 发送HTTP请求
        Response response = restClient.performRequest(request);
        // 获取响应体, id: AWXvzZYWXWr3RnGSLyhH
        String responseBody = EntityUtils.toString(response.getEntity());
        System.out.println(responseBody);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);


    }

    /**
     * 查询
     * @param bookId
     * @return
     */
    @GetMapping("/es/info")
    @SneakyThrows(Exception.class)
    public ResponseEntity<String> getInfo(String bookId){
        // 构造HTTP请求，第一个参数是请求方法，第二个参数是服务器的端点，host默认是http://localhost:9200，
        // endpoint直接指定为index/type的形式
        //restful
        Request request=new Request(HttpMethod.GET.name(), "/book/book/" + bookId);
        request.addParameter("pretty","true");
        // 发送HTTP请求
        Response response = restClient.performRequest(request);
        // 获取响应体, id: AWXvzZYWXWr3RnGSLyhH
        String responseBody = EntityUtils.toString(response.getEntity());
        System.out.println(responseBody);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);


    }

    /**
     * 更新
     * @param bookId
     * @param book
     * @return
     */
    @PutMapping("/{bookId}")
    @SneakyThrows(Exception.class)
    public ResponseEntity<String> updateBook(@PathVariable("bookId") String bookId, @RequestBody Book book){
        Request request=new Request(HttpMethod.POST.name(),"/book/book/"+bookId+"/_update");
        request.addParameter("pretty","true");
        ObjectMapper objectMapper=new ObjectMapper();
        Map<String,Book> paramMap=new HashMap<>();
        paramMap.put("doc",book);
        request.setJsonEntity(objectMapper.writeValueAsString(paramMap));

        Response response = restClient.performRequest(request);
        // 获取响应体, id: AWXvzZYWXWr3RnGSLyhH
        String responseBody = EntityUtils.toString(response.getEntity());
        System.out.println(responseBody);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);


    }
    /**
     * 使用脚本更新Book
     * @param id
     * @param
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/update2/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateBook2(@PathVariable("id") String id, @RequestParam("name") String name) throws IOException {
        // 构造HTTP请求
        Request request = new Request("POST", new StringBuilder("/book/book/").
                append(id).append("/_update").toString());
        request.addParameter("pretty", "true");

        Map<String,String> paramMap=new HashMap<>();
        // 创建脚本语言，如果是字符变量，必须加单引号
        paramMap.put("script", "ctx._source.name=" + "'" + name + "'");
        request.setEntity(new NStringEntity(new ObjectMapper().writeValueAsString(paramMap), ContentType.APPLICATION_JSON));

        // 执行HTTP请求
        Response response = restClient.performRequest(request);

        // 获取返回的内容
        String responseBody = EntityUtils.toString(response.getEntity());

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @SneakyThrows(IOException.class)
    public ResponseEntity<String> deleteById(@PathVariable("id") String id)  {
        Request request = new Request("DELETE", "/book/book/" + id);
        request.addParameter("pretty", "true");
        // 执行HTTP请求
        Response response = restClient.performRequest(request);
        // 获取结果
        String responseBody = EntityUtils.toString(response.getEntity());

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }




}
