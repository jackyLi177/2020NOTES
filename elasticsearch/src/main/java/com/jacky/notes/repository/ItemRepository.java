package com.jacky.notes.repository;

import com.jacky.notes.entity.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * ItemRepository
 *
 * @author liyj
 * @date 2020/6/19
 */

public interface ItemRepository extends ElasticsearchRepository<Item, Long> {
}
