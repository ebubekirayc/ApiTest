package postRequest;

import BaseURLs.GoRestCoBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import testData.GoRestApiTestData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01 extends GoRestCoBaseURL {

    /*
    Given
        https://gorest.co.in/public/v2/users
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "422( Unprocessable entity)" olduğunu Assert et

   */

@Test
    public void post01(){
    specification.pathParam("usersPath","users");


    GoRestApiTestData goRestApiTestData=new GoRestApiTestData();
    System.out.println("Expected Test Data= " + goRestApiTestData.statusCodeForPostInvalid());

    Response response=given().
            spec(specification).
            when().
            header("Authorization","Bearer c0aa77eb8a368a7d991c8e10e6afb9756130abe80e29a6826477f8645165c7b0").
            post("/{usersPath}");

    System.out.println("Response : ");
    response.prettyPrint();

    //assertion

    //assertEquals(goRestApiTestData.statusCodeForPostInvalid(),response.getStatusCode());
    response.then().assertThat().statusCode(422);
}


}
