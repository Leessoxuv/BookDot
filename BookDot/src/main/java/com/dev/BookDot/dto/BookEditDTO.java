package com.dev.BookDot.dto;


import com.dev.BookDot.entity.Book;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class BookEditDTO {
    @NonNull
    @Positive // 값을 양수로 제한
    private Integer bookId;

    @NonNull
    @NotBlank
    private String title;

    @NonNull
    @Min(1000)
    private Integer price;

    public Book fill(Book book) {
        book.setTitle(this.title);
        book.setPrice(this.price);
        return book;
    }
}
