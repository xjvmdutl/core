package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository
         = new MemoryMemberRepository();//구현체가 없기 떄문에 선택해야한다
    //다형성으로 인해 MemoryMemberRepository 를 선택한다
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
