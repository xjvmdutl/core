package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository();//구현체가 없기 떄문에 선택해야한다
    //다형성으로 인해 MemoryMemberRepository 를 선택한다
    
    private final MemberRepository memberRepository; //추상화에만 의존한다
    
    //의존관계를 자동으로 주입하는 어노테이션을 적어주어 자동주입이 되도록 해야한다.
    // application.getBean(MemberRepository.getBean(MemberRepository.class); 코드가 자동으로 들어간다고 생각하면 된다
    @Autowired  
    public MemberServiceImpl(MemberRepository memberRepository) {
        //생성자를 통해 주입을 받는다
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
