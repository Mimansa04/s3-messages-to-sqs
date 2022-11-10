package com.mimansa.rst.queuePOC.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
@ConfigurationProperties(prefix = "app")
public class FileConfig {


    private String bucketName;
    private String keyValue;
    private int columnValue;

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public int getColumnValue() {
        return columnValue;
    }

    public void setColumnValue(int columnValue) {
        this.columnValue = columnValue;
    }
}
