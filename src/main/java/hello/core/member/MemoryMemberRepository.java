package hello.core.member;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;

@Component
public class MemoryMemberRepository implements MemberRepository{

    //동시성 이슈가 있기 때문에 ConcurrentHashMap 을 사용해야된다(예제이기 때문에 hashMap 사용)
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
