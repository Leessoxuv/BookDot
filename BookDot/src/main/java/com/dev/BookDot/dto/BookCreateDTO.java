package com.dev.BookDot.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class BookCreateDTO {
    @NonNull
    private String title;

    @NonNull
    private Integer price;
}
