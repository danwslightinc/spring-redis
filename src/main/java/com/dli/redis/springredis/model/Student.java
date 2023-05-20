package com.dli.redis.springredis.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
public class Student implements Serializable {

    private static final long serialVersionUID = 7812610113273982383L;

    @Id
    private String id;
    private String name;
    private String gender;
    private int grade;


}
