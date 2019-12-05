package cn.itcast.microservice.service;

import cn.itcast.microservice.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ItemService {

//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Value("${itcast.item.url}")
//    private String itemUrl;
//
//    public Item queryItemById(Long id) {
//        // 调用module item中的service -> http://localhost:8083/item/{itemId}
//        // 可以使用RestTemplate实现
//        // 将返回的结果封装到Item对象中
//        Item item = restTemplate.getForObject(itemUrl + id, Item.class);
//        return item;
//    }


    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    public Item queryItemById(Long id) {
        String serviceId = "itcast-microservice-item";

        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
        if( instances == null || instances.isEmpty()) {
            return null;
        }
        ServiceInstance serviceInstance = instances.get(0);

        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();

        String url = "http://" + host + ":" + port + "/item/" + id;

        Item item = restTemplate.getForObject(url, Item.class);

        return item;
    }
}
