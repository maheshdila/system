package com.devstack.healthcare.system.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//this correspond to Doctor entity in our database.
public class Doctor {
    @Id
    private long id;;
    private String name;
    private String address;
    private String contact;
    private double salary;
}
