package com.zww.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by RogueZww on 2018/4/8.
 */
public class TokenFilter extends ZuulFilter {
    private Logger logger = LogManager.getLogger(TokenFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String uri = request.getRequestURI();
        boolean matches = uri.matches("(.)*/ribbonServer/(.)*");
        logger.info(matches);
        return matches;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String accessToken = request.getParameter("accessToken");
        if (!StringUtils.hasText(accessToken)) {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            context.setResponseBody("aceessToken must be not null!");
        } else if (accessToken.equals("exception")) {
            throw new RuntimeException();
        }
        return null;
    }
}
