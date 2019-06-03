package leyou.es.repository;

import leyou.es.pojo.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ItemRepository extends ElasticsearchRepository<Item,Long> {
    List<Item> findAllByPriceBetween(Double begin, Double end);
}
