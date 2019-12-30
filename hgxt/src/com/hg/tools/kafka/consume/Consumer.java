package com.hg.tools.kafka.consume;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Properties;

public class Consumer extends AbsConsumer{
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    public Consumer(Properties properties) throws Exception {
        super(properties);
    }

    @Override
    public void consume(String topic) throws Exception {
        try {
            //订阅主题
            kafkaConsumer.subscribe(Arrays.asList(topic));
            ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                logger.info("consume message success topic={},offset={},key={},partition={},content={}", new Object[]{record.topic(),record.offset(),record.key(),record.partition(),record.value()});
            }
            kafkaConsumer.commitSync();
        } catch (Exception e){
            logger.error("consume message error message={}", e.getMessage());
            throw e;
        }
    }

    @Override
    public void close() throws Exception {
        kafkaConsumer.close();
    }
}
