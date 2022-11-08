package com.mimansa.rst.queuePOC.service;

import com.mimansa.rst.queuePOC.config.FileConfig;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InitiateAppService {

   // @NonNull
    private final FileConfig fileConfig;
    private final AlertFileService alertFileService;
    private final PublishService publishService;

    public void startService(){

        System.out.println(fileConfig.getColumnValue());
        System.out.println(fileConfig.getFilePath());

        alertFileService.fileToList( fileConfig.getFilePath(), fileConfig.getColumnValue()).forEach(publishService::publish);


    }

}
