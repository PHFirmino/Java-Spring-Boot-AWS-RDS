package com.aws.rds.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "aws")
public class AWSProperties {
    private String endpoint;
    private String region;
    private String accessKey;
    private String secretKey;
}