package hello.core.autowired;

import hello.core.member.Member;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

public class AutowiredTest {

    @Test
    public void AutowiredOption(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
            TestBean.class);
    }

    static class TestBean{
        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            //자동주입할 대상이 없다면 메소드 호출 자체가 안된다
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
