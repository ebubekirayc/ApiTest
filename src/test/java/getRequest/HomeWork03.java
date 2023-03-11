package getRequest;


import BaseURLs.DummyRestApiBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class HomeWork03 extends DummyRestApiBaseURL {

    @Test
    public void dummyTest(){

             /*

    Given
	   	    https://dummy.restapiexample.com/api/v1/employee/1

		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
		     Response body nin bu şekilde olduğunu doğrular
    {
    "status": "success",
    "data": {
        "id": 1,
        "employee_name": "Tiger Nixon",
        "employee_salary": 320800,
        "employee_age": 61,
        "profile_image": ""
    },
    "message": "Successfully! Record has been fetched."
}

*/
        specification.pathParams("employPath","employee","idPath","1");


       Response response = given().
               spec(specification).
               when().get("/{employPath}/{idPath}");

       response.prettyPrint();
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

       String expectedData ="{\n" +
                "    \"status\": \"success\",\n" +
                "    \"data\": {\n" +
                "        \"id\": 1,\n" +
                "        \"employee_name\": \"Tiger Nixon\",\n" +
                "        \"employee_salary\": 320800,\n" +
                "        \"employee_age\": 61,\n" +
                "        \"profile_image\": \"\"\n" +
                "    },\n" +
                "    \"message\": \"Successfully! Record has been fetched.\"\n" +
                "}";

       String actualData =  response.getBody().asString();


       Assert.assertEquals(expectedData,actualData);


    }







}