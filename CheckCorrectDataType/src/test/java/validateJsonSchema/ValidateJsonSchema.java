package validateJsonSchema;
import java.io.File;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class ValidateJsonSchema {

	@Test
	public static void validateJsonSchema() {
		//Build request
		RestAssured
		.given()
		.baseUri("https://jsonplaceholder.cypress.io/")
		.basePath("posts")

		//Hit Request and get response
		.when()
		.get()

		//Validate JSON Response to match JSON Schema
		.then()
		.log()
		.all()
		.statusCode(200)
		.body(JsonSchemaValidator
				.matchesJsonSchema(new File("C:\\Users\\User\\eclipse-workspace\\Bukalapak Test 1a\\CheckCorrectDataType\\src\\test\\java\\ValidateJsonSchema\\JsonSchema.json")));
	}

}
