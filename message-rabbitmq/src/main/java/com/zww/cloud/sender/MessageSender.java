package com.zww.cloud.sender;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Random;


/**
 * Created by RogueZww on 2018/4/23.
 */
@Component
public class MessageSender {

    private Logger logger = LogManager.getLogger(MessageSender.class);
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String message) {
        if (StringUtils.hasText(message)) {
            logger.info("message to send: " + message);
        } else {
            message = new StringBuilder().append(new Date().toString()).append("~~~~~~").append(new Random().nextInt()).toString();
            logger.info("no message, create new message: " + message);
        }
        amqpTemplate.convertAndSend("hello", message);
    }

}
