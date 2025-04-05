package com.juancuero.model.pagination;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageBase<T> {
    private int page;
    private int size;
    private int totalPages;
    private long totalElements;
    private boolean empty;
    private List<T> content;
}
