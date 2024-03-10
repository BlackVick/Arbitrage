package org.vykinginteractive.arbitrage.models.dtos;

import lombok.Data;

@Data
public class UpdatePreference {
    private String name;

    private String address;

    private String website;

    private String email;

    private String phone;

    private String privacy;

    private String terms;

    private int androidMinVersion;

    private int iosMinVersion;

}
