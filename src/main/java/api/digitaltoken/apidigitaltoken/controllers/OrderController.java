package api.digitaltoken.apidigitaltoken.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.digitaltoken.apidigitaltoken.dtos.OrderDTO;
import api.digitaltoken.apidigitaltoken.models.Order;
import api.digitaltoken.apidigitaltoken.services.OrderService;

@RestController
@RequestMapping("/digitaltoken/api")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody OrderDTO orderDTO) {
        Order newOrder = this.orderService.createOrder(orderDTO);
        return ResponseEntity.ok(newOrder);
    }

    @GetMapping
    public List<Order> listAll() {
        List<Order> allOrders = this.orderService.listAllOrders();
        return allOrders;
    }

    @GetMapping("/{item}")
    public List<Order> getItem(@PathVariable("item") String orderItem) {
        List<Order> item = this.orderService.getOneItem(orderItem);
        return item;
    }

    @DeleteMapping("/{item}")
    public void deleteByItem(@PathVariable("item")String item) {
        this.orderService.deleteOneItem(item);
        ResponseEntity.ok().body("Deleted");
    }

}
