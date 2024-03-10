package org.vykinginteractive.arbitrage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "preferences")
public class Preference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnore
    @Column(name = "pref_key", nullable = false, unique = true)
    private String key;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "website", nullable = false)
    private String website;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "privacy", nullable = false)
    private String privacy;

    @Column(name = "terms", nullable = false)
    private String terms;

    @Column(name = "android_version", nullable = false)
    private int androidMinVersion;

    @Column(name = "ios_version", nullable = false)
    private int iosMinVersion;

    @Column(name = "date_updated", nullable = false)
    private String dateUpdated;

}
