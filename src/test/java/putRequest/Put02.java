package putRequest;

import BaseURLs.RestfullBookerHerokuappBaseUrl;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.BookingDatesPojoPost;
import pojoDatas.BookingPojoPost;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put02 extends RestfullBookerHerokuappBaseUrl {

        /*
         Given
             1) https://restful-booker.herokuapp.com/booking/37
             2) {
     "firstname" : "Drake",
     "lastname" : "F..",
     "totalprice" : 4000,
     "depositpaid" : true,
     "bookingdates" : {
         "checkin" : "2022-01-01",
         "checkout" : "2023-01-01"
     },
     "additionalneeds" : "API and Appium"
 }
         3) Kullanıcı Auth. olarak ilk olarak  Header a Cookie ile daha sonra ise Basic Autoh ile  req bulunmalı.
             Authorization ==>>  Basic YWRtaW46cGFzc3dvcmQxMjM=

             Cookie =>>> token=001832eb39ba0ca
         When
              Kullanıcı Put Reques ile request gönderir
         Then
               Status code is 200
              Response body nin aşağıdaki gibi olduğunu verify eder.
                {
     "firstname" : "Drake",
     "lastname" : "F..",
     "totalprice" : 4000,
     "depositpaid" : true,
     "bookingdates" : {
         "checkin" : "2022-01-01",
         "checkout" : "2023-01-01"
     },
     "additionalneeds" : "API and Appium"
 }
      */


        //"token": "aa21cc6d140772f"

    @Test
    public void put02(){

        //Set URL
        //https://restful-booker.herokuapp.com/booking/37
        specification.pathParams("bookingPath","booking",
                "idPath","37");


        //Set Expected and Request Body

        /*
        {
    "firstname" : "Drake",
    "lastname" : "F..",
    "totalprice" : 4000,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2022-01-01",
        "checkout" : "2023-01-01"
    },
    "additionalneeds" : "API and Appium"
}
        */

       BookingDatesPojoPost bookingDatesPojoPost = new BookingDatesPojoPost("2022-01-01","2023-01-01");
        BookingPojoPost bookingPojoPost = new BookingPojoPost("Drake","F..",4000,true,bookingDatesPojoPost,"API and Appium");


       //System.out.println(restFulBookingPojo);
       //Step 3: Send a request;

       //Cookie  -----  token=<token_value>

       Response response = given().
               spec(specification).
               contentType(ContentType.JSON).
               header("Cookie","token=" + "84e4c34a78ccdb6").
               body(bookingPojoPost).
               when().
               put("/{bookingPath}/{idPath}");

       System.out.println("RESPONSE: ");
       response.prettyPrint();

       //Forbidden     ----->>>> Token değiştirdim

       //401  ----->> Unauth.     -----------------    Authj. ile ilgli herahngi bir value bulunmadığı zaman.
       //403 ------>> Forbidden    - - -- - -- - -- Token veya ilgili auth. metodu ne ise onunla ilgili oalrak value var fakat yanlış yahut expire olmuş olabilir.



       //Step 4: Assertion

       JsonPath jsonPath = response.jsonPath();
       assertEquals(jsonPath.getString("firstname"),bookingPojoPost.getFirstname());
       assertEquals(jsonPath.getString("lastname"),bookingPojoPost.getLastname());
       assertEquals(jsonPath.getInt("totalprice"),bookingPojoPost.getTotalprice());
       assertEquals(jsonPath.getBoolean("depositpaid"),bookingPojoPost.isDepositpaid());
       assertEquals(jsonPath.getString("bookingdates.checkin"),bookingDatesPojoPost.getCheckin());
       assertEquals(jsonPath.getString("bookingdates.checkout"),bookingDatesPojoPost.getCheckout());
       assertEquals(jsonPath.getString("additionalneeds"),bookingPojoPost.getAdditionalneeds());


    }

}
