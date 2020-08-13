package com.tre.minio;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author yangbin
 * @date 2020/8/3 9:50
 * @description
 */
public class Demo {
    public static void main(String[] args) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, InvalidBucketNameException, ErrorResponseException, RegionConflictException {

        MinioClient minioClient = MinioClient.builder().endpoint("172.17.5.231", 9001, false).credentials("minioadmin", "minioadmin").build();
        boolean exists = minioClient.bucketExists(BucketExistsArgs.builder().bucket("picture").build());


        System.out.println(exists);

        minioClient.makeBucket(MakeBucketArgs.builder().bucket("picture5").build());

        File f = new File("C:\\Users\\杨彬\\Downloads\\kubernetes-client-linux-amd64.tar.gz");
        minioClient.putObject(PutObjectArgs.builder().bucket("picture5").object(f.getName()).stream(new FileInputStream(f), f.length(), -1).build());

    }
}
