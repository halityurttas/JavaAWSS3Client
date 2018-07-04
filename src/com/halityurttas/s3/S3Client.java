/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.halityurttas.s3;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.halityurttas.s3.Configuration.CredentialConfiguration;
import java.io.File;

/**
 *
 * @author halityurttas
 */
public class S3Client {
    
    private final AWSCredentials credentials;
    private final String region;
    
    public S3Client(String AWSAccessKeyId, String AWSSecretKey, String Region) {
        credentials = new CredentialConfiguration(AWSAccessKeyId, AWSSecretKey);
        this.region = Region;
    }
    
    public boolean UploadFile(String bucket, String path, String key) {
        AmazonS3 s3 = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(region)
                .build();
        s3.createBucket(bucket);
        File file = new File(path);
        s3.putObject(new PutObjectRequest(bucket, key, file));
        return true;
    }
    
}
