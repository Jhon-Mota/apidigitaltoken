package api.digitaltoken.apidigitaltoken.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import api.digitaltoken.apidigitaltoken.dtos.OrderDTO;
import api.digitaltoken.apidigitaltoken.models.Order;
import api.digitaltoken.apidigitaltoken.repositories.OrderRepository;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    public Order createOrder(OrderDTO orderDTO) {
        Order newOrder = new Order();

        newOrder.setItem(orderDTO.item());
        newOrder.setQuantity(orderDTO.quantity());
        newOrder.setPrice(orderDTO.price());

        orderRepository.save(newOrder);

        return newOrder;
    }

    public List<Order> listAllOrders() {
        List<Order> allOrders = this.orderRepository.findAll();
        return allOrders;
    }

    public List<Order> getOneItem(String orderItem) {
        List<Order> item = this.orderRepository.findByItem(orderItem);
        return item;
    }
    
    @Transactional
    public void deleteOneItem(String orderItem) {
        this.orderRepository.deleteByItem(orderItem);
    }



}
