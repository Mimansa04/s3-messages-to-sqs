package com.mimansa.rst.queuePOC.service;

import com.mimansa.rst.queuePOC.config.FileConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitiateAppService {

   // @NonNull
    private final FileConfig fileConfig;
    private final AlertFileService alertFileService;
    private final PublishService publishService;

    @Autowired
    public InitiateAppService(FileConfig fileConfig, AlertFileService alertFileService, PublishService publishService) {
        this.fileConfig = fileConfig;
        this.alertFileService = alertFileService;
        this.publishService = publishService;
    }

    public void startService(){


        alertFileService.fileToList( fileConfig.getBucketName(), fileConfig.getKeyValue(),fileConfig.getColumnValue()).forEach(publishService::publish);


    }

}
