package io.npee.core;

import io.npee.core.member.MemberService;
import io.npee.core.member.MemberServiceImpl;
import io.npee.core.member.MemoryMemberRepository;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
}
