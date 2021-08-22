package io.npee.core;

import io.npee.core.discount.DiscountPolicy;
import io.npee.core.discount.FixDiscountPolicy;
import io.npee.core.discount.RateDiscountPolicy;
import io.npee.core.member.MemberRepository;
import io.npee.core.member.MemberService;
import io.npee.core.member.MemberServiceImpl;
import io.npee.core.member.MemoryMemberRepository;
import io.npee.core.order.OrderService;
import io.npee.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("AppConfig.orderService");
        // return new OrderServiceImpl(memberRepository(), discountPolicy());
        return null;
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
