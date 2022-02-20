package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) 
    //AppConfig와 같이 @Configuration 어노테이션이 붙은 클래스는 내부에 @Component가 붙어 있기 때문에  제외했다(기존 코드를 유지하기 위햬)
    , basePackages = "hello.core.member" //패키지 스캔할 시작위치를 지정할 수 있다
) //@Bean 이 붙은 어노테이션을 스캔하는 어노테이션
public class AutoAppConfig {
    
    @Bean(name = "memoryMemberRepository")
    public MemberRepository memberRepository(){
        //자동 빈 등록과 수동 빈 등록과 충돌이 날경우 수동 빈 등록이 우선순위를 가진다
        return new MemoryMemberRepository();
    }

    
}
