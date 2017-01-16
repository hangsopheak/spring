/***/
package com.rupp.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.rupp.spring.bean.TestDomain;

/**
 * @author Sophea <a href='mailto:smak@dminc.com'> sophea </a>
 * @version $id$ - $Revision$
 * @date 2017
 */
public class MyService {

    @Autowired
    private TestDomain testDomain;
    
//    public MyService(TestDomain testDomain) {
//        this.testDomain = testDomain;
//    }
    /**
     * @return the testDomain
     */
    public TestDomain getTestDomain() {
        return testDomain;
    }

    /**
     * @param testDomain the testDomain to set
     */
    //@Autowired
    public void setTestDomain(TestDomain testDomain) {
        this.testDomain = testDomain;
    }
    
}
