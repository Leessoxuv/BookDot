package com.dev.BookDot.repository;

import com.dev.BookDot.entity.BookLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookLogRepository extends JpaRepository<BookLog, Integer> {
}
