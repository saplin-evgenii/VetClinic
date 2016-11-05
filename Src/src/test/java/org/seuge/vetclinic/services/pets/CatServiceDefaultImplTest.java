package org.seuge.vetclinic.services.pets;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.seuge.vetclinic.dao.Pets;
import org.seuge.vetclinic.entities.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Default cat service impl unit tests
 *
 * @author Seuge
 * @since 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/context/*Context.xml")
@Ignore
public class CatServiceDefaultImplTest {

    @InjectMocks
    @Autowired
    private PetService<Cat> catService;

    @Mock
    private Pets<Cat> cats;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateCat() throws Exception {
        long id = 1_000_000L;
        String name = "test_cat_name_1";

        Cat cat = new Cat();
        cat.setName(name);

        Cat catMock = new Cat();
        catMock.setId(id);
        catMock.setName(cat.getName());
        when(cats.save(cat)).thenReturn(catMock);

        Cat catCreated = catService.create(cat);

        verify(cats).save(any(Cat.class));
        assertEquals("Cat id returned differs from expected:", id, (long) catCreated.getId());
        assertEquals("Cat name returned differs from expected:", name, catCreated.getName());
    }

    @Test
    public void testGetCatById() throws Exception {
        long id = 1_000_000L;
        String name = "test_cat_name_1";

        Cat catMock = new Cat();
        catMock.setId(id);
        catMock.setName(name);
        when(cats.findOne(id)).thenReturn(catMock);

        Cat catFound = catService.getById(id);

        verify(cats).findOne(any(Long.class));
        assertEquals("Cat id returned differs from expected:", id, (long) catFound.getId());
        assertEquals("Cat name returned differs from expected:", name, catFound.getName());
    }

    @Test
    public void testUpdateCatById() throws Exception {
        long id = 1_000_000L;
        String name = "test_cat_name_1";
        String nameUpdated = "test_cat_name_1_updated";

        Cat cat = new Cat();
        cat.setId(id);
        cat.setName(name);

        Cat catMock = new Cat();
        catMock.setId(id);
        catMock.setName(name);
        when(cats.save(cat)).thenReturn(catMock);

        Cat catUpdated = catService.updateById(id, cat);

        verify(cats).save(any(Cat.class));
        assertEquals("Cat id returned differs from expected:", id, (long) catUpdated.getId());
        assertEquals("Cat name returned differs from expected:", name, catUpdated.getName());
    }
}
