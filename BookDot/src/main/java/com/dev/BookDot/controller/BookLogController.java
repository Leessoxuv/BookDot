package com.dev.BookDot.controller;


import com.dev.BookDot.dto.BookLogCreateDTO;
import com.dev.BookDot.dto.BookLogCreateResponseDTO;
import com.dev.BookDot.service.BookLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book-log")
public class BookLogController {
    private BookLogService bookLogService;

    @Autowired
    public void setBookLogService(BookLogService bookLogService) {
        this.bookLogService = bookLogService;
    }
    @PostMapping("/create")
    public ResponseEntity<BookLogCreateResponseDTO> insert(@RequestBody BookLogCreateDTO bookLogCreateDTO) {
        BookLogCreateResponseDTO bookLogCreateResponseDTO = this.bookLogService.insert(bookLogCreateDTO);
        return ResponseEntity.ok(bookLogCreateResponseDTO);
    }
}
