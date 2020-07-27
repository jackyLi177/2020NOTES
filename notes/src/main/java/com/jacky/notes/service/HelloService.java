package com.jacky.notes.service;

import com.jacky.notes.entity.Item;
import com.jacky.notes.repository.CarRepository;
import com.jacky.notes.repository.ItemRepository;
import org.apache.lucene.search.BooleanQuery;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.boolQuery;

/**
 * HelloService
 *
 * @author liyj
 * @date 2020/6/19
 */
@Service
public class HelloService {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ItemRepository itemRepository;

    public Item getById(long id){
        Optional<Item> byId = itemRepository.findById(id);
        if (byId.isPresent()){
            return byId.get();
        }
        return null;
    }

}
