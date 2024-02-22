package com.dev.BookDot.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class NaverRequestDTO {
    private String lastBuildDate;
    private String query;
    private int total;
    private int start;
    private String sort;
    private int display;
}
