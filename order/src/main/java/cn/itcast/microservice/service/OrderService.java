package cn.itcast.microservice.service;

import cn.itcast.microservice.pojo.Item;
import cn.itcast.microservice.pojo.Order;
import cn.itcast.microservice.pojo.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private static final Map<String, Order> MAP = new HashMap<>();

    static {

        Order order = new Order();
        order.setOrderId("123123123123");
        order.setCreateDate(new Date());
        order.setUpdateDate(new Date());
        order.setUserId(1L);

        List<OrderDetail> orderDetails = new ArrayList<>();

        Item item = new Item();
        item.setId(1L);
        OrderDetail orderDetail = new OrderDetail(order.getOrderId(), item);
        orderDetails.add(orderDetail);

        item = new Item();
        item.setId(2L);
        orderDetail = new OrderDetail(order.getOrderId(), item);
        orderDetails.add(orderDetail);

        order.setOrderDetails(orderDetails);

        MAP.put(order.getOrderId(), order);
    }

    @Autowired
    private ItemService itemService;


    public Order queryOrderById(String orderId) {


        Order order = MAP.get(orderId);
        List<OrderDetail> orderDetails = order.getOrderDetails();

        for (OrderDetail orderDetail : orderDetails) {
            Long id = orderDetail.getItem().getId();
            Item item = itemService.queryItemById(id);
            orderDetail.setItem(item);
        }

        return order;
    }
}
