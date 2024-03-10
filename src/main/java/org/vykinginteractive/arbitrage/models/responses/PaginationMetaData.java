package org.vykinginteractive.arbitrage.models.responses;

import lombok.Data;

@Data
public class PaginationMetaData {

    public int page;

    public int size;

    public int totalItems;

    public int totalPages;

}
