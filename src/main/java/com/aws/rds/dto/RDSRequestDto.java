package com.aws.rds.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RDSRequestDto {
    private String dbInstanceIdentifier;
    private String dbInstanceClass;
    private String engine;
    private String masterUsername;
    private String masterUserPassword;
    private Integer allocatedStorage;
    private String dbName;
}
