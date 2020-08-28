package com.example.zuulserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/********************************************************************************
 *
 * Title: 权限认证
 *
 *
 * Description:
 *
 * @author chenlm
 * create date on 2020/7/4
 *
 *******************************************************************************/
@Component
public class AcessFileter extends ZuulFilter {
    @Override
    public String filterType() {
        //前置处理
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();
        //获取token
        String token=request.getParameter("token");
        if (StringUtils.isEmpty(token)){
            System.out.println("Token为空，禁止请求");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
        }
        return null;
    }
}
