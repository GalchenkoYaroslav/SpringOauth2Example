package com.websystique.springmvc;

/**
 * Created by Yaroslav on 30.10.2016.
 */
import com.websystique.springmvc.configuration.DatabaseConfig;
import com.websystique.springmvc.domain.Employees2;
import com.websystique.springmvc.domain.Passports;
import com.websystique.springmvc.service.DetailService;
import com.websystique.springmvc.service.impl.DetailServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by Yaroslav on 10.09.2016.
 */

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class)
@WebAppConfiguration
public class CrudTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;


    @Resource
    private DetailService detailService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }


    @Test
    public void testGetCategories()throws Exception{
        Passports passports = detailService.getPassportsByName("bill");

     //   Employees2 employees2 = detailService.getEmployeeByName("bill");
        System.out.println("----------------IMAGE--------------------------------");
      //  System.out.println(employees2.getPhoto());
        System.out.println("----------------IMAGE--------------------------------");

        Assert.assertEquals("Юрій", passports.getName());
    }

}
