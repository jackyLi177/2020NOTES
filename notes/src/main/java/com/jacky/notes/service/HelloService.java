package com.jacky.notes.service;

import com.jacky.notes.repository.CarRepository;
import com.jacky.notes.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * HelloService
 *
 * @author liyj
 * @date 2020/6/19
 */
@Service
public class HelloService {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ItemRepository itemRepository;

}
