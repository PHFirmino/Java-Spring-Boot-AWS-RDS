package com.aws.rds;

import com.aws.rds.config.AWSProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AWSProperties.class)
public class RdsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RdsApplication.class, args);
	}

}
