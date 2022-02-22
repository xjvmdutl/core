package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.naming.InitialContext;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//public class NetworkClient implements InitializingBean, DisposableBean {
public class NetworkClient {

    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출, url = " + url);
        //connect();
        //call("초기화 연결 메시지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect(){
        System.out.println("connect: " + url);
    }

    public void call(String message){
        System.out.println("call: " + url + " message " + message);
    }
    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close " + url);
    }

    //스프링 빈이 스프링에 의존하지 않는다
    @PostConstruct
    public void init()  {
        //생성 시점에 호출
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }
    @PreDestroy
    public void close() {
        //종료 시점에 호출
        disconnect();
    }
}
