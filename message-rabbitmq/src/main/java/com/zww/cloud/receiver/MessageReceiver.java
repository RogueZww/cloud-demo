package com.zww.cloud.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by RogueZww on 2018/4/23.
 */
@Component
@RabbitListener(queues = {"hello"})
public class MessageReceiver {

    @RabbitHandler
    public void process(String messgae) {
        System.out.println("message has received:\n" + messgae);
    }

}
