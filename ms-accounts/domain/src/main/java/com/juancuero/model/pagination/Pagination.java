package com.juancuero.model.pagination;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pagination {
    private int page;
    private int size;
    private String sort;
    private String search;
}
