package org.seuge.vetclinic.controllers.rest;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.seuge.vetclinic.entities.Cat;
import org.seuge.vetclinic.services.CrudService;
import org.seuge.vetclinic.util.JsonUtils;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.GenericGroovyXmlWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Cat controller unit tests
 *
 * @author Seuge
 * @since 1.0
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations = { "classpath:spring/context/*Context.xml" },
                      loader = GenericGroovyXmlWebContextLoader.class)
@WebAppConfiguration
public class CatApiControllerTest {

    private static final String BASE_CATS_API_URL = "/api/pets/cats";
    private static final String CREATE_URL_PART = "/";
    private static final String GET_URL_PART = "/%s";
    private static final String UPDATE_URL_PART = "/%s";
    private static final String DELETE_URL_PART = "/%s";

    @InjectMocks
    private CatApiController catApiController;

    @Mock
    private CrudService<Cat> catService;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = standaloneSetup(catApiController).build();
    }

    @Test
    @Ignore //FIXME: problem with mocking generic CatApiController: actual type parameters are incorrect
    public void testCreateEntityOk() throws Exception {
        Cat cat = new Cat();
        cat.setName("test_cat_name_1");

        when(catService.create(cat)).thenReturn(cat);

        mockMvc.perform(post(BASE_CATS_API_URL + CREATE_URL_PART)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JsonUtils.serializeToString(cat)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.TEXT_PLAIN))
                .andExpect(content().string(String.valueOf(1000L)));
    }

    @Test
    public void testGetEntityByIdOk() throws Exception {
        Long id = 1L;
        String name = "test_cat_name_1";

        Cat cat = new Cat();
        cat.setId(id);
        cat.setName(name);

        when(catService.getById(id)).thenReturn(cat);

        mockMvc.perform(get(BASE_CATS_API_URL + String.format(GET_URL_PART, id)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", equalTo(id.intValue())))
                .andExpect(jsonPath("$.name", equalTo(name)));
    }

    @Test
    @Ignore //FIXME: problem with mocking generic CatApiController: actual type parameters are incorrect
    public void testUpdateEntityOk() throws Exception {
        Long id = 1L;
        String name = "test_cat_name_1_updated";

        Cat cat = new Cat();
        cat.setName(name);

        Cat catUpdated = new Cat();
        catUpdated.setId(id);
        catUpdated.setName(name);

        when(catService.updateById(id, cat)).thenReturn(catUpdated);

        mockMvc.perform(put(BASE_CATS_API_URL + String.format(UPDATE_URL_PART, id))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JsonUtils.serializeToString(cat)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", equalTo(id.intValue())))
                .andExpect(jsonPath("$.name", equalTo(name)));
    }

    @Test
    public void testDeleteEntityByIdOk() throws Exception {
        Long id = 1L;

        Cat cat = new Cat();
        cat.setId(id);

        doNothing().when(catService).deleteById(id);

        mockMvc.perform(delete(BASE_CATS_API_URL + String.format(DELETE_URL_PART, id)))
                .andExpect(status().isNoContent());
    }
}
