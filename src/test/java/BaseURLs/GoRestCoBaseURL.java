package BaseURLs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GoRestCoBaseURL {


    protected RequestSpecification specification;

    //   https://gorest.co.in/public/v2 ---->> Base URL

    @Before
    public void setUpBaseURL(){
        specification = new RequestSpecBuilder().
                setBaseUri("https://gorest.co.in/public/v2").
                build();
    }
}
