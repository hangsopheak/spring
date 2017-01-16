/***/
package com.rupp.spring.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rupp.spring.bean.TestDomain;

/**
 * map to table test_table (id, message)
 * @author Sophea <a href='mailto:smak@dminc.com'> sophea </a>
 * @version $id$ - $Revision$
 * @date 2017
 */
@Configuration
public class AutowiredConfiguration {
   
    /**
         <beans>
           <bean id="testDomain" class="com.rupp.spring.domain.TestDomain" />
        </beans>

     * @return
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
