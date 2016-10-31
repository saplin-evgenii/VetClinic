package org.seuge.vetclinic.dao;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seuge.vetclinic.entities.Cat;
import org.seuge.vetclinic.util.TestConsts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/context/*Context.xml")
@TestExecutionListeners({
                                DependencyInjectionTestExecutionListener.class,
                                TransactionalTestExecutionListener.class,
                                DbUnitTestExecutionListener.class
                        })
public class CatsTest {

    @Autowired
    private Cats cats;

    @Ignore
    @Test(timeout = TestConsts.DEFAULT_TEST_TIMEOUT)
    @DatabaseSetup(type = DatabaseOperation.DELETE, value = "datasets/cats/deleteOne.xml")
    @DatabaseTearDown(type = DatabaseOperation.DELETE, value = "datasets/cats/deleteOne.xml")
    public void testSave() throws Exception {
        Cat newCat = new Cat();
        newCat.setId(1_000_000L);
        newCat.setName("test_cat_name_1");
        cats.save(newCat);
        Cat cat = cats.findOne(1_000_000L);
        assertNotNull("Cat not found:", cat);
        assertEquals("Cat ids do not match:", 1_000_000L, (long) cat.getId());
        assertEquals("Cat names do not match:", "test_cat_name_1", cat.getName());
    }

    @Test(timeout = TestConsts.DEFAULT_TEST_TIMEOUT)
    @DatabaseSetup(type = DatabaseOperation.DELETE, value = "datasets/cats/deleteOne.xml")
    @DatabaseSetup(type = DatabaseOperation.INSERT, value = "datasets/cats/createOne.xml")
    @DatabaseTearDown(type = DatabaseOperation.DELETE, value = "datasets/cats/deleteOne.xml")
    public void testFindOne() throws Exception {
        Cat cat = cats.findOne(1_000_000L);
        assertNotNull("Cat not found:", cat);
        assertEquals("Cat ids do not match:", 1_000_000L, (long) cat.getId());
        assertEquals("Cat names do not match:", "test_cat_name_1", cat.getName());
    }

}
