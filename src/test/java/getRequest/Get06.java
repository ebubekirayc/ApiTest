package getRequest;

import BaseURLs.GoRestCoBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class Get06 extends GoRestCoBaseURL {

    /*
        Given
            https://gorest.co.in/public/v2/todos/14091
        When
             Kullanıcı GET Methodu ile Request Gönderir
        Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
        And
            Response Body nin aşağıdai gibi olduğunu asssert et
       {
"id": 14071,
"user_id": 592752,
"title": "Pariatur spoliatio odit defaeco uberrime ambulo asperiores velut et eveniet.",
"due_on": "2023-03-20T00:00:00.000+05:30",
"status": "pending"
}
 */
@Test
    public void get06(){

    //step1: set url  https://gorest.co.in/public/v2/todos/14091


    specification.pathParams("todosPath","todos",
            "idPath","14071");


    //step 2: set expected data (ignore)


 //setp3 send request

    Response response = given().spec(specification).when().get("/{todosPath}/{idPath}");
    response.prettyPrint();

    //setp4: assertion

    //1. way
/*
    response.then().assertThat().statusCode(200).contentType(ContentType.JSON).body("user_id",equalTo(592752),
            "title",equalTo("Pariatur spoliatio odit defaeco uberrime ambulo asperiores velut et eveniet."),
            "due_on",equalTo("2023-03-20T00:00:00.000+05:30"),
            "status",equalTo("pending"));
*/


    //2.Way JSONPATH --> jsonPath bir clastır ve json objelei içerisende navigate etmemize sağlar

    JsonPath jsonPath = response.jsonPath();
    Assert.assertEquals(14071,jsonPath.getInt("id"));
    Assert.assertEquals(592752,jsonPath.getInt("user_id"));
    Assert.assertEquals("Pariatur spoliatio odit defaeco uberrime ambulo asperiores velut et eveniet.",jsonPath.getString("title"));
    Assert.assertEquals("2023-03-20T00:00:00.000+05:30",jsonPath.getString("due_on"));
    Assert.assertEquals("pending",jsonPath.getString("status"));


}



}
