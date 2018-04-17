package com.zww.cloud.client.impl;

import com.zww.cloud.client.apfClient;
import org.springframework.stereotype.Component;

/**
 * Created by RogueZww on 2018/4/2.
 */
@Component
public class apfClientImpl implements apfClient {
    @Override
    public String getToken() {
        return "fallback, no token";
    }

    @Override
    public String index() {
        return "client fallback";
    }

    @Override
    public String retry() {
        return null;
    }

    @Override
    public String optional2() {
        return null;
    }
}
