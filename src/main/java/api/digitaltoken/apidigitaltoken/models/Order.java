package api.digitaltoken.apidigitaltoken.models;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Order {
    
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 25)
    private String item;

    @Column(nullable = false, precision = 3, scale = 2)
    private int quantity;

    @Column(nullable = false, precision = 3, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private String paymentMethod;
}
