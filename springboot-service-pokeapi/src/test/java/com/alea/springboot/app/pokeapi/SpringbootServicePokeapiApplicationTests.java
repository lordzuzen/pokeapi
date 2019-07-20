package com.alea.springboot.app.pokeapi;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringbootServicePokeapiApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void sanityCheck() {
		String body = this.restTemplate.getForObject("/test", String.class);
		assertThat(body).isEqualTo("Running!");
	}
	
	@Test
	public void highestPokemons() {
		String body = this.restTemplate.getForObject("/highestPokemons", String.class);
		assertThat(body).contains("onix");
	}
	
	@Test
	public void heaviestPokemons() {
		String body = this.restTemplate.getForObject("/heaviestPokemons", String.class);
		assertThat(body).contains("snorlax");
	}
	
	@Test
	public void moreBaseExperiencePokemons() {
		String body = this.restTemplate.getForObject("/moreBaseExperiencePokemons", String.class);
		assertThat(body).contains("chansey");
	}
}
