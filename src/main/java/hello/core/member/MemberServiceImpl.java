package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository();//구현체가 없기 떄문에 선택해야한다
    //다형성으로 인해 MemoryMemberRepository 를 선택한다
    
    private final MemberRepository memberRepository; //추상화에만 의존한다

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
