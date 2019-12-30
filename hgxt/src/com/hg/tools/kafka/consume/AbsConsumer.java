package com.hg.tools.kafka.consume;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Properties;

public abstract class AbsConsumer implements IConsumer{
    private static final Logger logger = LoggerFactory.getLogger(AbsConsumer.class);
    protected KafkaConsumer kafkaConsumer;

    public AbsConsumer(Properties properties) throws Exception{
        Properties config = this.initConfig(properties);
        this.kafkaConsumer = new KafkaConsumer(config);
    }

    private Properties initConfig(Properties properties)throws Exception{
        Properties config = new Properties();
        Iterator ite = properties.keySet().iterator();
        while (ite.hasNext()){
            String key = (String) ite.next();
            if(key.startsWith("consumer.")){
                config.setProperty(key.substring("consumer.".length()), properties.getProperty(key));
            }
        }
        return config;
    }
}
