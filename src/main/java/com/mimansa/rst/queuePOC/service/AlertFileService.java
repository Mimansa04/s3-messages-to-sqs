package com.mimansa.rst.queuePOC.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlertFileService {

    private final AmazonS3 s3Client;

    @Autowired
    public AlertFileService(AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }

    public List<String> fileToList(String bucketName, String keyValue, int columnValue){

        try{
          // File file = new File(filePath);
           // ClassLoader classLoader = getClass().getClassLoader();

           // File tempFile = new File(Objects.requireNonNull(classLoader.getResource("test.txt")).getFile());
            //changed

            S3Object s3Object = s3Client.getObject(bucketName, keyValue);
            InputStream objectData = s3Object.getObjectContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(objectData, StandardCharsets.UTF_8));
            String st;
            List<String> alertIDs = new ArrayList<>();

            while((st = br.readLine())!=null){
                String[] tempLine = st.split(" ");
                alertIDs.add(tempLine[columnValue]);
                System.out.println(tempLine[columnValue]);
            }
            br.close();
            return alertIDs;
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

}
