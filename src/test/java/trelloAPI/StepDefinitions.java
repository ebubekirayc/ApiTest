package trelloAPI;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testData.TrelloApiTestData;

import static io.restassured.RestAssured.given;

public class StepDefinitions {

        //token = ATTA6116293e2b6e1710a0769c4197ffbd2c7a7f23c95d476741e0255626dd2f37967CEC20DC
        //apikey = 7852a988d8215fe699b78a92c8aa400b

    public RequestSpecification specification;

    TrelloApiTestData trelloApiTestData = new TrelloApiTestData();

    Response response;

    String boardID;

    JsonPath jsonPath;

    @Given("Kullanıcı Trello icin Base URL set eder {string}")
    public void kullanıcı_Trello_icin_Base_URL_set_eder(String baseURL) {

        specification = new RequestSpecBuilder().
                setBaseUri(baseURL).
                build();
    }


    @When("Kullanıcı board create edebilmek icin ilgili url e POST methodu ve ilgili endpointler ile request atar {string},{string},{string},{string}")
    public void kullanıcı_board_create_edebilmek_icin_ilgili_url_e_POST_methodu_ve_ilgili_endpointler_ile_request_atar(String idPath, String id, String boardsPath, String boards) {

        /*
        specification.pathParams("idPath",1,
                "boardsPath","boards");
        */

//https://api.trello.com/1/boards/?name={name}&key=APIKey&token=APIToken'
        specification.pathParams(idPath,id,
                        boardsPath,boards).
                queryParams("name",trelloApiTestData.getBoardName(),
                        "key",trelloApiTestData.getKey(),
                        "token",trelloApiTestData.getToken());

        //string ifade var ---> idPAth ve boardsPath
        //{idPath}   {boardPAth}

        String idPathFormated = String.format("{%s}",idPath);
        System.out.println("idPathFormated: " + idPathFormated); //{idPath}

        String boardsPathFormated = String.format("{%s}",boardsPath);

        response = given().
                spec(specification).
                contentType(ContentType.JSON).
                when().
                post("/" + idPathFormated +"/" +boardsPathFormated + "/");

        // post("/{idPath}/{boardsPath}")
        System.out.println("RESPONSE Board Creation: ");
        response.prettyPrint();


    }
    @When("Kullanıcı board id yi alır")
    public void kullanıcı_board_id_yi_alır() {
        jsonPath = response.jsonPath();
        boardID = jsonPath.getString("id");
    }
    @Then("Kullanıcı boad un basarili bir sekilde create edildigini dogrular")
    public void kullanıcı_boad_un_basarili_bir_sekilde_create_edildigini_dogrular() {
        response.
                then().
                assertThat().
                statusCode(200);
    }


}