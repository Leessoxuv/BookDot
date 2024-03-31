package com.dev.BookDot.service;

import com.dev.BookDot.dto.MemberRequest;
import com.dev.BookDot.dto.MemberResponse;
import com.dev.BookDot.mapper.MemberMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    public Long saveMember(final MemberRequest params) {
        params.encodingPassword(passwordEncoder);
        memberMapper.save(params);
        return params.getId();
    }

    public MemberResponse findMemberByEmail(final String email) {
        return memberMapper.findByEmail(email);
    }


    @Transactional
    public Long deleteMemberById(final Long id) {
        memberMapper.deleteById(id);
        return id;
    }


    public int countMemberByEmail(final String email) {
        return memberMapper.countByEmail(email);
    }

    public MemberResponse login(final String email, final String password) {

        // 1. 회원 정보 및 비밀번호 조회
        MemberResponse member = findMemberByEmail(email);
        String encodedPassword = (member == null) ? "" : member.getPassword();

        // 2. 회원 정보 및 비밀번호 체크
        if (member == null || !passwordEncoder.matches(password, encodedPassword)) {
            return null;
        }

        // 3. 회원 응답 객체에서 비밀번호를 제거한 후 회원 정보 리턴
        member.clearPassword();
        return member;
    }

}
