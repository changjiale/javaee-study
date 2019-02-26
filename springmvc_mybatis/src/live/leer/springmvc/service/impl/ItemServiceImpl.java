package live.leer.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import live.leer.springmvc.mapper.ItemMapper;
import live.leer.springmvc.pojo.Item;
import live.leer.springmvc.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<Item> getItemList() {
        return itemMapper.selectByExample(null);
    }

    @Override
    public Item getItemById(Integer id) {
        return itemMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateItem(Item item) {
        itemMapper.updateByPrimaryKeySelective(item);
    }

}
