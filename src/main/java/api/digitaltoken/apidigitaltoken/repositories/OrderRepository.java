package api.digitaltoken.apidigitaltoken.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.digitaltoken.apidigitaltoken.models.Order;
import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order, UUID>{

    public List<Order> findByItem(String item);
    
    public void deleteByItem(String item);

}
