package com.hg.tools.kafka;

import com.hg.common.PropertiesUtil;
import com.hg.tools.kafka.consume.Consumer;
import com.hg.tools.kafka.consume.IConsumer;
import com.hg.tools.kafka.produce.IProducer;
import com.hg.tools.kafka.produce.Producer;

import java.util.Properties;
import java.util.Random;

//kafka_2.12-0.11.0.1.jar
//kafka-clients-0.11.0.1.jar
public class Main {
    public static void main(String[] arg) throws Exception {
        PropertiesUtil util = new PropertiesUtil("resource/kafka.properties");
        Main main = new Main();
        main.produce(util.getProperties());
    }

    public void produce(Properties pro) throws Exception {
        IProducer producer = new Producer(pro);
        for(int i=0; i<10;i++){
            Random ran = new Random();
            KafkaMessage message = new KafkaMessage();
            message.setMsgid(String.valueOf(System.currentTimeMillis())+ String.valueOf(ran.nextInt(1000)));
            message.setMsgcontent(String.valueOf(System.currentTimeMillis())+"发送内容");
            producer.send("test", message);
        }
        producer.close();
    }

    public void consume(Properties pro) throws Exception {
        IConsumer consume = new Consumer(pro);
        consume.consume("test");
        consume.close();
    }
}
