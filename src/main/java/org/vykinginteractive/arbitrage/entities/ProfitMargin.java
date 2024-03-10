package org.vykinginteractive.arbitrage.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "margins")
public class ProfitMargin {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "base", nullable = false)
    private String base;

    @Column(name = "profit", nullable = false)
    private double profit;

    @Column(name = "routes", nullable = false)
    private String routes;

    @Column(name = "timestamp", nullable = false)
    private String timestamp;

}
