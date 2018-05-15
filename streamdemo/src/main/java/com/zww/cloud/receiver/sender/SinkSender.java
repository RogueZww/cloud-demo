package com.zww.cloud.receiver.sender;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by RogueZww on 2018/5/14.
 */
public interface SinkSender {

    @Output(Sink.INPUT)
    MessageChannel output();

    @Output("kick")
    MessageChannel kick();

    @Input("kick")
    SubscribableChannel inkick();
}
