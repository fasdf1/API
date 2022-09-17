package com.example.Api.member;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member){
        return memberRepository.save(member);
    }
    public Member findMember(long id) {

        Member member = new Member(id,"kcd@gmail.com","김코딩","asd");
        return member;
    }
}
