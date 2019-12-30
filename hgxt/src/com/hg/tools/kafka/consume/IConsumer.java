package com.hg.tools.kafka.consume;

public interface IConsumer {
    void consume(String topic) throws Exception;
    void close() throws Exception;
}
