package postRequest;

import BaseURLs.RestfullBookerHerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojoDatas.BookingDatesPojoPost;
import pojoDatas.BookingPojoPost;

import static io.restassured.RestAssured.given;

public class HomeWork08 extends RestfullBookerHerokuappBaseUrl {
 /*
         Given
            https://restful-booker.herokuapp.com/booking
            {
                "firstname": "Drake",
                "lastname": "F.",
                "totalprice": 4000,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2022-09-05",
                    "checkout": "2023-06-01"
                 }
                 "additionalneeds": "Full Stack Test Automation Course with API and Appium"
             }
        When
 		    Kullanıcı POST metodu ile request göderir
 	    Then
              Status Code un 200 olduğu doğrulanır
 		And
 		      Response Body nin aşağıdaki gibi olduğu verify edilir
 		    {
    "bookingid": 3844,
    "booking": {
        "firstname": "Drake",
        "lastname": "F.",
        "totalprice": 4000,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2022-09-05",
            "checkout": "2023-06-01"
        },
        "additionalneeds": "Full Stack Test Automation Course with API and Appium"
    }
}
     */

    @Test
    public void post08(){
//step 1: Set Base URL
        specification.pathParam("bookingPath","booking");

//Step 2: Set Expected and Request Body
        BookingDatesPojoPost bookingDatesPojo=new BookingDatesPojoPost("2022-09-05","2023-06-01");
        BookingPojoPost reqBookingPojo=new BookingPojoPost("Drake","F.",4000,
                true,bookingDatesPojo,
                "Full Stack Test Automation Course with API and Appium");



//Step 3: Send a request

        Response response = given().spec(specification).contentType(ContentType.JSON).
                body(reqBookingPojo).when().post("/{bookingPath}");


        System.out.println("RESPOSE BODY: ");
        response.prettyPrint();
//step 4:

        BookingPojoPost actualData=response.as(BookingPojoPost.class);
        System.out.println("actualData = " + actualData);

        Assert.assertEquals(reqBookingPojo.getFirstname(),actualData.getFirstname());
        Assert.assertEquals(reqBookingPojo.getLastname(),actualData.getLastname());
        Assert.assertEquals(reqBookingPojo.getTotalprice(),actualData.getTotalprice());
        Assert.assertEquals(reqBookingPojo.getBokingdates().getCheckin(),actualData.getBokingdates().getCheckin());
        Assert.assertEquals(reqBookingPojo.getBokingdates().getCheckout(), actualData.getBokingdates().getCheckout());
        Assert.assertEquals(reqBookingPojo.getAdditionalneeds(),actualData.getAdditionalneeds());




    }

}
