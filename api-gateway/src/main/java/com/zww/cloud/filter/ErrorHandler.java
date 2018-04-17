package com.zww.cloud.filter;

import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;

/**
 * Created by RogueZww on 2018/4/8.
 */
public class ErrorHandler extends SendErrorFilter {
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 20;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        Object postFail = context.get("postFail");
        return postFail == null ? false : true;
    }

}
