
@Bean & configuration

public class TestDomain {
    private String message;
    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }
    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}

Beans.xml

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">
    
    <!-- scope by default signgleton
        prototype, request, session, global-session
     -->
   <bean id="testDomain" class="com.rupp.spring.domain.TestDomain" scope="singleton"/>
   
</beans>
===========
 public static void main(String[] args) {        
        final ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        TestDomain objA = (TestDomain) context.getBean("testDomain");
        objA.setMessage("I'm object A");        
        System.out.println(objA.getMessage());
}
     


How to use autowired :

- xml annotation Autowired 

we have 2 classes :
 - TestDomain

public class TestDomain {
    private String message;
    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }
    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}

public class MyService {
    @Autowired
    private TestDomain testDomain;
    
    //@Autowired
    public MyService(TestDomain testDomain) {
        this.testDomain = testDomain;
    }
    public TestDomain getTestDomain() {
        return testDomain;
    }

    //@Autowired
    public void setTestDomain(TestDomain testDomain) {
        this.testDomain = testDomain;
    }
}

see xml : beans.xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context-3.0.xsd">
    
   <context:annotation-config/>

   <!-- Definition for textEditor bean without constructor-arg  -->
   <bean id="myService" class="com.rupp.spring.service.MyService">
   </bean>
    <!-- scope by default signgleton prototype, request, session, global-session  -->
   <bean id="testDomainss" class="com.rupp.spring.bean.TestDomain"/>
</beans>


Test MainClass
public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        
        final ApplicationContext context = new ClassPathXmlApplicationContext("Beans_autowired.xml");
        MyService myService = (MyService) context.getBean("myService");
        TestDomain objA = myService.getTestDomain();
        objA.setMessage("I'm object A");
        System.out.println(objA.getMessage());
    }

}
========Result========
I'm object A

Using Java Code Configuration

@Configuration
public class AutowiredConfiguration {
    /**
        <beans>
           <bean id="testDomain" class="com.rupp.spring.domain.TestDomain" />
        </beans>
     */
    @Bean("testDomain")
    public TestDomain testDomain() {
        return new TestDomain();    
    }
    @Bean
    public MyService myService() {
        return new MyService();
    }
}
=================
public static void main(String[] args) {
        
        /** otherway around annotation */
        final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AutowiredConfiguration.class);

        MyService myService = ctx.getBean(MyService.class);
        
        TestDomain obj = myService.getTestDomain();
        obj.setMessage("Another message with java configuration");
        System.out.println(obj.getMessage());
        
    }
===========
Result : Another message with java configuration





Annotation

@Service
@Resource
@Repository
@Controller
@Autowired
@Configuration


