package com.kgc.zuukfilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.log4j.Logger;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;


public class PreFilter2 extends ZuulFilter {

    Logger logger = Logger.getLogger(PreFilter2.class);

//    拦截得类型
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }
//拦截得顺序
    @Override
    public int filterOrder() {
        return 1;
    }
//是否拦截
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        return ctx.sendZuulResponse();
    }
//拦截后具体执行方法
    @Override
    public Object run() {
        logger.info("第二次拦截");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        ctx.setSendZuulResponse(false);
        return null;
    }
}
