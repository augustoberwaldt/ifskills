package br.edu.ifrs.canoas.lds.ifskills.controller;



import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import br.edu.ifrs.canoas.lds.ifskills.IFSkillsApplication;
import br.edu.ifrs.canoas.lds.ifskills.domain.Item;
import br.edu.ifrs.canoas.lds.ifskills.service.ItemService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(IFSkillsApplication.class)
@WebAppConfiguration
public class ItemControllerTest extends BaseControllerTest {

	@Autowired 
	ItemController itemController;
	
	@Autowired
    private ItemService itemService;

	@Before
	public void setup() {
		mockMvc = getMockMvc(itemController);
	}

	@Test
	public void testList() throws Exception {
		this.mockMvc.perform(post("/item/list"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("items"))
			.andExpect(model().attribute("items", hasSize(17)))
			.andExpect(model().attribute("items", hasItem(
                    allOf(
                            hasProperty("id", is(1L)),
                            hasProperty("name", is("Celular")),
                            hasProperty("description", is("Dispositivo de comunicação"))
                    )
            )))
			.andExpect(forwardedUrl(PRE_URL+"/item/list"+POS_URL))
			;
	}
	
	@Test
	public void testCreate() throws Exception {
		this.mockMvc.perform(post("/item/create"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("item"))
			.andExpect(model().attribute("item", hasProperty("name", isEmptyOrNullString())))
			.andExpect(model().attribute("readonly",is(false)))
			.andExpect(forwardedUrl(PRE_URL+"/item/form"+POS_URL))
			;
	}
	
	@Test
	public void testView() throws Exception {
		this.mockMvc.perform(post("/item/view/1"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("item"))
			.andExpect(model().attribute("item", hasProperty("name", is("Celular"))))
			.andExpect(model().attribute("readonly",is(true)))
			.andExpect(forwardedUrl(PRE_URL+"/item/form"+POS_URL))
			;
	}
	
	@Test
	public void testUpdate() throws Exception {
		this.mockMvc.perform(post("/item/edit/1"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("item"))
			.andExpect(model().attribute("item", hasProperty("name", is("Celular"))))
			.andExpect(model().attribute("readonly",is(false)))
			.andExpect(forwardedUrl(PRE_URL+"/item/form"+POS_URL))
			;
	}
	
	@Test
	public void testDeleteOk() throws Exception {
		
		assertThat(itemService.get(2L).getName(), is("Caneta"));
		
		this.mockMvc.perform(post("/item/delete/2"))
			.andExpect(flash().attributeExists("message"))
			;
		
		assertThat(itemService.get(2L), is(nullValue()));

	}
	
	@Test
	public void testDeleteFail() throws Exception {
		
		assertThat(itemService.get(100L), is(nullValue()));
		
		this.mockMvc.perform(post("/item/delete/100"))
		.andExpect(view().name("/item/form"))
		.andExpect(status().isOk())
		.andExpect(model().attribute("message", containsString("failed to delete")))
		;

	}
	
	@Test
	public void testSaveOk() throws Exception {
		
		Long size = itemService.list().spliterator().getExactSizeIfKnown();
		
		mockMvc.perform(post("/item/save")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name", "some name")
                .param("description", "some description")
                .sessionAttr("item", new Item())
        )
	    .andDo(MockMvcResultHandlers.print())
	    .andExpect(view().name(containsString("redirect:/item/view/")))
	    .andExpect(flash().attributeExists("message"))
	    ;
		
		assertThat(itemService.list().spliterator().getExactSizeIfKnown(), is(size + 1L));

	}
	
	@Test
	public void testSaveFail() throws Exception {
		
		Long size = itemService.list().spliterator().getExactSizeIfKnown();
		
		mockMvc.perform(post("/item/save")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("someParam", "some param")
                .sessionAttr("item", new Item())
        )
	    .andDo(MockMvcResultHandlers.print())
	    .andExpect(status().isOk())
	    .andExpect(view().name("/item/form"))
	    .andExpect(model().attribute("readonly", is(false)))
	    ;
		
		assertThat(itemService.list().spliterator().getExactSizeIfKnown(), is(size));

	}

}
