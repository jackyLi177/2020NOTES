package com.jacky.notes.controller;

import com.jacky.notes.entity.Item;
import com.jacky.notes.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * ElasticTestController
 *
 * @author liyj
 * @date 2020/6/19
 */
@RestController("/elastic")
public class ElasticTestController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/item/getById/{id}")
    public Item getById(@PathVariable long id){
        return helloService.getById(id);
    }

}
