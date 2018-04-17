package com.zww.cloud.client;

import com.zww.cloud.client.impl.apfClientImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by RogueZww on 2018/4/2.
 */
@FeignClient(name = "ribbonServer", fallback = apfClientImpl.class)
public interface apfClient {

    @RequestMapping(value = "/csrftoken", method = RequestMethod.GET)
    public String getToken();

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index();

    @RequestMapping(value = "/retry", method = RequestMethod.GET)
    public String retry();

    @RequestMapping(value = "/optional/userid",method = RequestMethod.GET)
    public String optional2();
}
