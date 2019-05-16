package actor.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import actor.model.Actor;
import actor.repository.ActorRepository;


@RunWith(SpringRunner.class)
@WebMvcTest(value = ActorController.class)
public class ActorControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ActorRepository actorRepository;

	Optional<Actor> mockActor = Optional.of(new Actor(12l, "Turtoro","John", LocalDate.now()));


	@Test
	public void testGetActor() throws Exception {

		Mockito.when(
				actorRepository.findById(Mockito.anyLong())
				).thenReturn(mockActor);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/actor/10982").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{id:12,lastName:Turtoro,firstName:John}";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

}
