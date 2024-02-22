package com.dev.BookDot.controller;


import com.dev.BookDot.dto.ItemDTO;
import com.dev.BookDot.dto.NaverRequestDTO;

import com.dev.BookDot.service.SearchService;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class SearchController {

    @GetMapping("/search/bookSearch")
    public List<ItemDTO> getItems(@RequestParam String query, Model model) {
        NaverRequestDTO naverRequestDTO = NaverRequestDTO.builder()
                .query(query)
                .display(9)
                .start(1)
                .sort("sim")
                .build();

        List<ItemDTO> naverProductDtos = SearchService.search(naverRequestDTO);
        model.addAttribute("naverProductList", naverProductDtos);
        return naverProductDtos;
    }
}



