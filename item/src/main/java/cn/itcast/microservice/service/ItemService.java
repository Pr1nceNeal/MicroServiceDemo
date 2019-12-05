package cn.itcast.microservice.service;

import cn.itcast.microservice.pojo.Item;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ItemService {

    private static final Map<Long, Item> MAP = new HashMap<>();

    static {
        MAP.put(1L, new Item(1L, "title1", "pic1", "desc1", 1000L));
        MAP.put(2L, new Item(2L, "title2", "pic2", "desc2", 2000L));
        MAP.put(3L, new Item(3L, "title3", "pic3", "desc3", 3000L));
        MAP.put(4L, new Item(4L, "title4", "pic4", "desc4", 4000L));
        MAP.put(5L, new Item(5L, "title5", "pic5", "desc5", 5000L));
        MAP.put(6L, new Item(6L, "title6", "pic6", "desc6", 6000L));
        MAP.put(7L, new Item(7L, "title7", "pic7", "desc7", 7000L));
        MAP.put(8L, new Item(8L, "title8", "pic8", "desc8", 8000L));
    }

    public Item queryItemById(Long id) {
        return MAP.get(id);
    }

}
