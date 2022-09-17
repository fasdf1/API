package com.example.Api.member;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


public interface MemberRepository extends JpaRepository<Member,Long> {
    public Member findByUsername(String member);
}
