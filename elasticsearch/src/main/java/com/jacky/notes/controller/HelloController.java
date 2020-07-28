package com.jacky.notes.controller;

import com.jacky.notes.entity.Car;
import com.jacky.notes.entity.Item;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * HelloController
 *
 * @author liyj
 * @date 2020/5/28
 */
@RestController
public class HelloController {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @GetMapping("/test")
    public String test() {
        return "1234";
    }

    @GetMapping("/init")
    public boolean initES() {
        return elasticsearchRestTemplate.createIndex(Item.class);
    }

    @GetMapping("/initCar")
    public boolean initCar() {
        return elasticsearchRestTemplate.createIndex(Car.class);
    }

    @GetMapping("/delete")
    public boolean delete() {
        return elasticsearchRestTemplate.deleteIndex(Item.class);
    }

    @GetMapping("/batchInit")
    public boolean batchInit() {
        int n = 100;
        ArrayList<Item> items = new ArrayList<Item>();
        ArrayList<Car> cars = new ArrayList<Car>();
        for (int i = 1; i <= 100; i++) {
            items.add(new Item(new Long(i), "title" + i, "category" + i, "brand" + i, new Double(i * 5000), "img" + i));
            cars.add(new Car(new Long(i), "brand" + i, new Double(i * 10000), "model" + i));
        }
        IndexQuery itemQuery = new IndexQueryBuilder().withObject(items).build();
        IndexQuery carQuery = new IndexQueryBuilder().withObject(cars).build();
        elasticsearchRestTemplate.index(itemQuery);
        elasticsearchRestTemplate.index(carQuery);
        return true;
    }

    @GetMapping("/save")
    public String save() {
        Item item = new Item();
        item.setId(1L);
        item.setBrand("奔驰");
        item.setCategory("suv");
        item.setImages("/dfsafd");
        item.setPrice(new Double(40000));
        item.setTitle("benz SUV");
        IndexQuery qu = new IndexQueryBuilder().withId(item.getId().toString()).withObject(item).build();
        elasticsearchRestTemplate.index(qu);
        return "succ";
    }

    @GetMapping("/getById/{id}")
    public Item getById(@PathVariable String id) {
//        return elasticsearchRestTemplate.get(id, Item.class);
        return null;
    }

}
