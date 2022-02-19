package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //클라이언트에서 다른 책임을 선택한다
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //해당 정책을 변경만 해주면 된다.
    //할인 정책을 변경하기 위해서는 클라이언트인 orderServiceImpl을 코드를 수정해야한다
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; //구체 클래스에 의존하지 않게 수정 //NullPoint 예외가 발생한다

    public OrderServiceImpl(MemberRepository memberRepository,
        DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        //단일 책임 원칙을 잘 지킨 설계이다
        //할인 정책을 잘 분리하여 설계하였다
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
