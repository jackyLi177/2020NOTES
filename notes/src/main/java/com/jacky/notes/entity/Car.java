package com.jacky.notes.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Car
 *
 * @author liyj
 * @date 2020/6/17
 */
@Data
@Document(indexName = "car",type = "docs", shards = 1, replicas = 0)
public class Car {

    @Id
    private Long id;

    @Field(type = FieldType.Keyword)
    private String brand;

    @Field(type = FieldType.Double)
    private Double price;

    @Field(type = FieldType.Keyword)
    private String model;

    public Car(Long id, String brand, Double price, String model) {
        this.id = id;
        this.brand = brand;
        this.price = price;
        this.model = model;
    }
}
