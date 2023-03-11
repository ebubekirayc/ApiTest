package BaseURLs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyRestApiBaseURL {

    protected RequestSpecification specification;

    //   https://dummy.restapiexample.com/api/v1 ---->> Base URL

    @Before
    public void setUpBaseURL(){
        specification = new RequestSpecBuilder().
                setBaseUri("https://dummy.restapiexample.com/api/v1").
                build();
    }
}
