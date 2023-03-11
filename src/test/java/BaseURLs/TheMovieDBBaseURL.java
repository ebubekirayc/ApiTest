package BaseURLs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;

public class TheMovieDBBaseURL {

    //https://api.themoviedb.org/3

    protected RequestSpecification specification;
@Before
    public void setBaseURL(){

        specification=new RequestSpecBuilder().
                setBaseUri("https://api.themoviedb.org/3").
                build();


    }
}
