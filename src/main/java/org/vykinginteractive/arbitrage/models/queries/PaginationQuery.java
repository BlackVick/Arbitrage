package org.vykinginteractive.arbitrage.models.queries;

import lombok.Data;

@Data
public class PaginationQuery {

    private int page;

    private int size;

    public PaginationQuery(int page, int size) {
        this.page = page;
        this.size = size;
    }
}
