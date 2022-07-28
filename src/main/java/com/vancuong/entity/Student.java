package com.vancuong.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data // full luôn của getter, setter, tostring, hasdcode,..
public class Student {
    @Id
    @GenericGenerator( // khai bao
            name = "StudentGenerator",
            strategy = "com.vancuong.entity.generator.StudentGenerator")
    @GeneratedValue(generator = "StudentGenerator") // su dung
    private String id; // vd: S202200001, S20220002,...
    private String name;
}
