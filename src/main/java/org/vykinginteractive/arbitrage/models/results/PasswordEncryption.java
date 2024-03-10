package org.vykinginteractive.arbitrage.models.results;

import lombok.Data;

@Data
public class PasswordEncryption {

    private byte[] hash;
    private byte[] salt;

}
