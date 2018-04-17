package com.zww.cloud.processor;

import com.netflix.zuul.FilterProcessor;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * Created by RogueZww on 2018/4/16.
 */
public class PostFilterProcessor extends FilterProcessor {

    @Override
    public void postRoute() throws ZuulException {
        try {
            super.postRoute();
        } catch (ZuulException e) {
            RequestContext context = RequestContext.getCurrentContext();
            context.set("postFail","true");
            throw e;
        }
    }

}
