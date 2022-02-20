package hello.core.scan.filter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import hello.core.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

public class ComponentFilterAppConfigTest {
    @Test
    public void filterScan(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = applicationContext.getBean("beanA", BeanA.class);
        assertThat(beanA).isNotNull();

        assertThrows(
            NoSuchBeanDefinitionException.class,
            ()->applicationContext.getBean("beanB", BeanB.class)
        );
    }


    @Configuration
    @ComponentScan(includeFilters = @Filter( classes = MyIncludeComponent.class) //type Annotaion이 디폴트이다
                    ,excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)
    )
    static class ComponentFilterAppConfig{

    }
}
