package com.aws.rds.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.rds.RdsClient;

import java.net.URI;

@Configuration
@AllArgsConstructor
public class RDSConfig {

    private AWSProperties awsProperties;

    @Bean
    public RdsClient rdsClient(){
        return RdsClient
                .builder()
                .endpointOverride(URI.create(awsProperties.getEndpoint()))
                .region(Region.of(awsProperties.getRegion()))
                .credentialsProvider(
                    StaticCredentialsProvider.create(credentials())
                )
                .build();
    }

    private AwsBasicCredentials credentials(){
        return AwsBasicCredentials.create(awsProperties.getAccessKey(), awsProperties.getSecretKey());
    }
}
