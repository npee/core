package io.npee.core;

import io.npee.core.discount.FixDiscountPolicy;
import io.npee.core.member.MemberRepository;
import io.npee.core.member.MemberService;
import io.npee.core.member.MemberServiceImpl;
import io.npee.core.member.MemoryMemberRepository;
import io.npee.core.order.OrderService;
import io.npee.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private FixDiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
