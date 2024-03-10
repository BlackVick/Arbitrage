package org.vykinginteractive.arbitrage.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "params")
public class Parameter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "prm_key", nullable = false, unique = true)
    private String prmKey;

    @Column(name = "prm_label", nullable = false)
    private String prmLabel;

    @Column(name = "prm_value", length = 1000, nullable = false)
    private String prmValue;

}
