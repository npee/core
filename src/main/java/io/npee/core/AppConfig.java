package io.npee.core;

import io.npee.core.member.MemberService;
import io.npee.core.member.MemberServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl();
    }
}
