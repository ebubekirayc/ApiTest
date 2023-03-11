package getRequest;

import BaseURLs.GoRestCoBaseURL;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojoDatas.GorestCoInPojo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class HomeWork05 extends GoRestCoBaseURL {

     /*
        Given
            https://gorest.co.in/public/v2/users/697102
       When
            Kullanıcı GET Methodu ile Request Gönderir
        Then
             Status Code un "200" olduğunu Assert et
        And
            Response body nin bu şekilde olduğunu doğrular
   {
    "id": 713683,
    "name": "Chandni Sinha",
    "email": "chandni_sinha@ohara-sporer.name",
    "gender": "male",
    "status": "active"
}
*/

//1. step set url

    @Test

    public void homework05(){

//1. step set url
        specification.pathParams("Users","users","pathId","713683");
//2. step set expected data
        GorestCoInPojo expectedData= new GorestCoInPojo(713683,"Chandni Sinha","chandni_sinha@ohara-sporer.name","male","active");

        System.out.println("expectedData = " + expectedData);
//3.step send a request

        Response response =given().spec(specification).when().get("/{Users}/{pathId}");

response.prettyPrint();

//4.step Assertion

        Map<String,Object> actualData=response.as(HashMap.class);
        System.out.println("actualData = " + actualData);
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(expectedData.getId(),actualData.get("id"));
        Assert.assertEquals(expectedData.getName(),actualData.get("name"));
        Assert.assertEquals(expectedData.getEmail(),actualData.get("email"));
        Assert.assertEquals(expectedData.getGender(),actualData.get("gender"));
        Assert.assertEquals(expectedData.getStatus(),actualData.get("status"));


    }

}
