package com.dev.BookDot.mapper;

import com.dev.BookDot.dto.MemberRequest;
import com.dev.BookDot.dto.MemberResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberMapper {

    public String selectTestString() throws Exception;
    void save(MemberRequest params);

    MemberResponse findByEmail(String email);

    void deleteById(Long id);

    int countByEmail(String email);

}
