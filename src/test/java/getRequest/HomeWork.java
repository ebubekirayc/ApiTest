package getRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.contains;


public class HomeWork {

    @Test

    public void homeWork(){

/*
https://jsonplaceholder.typicode.com/todos/2/*Status code is 200
	And "completed" is false
	And "userId" is
	1 And "title" is "c«
	And header "Via" is "1.1 Vegur«
	And header "Server" is "cloudflare«
	And title is contains "qui«
*/



        String URL="https://jsonplaceholder.typicode.com/todos/2";

        Response response=given().when().get(URL);

        System.out.println("RESPONSE : ");
        response.prettyPrint();




        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("completed",equalTo(false));
        response.then().assertThat().body("userId",equalTo(1));
        response.then().body("title",equalTo("quis ut nam facilis et officia qui"));
        response.then().assertThat().headers("Via",equalTo("1.1 vegur"));
        response.then().assertThat().headers("Server",equalTo("cloudflare"));
        response.then().assertThat().body("title",containsString("qui"));
    }

}
