package getRequest;


import BaseURLs.SwapiDevBaseURL;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojoDatas.SwapiDevApiPojos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class HomeWork06 extends SwapiDevBaseURL {

        /*
           Given
               https://swapi.dev/api/starships/3
          When
               Kullanıcı GET Methodu ile Request Gönderir
           Then
                Status Code un "200" olduğunu Assert et
           And
               Response body nin bu şekilde olduğunu doğrular
            {
       "name": "Star Destroyer",
       "model": "Imperial I-class Star Destroyer",
       "manufacturer": "Kuat Drive Yards",
       "cost_in_credits": "150000000",
       "length": "1,600",
       "max_atmosphering_speed": "975",
       "crew": "47,060",
       "passengers": "n/a",
       "cargo_capacity": "36000000",
       "consumables": "2 years",
       "hyperdrive_rating": "2.0",
       "MGLT": "60",
       "starship_class": "Star Destroyer",
       "pilots": [],
       "films": [
           "https://swapi.dev/api/films/1/",
           "https://swapi.dev/api/films/2/",
           "https://swapi.dev/api/films/3/"
       ],
       "created": "2014-12-10T15:08:19.848000Z",
       "edited": "2014-12-20T21:23:49.870000Z",
       "url": "https://swapi.dev/api/starships/3/"
   }
        */

    @Test
   public void homeWork06(){

       specification.pathParams("pathStarships","starships","pathId","3");



       List<String> films = new ArrayList<>();
       films.add("https://swapi.dev/api/films/1/");
       films.add("https://swapi.dev/api/films/2/");
       films.add("https://swapi.dev/api/films/3/");

       List<String> pilot = new ArrayList<>();

       SwapiDevApiPojos expectedData = new SwapiDevApiPojos("Star Destroyer",
               "Imperial I-class Star Destroyer",
               "Kuat Drive Yards",
               "150000000",
               "1,600",
               "975",
                "47,060",
                "n/a",
                "36000000",
                "2 years",
                "2.0",
                "60",
                "Star Destroyer",
                pilot,
                films,
                "2014-12-10T15:08:19.848000Z",
                "2014-12-20T21:23:49.870000Z",
               "https://swapi.dev/api/starships/3/");

       System.out.println("expectedData = " + expectedData);

       Response response = given().spec(specification).when().get("/{pathStarships}/{pathId}");

       response.prettyPrint();

       Map<String,Object> actualData = response.as(HashMap.class);
       System.out.println("actualData: " + actualData);

       response.then().assertThat().statusCode(200);
       Assert.assertEquals(expectedData.getName(),actualData.get("name"));
       Assert.assertEquals(expectedData.getModel(),actualData.get("model"));
       Assert.assertEquals(expectedData.getManufacturer(),actualData.get("manufacturer"));
       Assert.assertEquals(expectedData.getCost_in_credits(),actualData.get("cost_in_credits"));
       Assert.assertEquals(expectedData.getLength(),actualData.get("length"));
       Assert.assertEquals(expectedData.getMax_atmosphering_speed(),actualData.get("max_atmosphering_speed"));
       Assert.assertEquals(expectedData.getCrew(),actualData.get("crew"));
       Assert.assertEquals(expectedData.getPassengers(),actualData.get("passengers"));
       Assert.assertEquals(expectedData.getCargo_capacity(),actualData.get("cargo_capacity"));
       Assert.assertEquals(expectedData.getConsumables(),actualData.get("consumables"));
       Assert.assertEquals(expectedData.getHyperdrive_rating(),actualData.get("hyperdrive_rating"));
       Assert.assertEquals(expectedData.getMGLT(),actualData.get("MGLT"));
       Assert.assertEquals(expectedData.getStarship_class(),actualData.get("starship_class"));
       Assert.assertEquals(expectedData.getPilots(),actualData.get("pilots"));
       Assert.assertEquals(expectedData.getFilms(),actualData.get("films"));
       Assert.assertEquals(expectedData.getCreated(),actualData.get("created"));
       Assert.assertEquals(expectedData.getEdited(),actualData.get("edited"));
       Assert.assertEquals(expectedData.getUrl(),actualData.get("url"));








    }

}