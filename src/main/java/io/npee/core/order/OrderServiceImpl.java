package io.npee.core.order;

import io.npee.core.discount.DiscountPolicy;
import io.npee.core.discount.FixDiscountPolicy;
import io.npee.core.member.Member;
import io.npee.core.member.MemberRepository;
import io.npee.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); // 단일 책임 원칙 설계

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
