package io.npee.core;

import com.sun.source.tree.MemberReferenceTree;
import io.npee.core.discount.DiscountPolicy;
import io.npee.core.member.MemberRepository;
import io.npee.core.member.MemoryMemberRepository;
import io.npee.core.order.OrderService;
import io.npee.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "io.npee.core",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    @Autowired MemberRepository memberRepository;
    @Autowired DiscountPolicy discountPolicy;

    @Bean
    OrderService orderService() {
        return new OrderServiceImpl(memberRepository, discountPolicy);
    }
}
