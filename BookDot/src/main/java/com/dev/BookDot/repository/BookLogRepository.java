package com.dev.BookDot.repository;

import com.dev.BookDot.entity.BookLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookLogRepository extends JpaRepository<BookLog, Integer> {
}
