package com.vancuong.entity;

import com.vancuong.enumurations.ProductStatus;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity // khai bao thuc the
@Table(name = "product")// trong thực tế có sẵn database, nên làm thế này không ảnh hưởng đến database
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(
            sequenceName = "productIdSeq", // ten cua sequence
            name = "productIdSeq", // ten cua sequence
            initialValue = 1, // gia tri dau tien
            allocationSize = 2 // buoc nhay
    )
    private Integer id;

    //@Column(name = "name")// muốn ánh xạ ko ảnh hưởng database
    private String name;
    private Double price;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @ManyToOne
    private CategoryEntity category;
}
