package com.vancuong.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class BillDetail implements Serializable {

    @Id
    private Integer productId;

    @Id
    private Integer bullId;
    private Double productPrice;
    private Integer quantity;
}
