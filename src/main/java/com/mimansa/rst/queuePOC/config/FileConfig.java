package com.mimansa.rst.queuePOC.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app")
public class FileConfig {


    private String filePath;
    private int columnValue;


}
