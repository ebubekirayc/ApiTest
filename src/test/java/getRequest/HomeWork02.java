package getRequest;

import BaseURLs.RestfullBookerHerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class HomeWork02 extends RestfullBookerHerokuappBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
             Kullanıcı GET Methodu ile Request Gönderir
         And
            Kullanıcı firstname olarak Sarah i aratır
        Then
            Status Code un "200" olduğunu Assert et
		And
            Response body de "bookingid" olduğunu verify eder.

*/

    @Test
    public void  restfullTest(){

        specification.pathParam("bookingPath","booking");
        specification.queryParam("firstname","Sarah ");

        Response response=given().spec(specification).
                when().
                get("/{bookingPath}");
        response.prettyPrint();




        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON);

        JsonPath jsonPath = response.jsonPath();


      try {
          jsonPath.getInt("[0].bookingid");
          Assert.assertTrue(true);

      }catch (NullPointerException e){

          Assert.fail("Bookingid bulunamadı");

        }


    }




}
