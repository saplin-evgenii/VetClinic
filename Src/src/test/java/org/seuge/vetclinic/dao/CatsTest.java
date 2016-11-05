package org.seuge.vetclinic.dao;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.seuge.vetclinic.entities.Cat;
import org.seuge.vetclinic.util.TestConsts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.util.Collection;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/context/*Context.xml")
@TestExecutionListeners({
                                DependencyInjectionTestExecutionListener.class,
                                TransactionalTestExecutionListener.class,
                                DbUnitTestExecutionListener.class
                        })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CatsTest {

    @Autowired
    private Pets<Cat> cats;

    /**
     * Find one cat by its id
     */
    @Test(timeout = TestConsts.DEFAULT_TEST_TIMEOUT)
    @DatabaseSetup(type = DatabaseOperation.DELETE, value = "datasets/cats/deleteOne.xml")
    @DatabaseSetup(type = DatabaseOperation.INSERT, value = "datasets/cats/createOne.xml")
    @DatabaseTearDown(type = DatabaseOperation.DELETE, value = "datasets/cats/deleteOne.xml")
    public void A_FindOne_ExistingCatId_CatWithThatId() throws Exception {
        Cat cat = cats.findOne(1_000_000L);
        assertNotNull("Cat not found:", cat);
        assertEquals("Cat ids do not match:", 1_000_000L, (long) cat.getId());
        assertEquals("Cat names do not match:", "test_cat_name_1", cat.getName());
    }

    /**
     * Find cats by the specified name
     */
    @Test(timeout = TestConsts.DEFAULT_TEST_TIMEOUT)
    @DatabaseSetup(type = DatabaseOperation.DELETE, value = "datasets/cats/deleteOne.xml")
    @DatabaseSetup(type = DatabaseOperation.INSERT, value = "datasets/cats/createOne.xml")
    @DatabaseTearDown(type = DatabaseOperation.DELETE, value = "datasets/cats/deleteOne.xml")
    public void B_FindByName_ExistingCatName_CatWithThatName() throws Exception {
        Collection<Cat> catsFound = cats.findByName("test_cat_name_1");
        assertFalse("No cat found by name:", catsFound.isEmpty());
        assertTrue("Cat with expected id not found:",
                catsFound.stream().anyMatch(cat -> cat.getId().equals(1_000_000L)));
    }

    /**
     * Delete one cat by its id
     */
    @Test(timeout = TestConsts.DEFAULT_TEST_TIMEOUT)
    @DatabaseSetup(type = DatabaseOperation.DELETE, value = "datasets/cats/deleteOne.xml")
    @DatabaseSetup(type = DatabaseOperation.INSERT, value = "datasets/cats/createOne.xml")
    public void C_Delete_ExistingCatId_CatWithThatIdNotExists() throws Exception {
        cats.delete(1_000_000L);
        // Tests are configured to run in order of declaration, so .findOne is expected to run properly after
        // A_FindOne_ExistingCatId_CatWithThatId
        // TODO: find a way to introduce DBUnit check for deleted objects to make tests run independently
        Cat cat = cats.findOne(1_000_000L);
        assertNull("Deleted cat found:", cat);
    }

    /**
     * Save cat info
     */
    @Test(timeout = TestConsts.DEFAULT_TEST_TIMEOUT)
    public void D_Save_CatWithRandomName_CatWithThatNameExistsAndOnlyOne() throws Exception {
        Cat newCat = new Cat();
        String catName = "test_cat_name_" + UUID.randomUUID().toString();
        newCat.setName(catName);
        cats.save(newCat);
        // Tests are configured to run in order of declaration, so .findByName and .delete is expected to run properly
        // after B_FindByName_ExistingCatName_CatWithThatName and C_Delete_ExistingCatId_CatWithThatIdNotExists
        // TODO: find a way to introduce DBUnit check for deleted objects to make tests run independently
        Collection<Cat> catsFound = cats.findByName(catName);
        assertFalse("Cat not found after save:", catsFound.isEmpty());
        assertEquals("Found multiple cats with specified name:", 1, catsFound.size());
        cats.delete(catsFound.iterator().next().getId());
    }

    /**
     * Update existing cat info
     */
    @Test(timeout = TestConsts.DEFAULT_TEST_TIMEOUT)
    @DatabaseSetup(type = DatabaseOperation.DELETE, value = "datasets/cats/deleteOne.xml")
    @DatabaseSetup(type = DatabaseOperation.INSERT, value = "datasets/cats/createOne.xml")
    @DatabaseTearDown(type = DatabaseOperation.DELETE, value = "datasets/cats/deleteOne.xml")
    public void E_Update_ExistingCatWithNewName_CatWithThatName() throws Exception {
        Cat cat = new Cat();
        cat.setId(1_000_000L);
        cat.setName("test_cat_name_1_updated");
        cats.save(cat);
        // Tests are configured to run in order of declaration, so .findOne is expected to run properly after
        // A_FindOne_ExistingCatId_CatWithThatId
        // TODO: find a way to introduce DBUnit check for deleted objects to make tests run independently
        Cat updatedCat = cats.findOne(1_000_000L);
        assertNotNull("Cat not found:", updatedCat);
        assertEquals("Cat not updated: names do not match", "test_cat_name_1_updated", updatedCat.getName());
    }

}
