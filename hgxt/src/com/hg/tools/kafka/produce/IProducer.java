package com.hg.tools.kafka.produce;

import com.hg.tools.kafka.KafkaMessage;

public interface IProducer {
    void send(String topic, KafkaMessage message)throws Exception;
    void close() throws Exception;
}
