package com.jacky.notes.repository;

import com.jacky.notes.entity.Car;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * HelloRepository
 *
 * @author liyj
 * @date 2020/6/19
 */

public interface CarRepository extends ElasticsearchRepository<Car,Long> {
}
