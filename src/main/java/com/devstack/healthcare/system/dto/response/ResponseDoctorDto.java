package com.devstack.healthcare.system.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/*
@AllArgsConstructor
@NoArgsConstructor
@ToString
*/

@Data

public class ResponseDoctorDto {
    private long id;
    private String name;
    private String address;
    private String contact;
    private Double salary;

}
