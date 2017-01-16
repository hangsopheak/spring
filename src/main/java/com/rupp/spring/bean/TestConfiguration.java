/***/
package com.rupp.spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * map to table test_table (id, message)
 * @author Sophea <a href='mailto:smak@dminc.com'> sophea </a>
 * @version $id$ - $Revision$
 * @date 2017
 */
@Configuration
public class TestConfiguration {
   
    /**
     *
         <beans>
           <bean id="testDomain" class="com.rupp.spring.domain.TestDomain" />
        </beans>

     * @return
     */
    @Bean("testDomain")
    public TestDomain testDomain() {
        return new TestDomain();    
    }
}
