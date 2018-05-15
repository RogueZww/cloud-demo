package com.zww.cloud.receiver;

import com.zww.cloud.receiver.sender.SinkSender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by RogueZww on 2018/5/14.
 */
@EnableBinding({Sink.class, SinkSender.class})
public class SinkReceiver {

    private Logger logger = LogManager.getLogger(SinkReceiver.class);
    @Autowired
    @Qualifier("kick")
    private MessageChannel messageChannel;
    @Autowired
    private SinkSender sinkSender;

//    @StreamListener(Sink.INPUT)
    @ServiceActivator(inputChannel = "input")
    public void receive(Object payload) {
        logger.info("Receive:================\n " + payload);
//        sinkSender.kick().send(MessageBuilder.withPayload("kick ass").build());
        messageChannel.send(MessageBuilder.withPayload("kick ass").build());
    }

    @ServiceActivator(inputChannel = "kick")
    public void receive2(Object payload){
        logger.info("Kick:==================\n" + payload);
    }
}
