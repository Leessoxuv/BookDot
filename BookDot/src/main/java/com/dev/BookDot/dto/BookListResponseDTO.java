package com.dev.BookDot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookListResponseDTO {
    private Integer bookId;
    private String title;

    public BookListResponseDTO(Integer bookId, String title) {
        this.bookId = bookId;
        this.title = title;
    }
}
