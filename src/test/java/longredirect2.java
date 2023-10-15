import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class longredirect2 {


    @Test
    public void testLongRedirect2() {
        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get("https://playground.learnqa.ru/")
                .andReturn();

        String locationHeader = response.getHeader("Location");
        System.out.println(locationHeader);
        int statusCode = response.getStatusCode();
        while (statusCode != 200) {
           testLongRedirect2 (locationHeader)
        }
        System.out.println(statusCode);
    }
}
