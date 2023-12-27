package com.dev.BookDot.service;

import com.dev.BookDot.dto.BookLogCreateDTO;
import com.dev.BookDot.dto.BookLogCreateResponseDTO;
import com.dev.BookDot.entity.Book;
import com.dev.BookDot.entity.BookLog;
import com.dev.BookDot.repository.BookLogRepository;
import com.dev.BookDot.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookLogService {
    private BookRepository bookRepository;
    private BookLogRepository bookLogRepository;

    public BookLogService(BookRepository bookRepository, BookLogRepository bookLogRepository) {
        this.bookRepository = bookRepository;
        this.bookLogRepository = bookLogRepository;
    }
    public BookLogCreateResponseDTO insert(BookLogCreateDTO bookLogCreateDTO) {
        Book book = this.bookRepository.findById(bookLogCreateDTO.getBookId()).orElseThrow();
        BookLog bookLog = BookLog.builder()
                .book(book)
                .comment(bookLogCreateDTO.getComment())
                .page(bookLogCreateDTO.getPage())
                .build();
        bookLog = this.bookLogRepository.save(bookLog);
        return BookLogCreateResponseDTO.bookLogFactory(bookLog);
    }
}
