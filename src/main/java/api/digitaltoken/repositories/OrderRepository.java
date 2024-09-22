package api.digitaltoken.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.digitaltoken.apidigitaltoken.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID>{
    
}
