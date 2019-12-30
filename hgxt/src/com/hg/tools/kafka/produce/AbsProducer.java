package com.hg.tools.kafka.produce;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Properties;

public abstract class AbsProducer implements IProducer{
    private static final Logger logger = LoggerFactory.getLogger(AbsProducer.class);
    protected KafkaProducer kafkaProducer;
    public AbsProducer(Properties properties) throws Exception{
        Properties config = this.initConfig(properties);
        this.kafkaProducer = new KafkaProducer(config);
    }

    private Properties initConfig(Properties properties)throws Exception{
        Properties config = new Properties();
        Iterator ite = properties.keySet().iterator();
        while (ite.hasNext()){
            String key = (String) ite.next();
            if(key.startsWith("producer.")){
                config.setProperty(key.substring("producer.".length()), properties.getProperty(key));
            }
        }
        return config;
    }
}
