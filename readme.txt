
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
   <bean id="testDomain" class="com.rupp.spring.domain.TestDomain" scope="singleton">
        <property name="message" value="message value"/>
   </bean>
   
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

see xml : Beans_autowired.xml
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

 @Required

The @Required annotation applies to bean property setter methods, as in the following example:

public class SimpleMovieLister {
    private MovieFinder movieFinder;
    @Required
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }
    // ...
}

@Autowired : JSR 330’s @Inject annotation can be used in place of Spring’s @Autowired annotatio

public class SimpleMovieLister {
    private MovieFinder movieFinder;
    @Autowired
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }
    // ...
}

Always use these annotations over concrete classes; not over interfaces.

@Service : It is used with service layer

@Resource /@Autowired : create bean object in side another class

@Repository : it is used for Dao Layer

@Controller :  annotation marks a class as a Spring Web MVC controller.


@Configuration

=============


EmployeeDAO.java and EmployeeDAOImpl.java

public interface EmployeeDAO 
{
    public EmployeeDTO createNewEmployee();
}
 
@Repository ("employeeDao")
public class EmployeeDAOImpl implements EmployeeDAO
{
    public EmployeeDTO createNewEmployee()
    {
        EmployeeDTO e = new EmployeeDTO();
        e.setId(1);
        e.setFirstName("Mak");
        e.setLastName("Sophea");
        return e;
    }
}

EmployeeManager.java and EmployeeManagerImpl.java


public interface EmployeeManager 
{
    public EmployeeDTO createNewEmployee();
}
 
 
@Service ("employeeManager")
public class EmployeeManagerImpl implements EmployeeManager
{
    @Autowired
    EmployeeDAO dao;
     
    public EmployeeDTO createNewEmployee()
    {
        return dao.createNewEmployee();
    }
}
EmployeeController.java
@Controller ("employeeController")
public class EmployeeController 
{
        @Autowired
    EmployeeManager manager;
     
    public EmployeeDTO createNewEmployee()
    {
        return manager.createNewEmployee();
    }
}

EmployeeDTO.java
public class EmployeeDTO {
 
    private Integer id;
    private String firstName;
    private String lastName;
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + "]";
    }
}

TestSpringContext.java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import com.howtodoinjava.demo.service.EmployeeManager;
 
public class TestSpringContext 
{
    public static void main(String[] args) 
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
 
        //EmployeeManager manager = (EmployeeManager) context.getBean(EmployeeManager.class);
         
        //OR this will also work
         
        EmployeeController controller = (EmployeeController) context.getBean("employeeController");
         
        System.out.println(controller.createNewEmployee());
    }
}
 
Output:
 
Jan 22, 2015 6:17:57 PM org.springframework.context.support.ClassPathXmlApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@1b2b2f7f: 
startup date [Thu Jan 22 18:17:57 IST 2015]; root of context hierarchy
Jan 22, 2015 6:17:57 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
 
INFO: Loading XML bean definitions from class path resource [applicationContext.xml]
 
Employee [id=1, firstName=Sophea, lastName=Mak]

