package hello.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService(); //자기자신을 가진 static 변수를 가진다
    
    public static SingletonService getInstance(){
        return instance;
    }
    private SingletonService(){
        //생성을 막기위한 private 생성자
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직");
    }
}
