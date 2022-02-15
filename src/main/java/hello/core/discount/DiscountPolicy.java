package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    /**
     * 할인대상정책
     * @param member
     * @param price
     * @return
     */
    int discount(Member member, int price);
}
