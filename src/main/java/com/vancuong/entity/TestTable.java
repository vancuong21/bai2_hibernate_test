package com.vancuong.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import java.util.UUID; // thu vien ramdom

@Getter
@Setter
@ToString
@Data
@Entity
public class TestTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;// UUID: ramdom
    private String name;
}
