package leyou.es.demo;

import leyou.es.pojo.Item;
import leyou.es.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTest {

    @Autowired
    ElasticsearchTemplate template;

    @Autowired
    private ItemRepository repository;

    @Test
    public void testCreate(){
        //创建索引库
        template.createIndex(Item.class);
        //映射关系
        template.putMapping(Item.class);

    }

    @Test
    public void indexList() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(1L, "小米手机7", "手机", "小米", 3299.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(2L, "坚果手机R1", "手机", "锤子", 3699.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(3L, "华为META10", "手机", "华为", 4499.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(4L, "小米Mix2S", "手机", "小米", 4299.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(5L, "荣耀V10", "手机", "华为", 2799.00, "http://image.leyou.com/13123.jpg"));
        // 接收对象集合，实现批量新增
        repository.saveAll(list);
    }

    @Test
    public void testFind(){
        // 查询全部，并安装价格降序排序
        Iterable<Item> items = repository.findAll();
        items.forEach(item-> System.out.println(item));
    }
    @Test
    public void testFindBy(){
        List<Item> items = repository.findAllByPriceBetween(2000d, 4000d);
        items.forEach(item-> System.out.println(item));
    }
}
