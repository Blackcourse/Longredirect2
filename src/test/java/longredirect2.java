import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class longredirect2 {


    @Test
    public void testLongRedirect2() {
        String URL = "https://playground.learnqa.ru";
        Response response = RestAssured

                .given()
                .redirects()
                .follow(false)
                .when()
                .get(URL)
                .andReturn();

        int statuscode = response.getStatusCode();
        while (statuscode != 200) {
            System.out.println(URL);
            response = RestAssured
                    .given()
                    .redirects()
                    .follow(false)
                    .when()
                    .get(URL)
                    .andReturn();
            statuscode = response.statusCode();
            URL = response.getHeader("Location");
        }

        System.out.println(statuscode);
    }
}


