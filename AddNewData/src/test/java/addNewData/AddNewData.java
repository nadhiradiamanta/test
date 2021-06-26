package addNewData;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class AddNewData {

	@Test
	public void postRequest() {
		//Build request
		RestAssured
		.given()
		.log()
		.all()
		.baseUri("https://jsonplaceholder.cypress.io/")
		.basePath("posts")
		.body(
				"{\n" +
						"  \"title\": \"recommendation\",\n" +
						"  \"body\": \"motorcycle\",\n" +
				"  \"userId\": \"12\" \n}")
		.header("Content-type", "application/json")

		//Hit Request and get response
		.when()
		.post()

		//Validate JSON Response 
		.then()
		.statusCode(201)
		.log()
		.all();

	}

}
