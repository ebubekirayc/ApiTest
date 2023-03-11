package getRequest;

import BaseURLs.ApiZippopotamBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.ZippoPotamPlaces;
import pojoDatas.ZippoPotamPojos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get11 extends ApiZippopotamBaseURL {
    /*


        Given
            http://api.zippopotam.us/TR/34010
       When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
 		And
 		    Response body nin bu şekilde olduğunu doğrular

            {
    "post code": "34010",
    "country": "Turkey",
    "country abbreviation": "TR",
    "places": [
        {
            "place name": "Maltepe Mah.",
            "longitude": "32.3609",
            "state": "İstanbul",
            "state abbreviation": "34",
            "latitude": "40.1589"
        }
    ]
}

     */

    @Test

    public void get11(){

        //step1; set url
        specification.pathParams("countryPath","TR",
                "potCodePath","34010");

        //step2; set expected data

        ZippoPotamPlaces zippoPotamPlaces=new ZippoPotamPlaces("Maltepe Mah.","32.3609","İstanbul","34","40.1589");

        ZippoPotamPojos zippoPotamPojos=new ZippoPotamPojos("34010","Turkey","TR",zippoPotamPlaces);

        System.out.println("zippoPotamPojos = " + zippoPotamPojos);
        //3.step send a request

        Response response=given().spec(specification).when().get("/{countryPath}/{potCodePath}");
        //System.out.println("response = " + response);


        //4.step Assertion with GSON

        Map<String,Object>actualDataMap=response.as(HashMap.class);
        System.out.println("actualDataMap = " + actualDataMap);

        //get("Key")
        assertEquals(zippoPotamPojos.getCountry(),actualDataMap.get("country"));
        assertEquals(zippoPotamPojos.getPostCode(),actualDataMap.get("post code"));
        assertEquals(zippoPotamPojos.getCountryAbbreviation(),actualDataMap.get("country abbreviation"));
        assertEquals(zippoPotamPojos.getZippoPotamPlaces().getPlaceName(),(((Map)((List)actualDataMap.get("places")).get(0))).get("place name"));


        //devamı ödev



    }






}
