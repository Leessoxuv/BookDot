package com.dev.BookDot.service;


import com.dev.BookDot.dto.ItemDTO;
import com.dev.BookDot.dto.NaverRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class SearchService {
    private static final String CLIENT_ID = "1vAzdicUqAIyLXK0kpMU";
    private static final String CLIENT_SECRET = "ro1M7QsMSl";
    // API를 통해 검색된 상품 목록 조회
    public static List<ItemDTO> search(NaverRequestDTO naverRequestDTO) {
        String url = "https://openapi.naver.com/";

        URI uri = UriComponentsBuilder.fromHttpUrl(url)
                .path("v1/search/book.json")
                .queryParam("query", naverRequestDTO.getQuery())
                .queryParam("display", naverRequestDTO.getDisplay())
                .queryParam("start", naverRequestDTO.getStart())
                .queryParam("sort", naverRequestDTO.getSort())
                .encode()
                .build()
                .toUri();
        log.info("uri : {}", uri);
        RestTemplate restTemplate = new RestTemplate();

        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id", CLIENT_ID)
                .header("X-Naver-Client-Secret", CLIENT_SECRET)
                .build();

        ResponseEntity<String> result = restTemplate.exchange(req, String.class);
        List<ItemDTO> itemDTOS = fromJSONtoNaverProduct(result.getBody());

        log.info("result ={}", itemDTOS);
        return itemDTOS;

    }
    private static List<ItemDTO> fromJSONtoNaverProduct(String result) {
        // 문자열 정보를 JSONObject로 바꾸기
        JSONObject rjson = new JSONObject(result);
        // JSONObject에서 items 배열 꺼내기
        // JSON 배열이기 때문에 보통 배열이랑 다르게 활용해야한다.
        JSONArray naverProducts = rjson.getJSONArray("items");
        List<ItemDTO> naverProductDtoList = new ArrayList<>();
        for (int i = 0; i < naverProducts.length(); i++) {
            JSONObject naverProductsJson = (JSONObject) naverProducts.get(i);
            ItemDTO itemDto = new ItemDTO(naverProductsJson);
            naverProductDtoList.add(itemDto);
        }
        return naverProductDtoList;
    }
}
