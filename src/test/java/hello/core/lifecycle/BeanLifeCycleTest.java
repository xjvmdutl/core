package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(
            LifeCycleConfig.class);
        NetworkClient client = applicationContext.getBean(NetworkClient.class);
        applicationContext.close();

    }

    @Configuration
    static class LifeCycleConfig {

        //@Bean(initMethod = "init", destroyMethod = "close") //destroyMethod 의 Default 값이 (inferred)로 되어있어 종료메서드를 추론해서 호출해준다(관례상 close()를 많이 쓰기 떄문에 가능)
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient(); //객체를 생성후 setter를 통해 필요한 설정을 했다
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
