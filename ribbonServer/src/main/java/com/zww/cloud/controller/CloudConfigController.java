package com.zww.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by RogueZww on 2018/4/18.
 */
@RefreshScope
@RestController
@RequestMapping("/config")
public class CloudConfigController {

    @Value("${role}")
    private String role;
    @Value("${weapon:${defaultWeapon}}")
    private String weapon;
    @Autowired
    private Environment env;

    @GetMapping("test1")
    public String test1() {
        return role + " with " + weapon;
    }

    @GetMapping("test2")
    public String test2() {
        return env.getProperty("role", "undefined");
    }

    @GetMapping("test3")
    public String test3() {
        return env.getProperty("powers", "undefined");
    }

}
