package io.npee.core;

import io.npee.core.member.Grade;
import io.npee.core.member.Member;
import io.npee.core.member.MemberService;
import io.npee.core.member.MemberServiceImpl;
import io.npee.core.order.Order;
import io.npee.core.order.OrderService;
import io.npee.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
