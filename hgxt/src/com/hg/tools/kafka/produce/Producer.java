package com.hg.tools.kafka.produce;

import com.hg.tools.kafka.KafkaMessage;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.Future;

public class Producer extends AbsProducer{
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    public Producer(Properties properties) throws Exception {
        super(properties);
    }

    @Override
    public void send(String topic, KafkaMessage message) throws Exception {
        try {
            Future<RecordMetadata> d = kafkaProducer.send(new ProducerRecord(topic, message.getMsgcontent()));
            kafkaProducer.flush();
            logger.info("send message success key={}, partition={},offset={},topic={},content={}",new Object[]{message.getMsgid(),d.get().partition(),d.get().offset(),d.get().topic(),message.getMsgcontent()});
        } catch (Exception e){
            logger.error("send message error key={}, content={},error={}", new Object[]{message.getMsgid(),message.getMsgcontent(),e.getMessage()});
            throw e;
        }
    }

    @Override
    public void close() throws Exception {
        kafkaProducer.close();
    }

}
