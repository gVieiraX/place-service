package br.com.desafioapiplaces;

import br.com.desafioapiplaces.api.PlaceRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlaceServiceApplicationTests {
	@Autowired
	WebTestClient webTestClient;

	@Test
	void testCreatePlaceSuccess() {
		var name = "Valid Name";
		var state = "Valid State";
		var city = "Valid City";
		var slug = "valid-name";

		webTestClient
				.post()
				.uri("/places")
				.bodyValue(
						new PlaceRequest(name,state,city)
				)
				.exchange()
				.expectBody()
				.jsonPath("name").isEqualTo(name)
				.jsonPath("state").isEqualTo(state)
				.jsonPath("city").isEqualTo(city)
				.jsonPath("slug").isEqualTo(slug)
				.jsonPath("createdAt").isNotEmpty()
				.jsonPath("updatedAt").isNotEmpty();


	}


	@Test
	public void testCreatePlaceFailure() {
		var name = "";
		var state = "";
		var city = "";

		webTestClient
				.post()
				.uri("/places")
				.bodyValue(
						new PlaceRequest(name, state, city)
				)
				.exchange()
				.expectStatus().isBadRequest();
	}
	}


