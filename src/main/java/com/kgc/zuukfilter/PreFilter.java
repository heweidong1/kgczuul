package com.kgc.zuukfilter;

import com.netflix.zuul.ZuulFilter;

import com.netflix.zuul.context.RequestContext;
import org.apache.log4j.Logger;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;


public class PreFilter extends ZuulFilter {

    Logger logger = Logger.getLogger(PreFilter.class);

// 拦截得类型
    @Override
    public String filterType() {
//       前置过滤
        return FilterConstants.PRE_TYPE;
    }
//拦截得顺序
    @Override
    public int filterOrder() {

        return 0;
    }
//是否拦截
    @Override
    public boolean shouldFilter() {
        return true;
    }
//拦截后具体执行方法
    @Override
    public Object run() {
        logger.info("第一次拦截");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
//判定第一个条件是否满足条件，用于后边得拦截器是否在进行拦截
        ctx.setSendZuulResponse(false);
        return null;
    }
}
