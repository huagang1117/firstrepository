package com.hg.common;

import java.util.Properties;

public class PropertiesUtil {
    private Properties pro;
    public PropertiesUtil(String filename) throws Exception {
        pro = new Properties();
        pro.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(filename));
    }

    public Properties getProperties() {
        return pro;
    }

    public String getValue(String key){
        String value=null;
        if(key==null||"".equals(key)){
            return value;
        }
        return pro.getProperty(key);
    }

    public static void main(String[] args) throws Exception {
        String filepath = "resource/kafka.properties";
        PropertiesUtil util = new PropertiesUtil(filepath);
        System.out.println(util.getValue("producer.bootstrap.servers"));
    }

}

