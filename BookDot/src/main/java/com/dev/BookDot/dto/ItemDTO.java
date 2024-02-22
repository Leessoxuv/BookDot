package com.dev.BookDot.dto;

import lombok.Getter;
import org.json.JSONObject;

@Getter
public class ItemDTO {
    private String title;
    private String author;
    private String publisher;
    private String discount;

    public ItemDTO(JSONObject itemJSON) {
        this.title = itemJSON.getString("title");
        this.author = itemJSON.getString("author");
        this.publisher = itemJSON.getString("publisher");
        this.discount = itemJSON.getString("discount");
    }
}
