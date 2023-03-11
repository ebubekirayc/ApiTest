package getRequest;

import BaseURLs.DummyRestApiBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get07 extends DummyRestApiBaseURL {

    /*
        Given
	   	    https://dummy.restapiexample.com/api/v1/employees
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
		     employee_age i 55'ten büyük olanları konsola yazdırınız.
		     8 tane olduğunu assert ediniz.
		And
            id si 17 den büyük olanları konsola yazdırınız
            7 tane olduğunu assert ediniz.
        And
            salary si 100.000'den az olanları konsola yazdırınız.
            Doris Wilder'ın bunlardan biri olduğunu assert ediniz.
        And



     */

    @Test
    public void get07(){
        /*
        1-set url
        2-set expected data
        3-send a request
        4-assertion
         */

        //step 1:

        specification.pathParam("employeesPath","employees");


        //step2: expected data (ignore)

        //setp 3: sen a request


        Response response=given().spec(specification).
                when().
                get("/{employeesPath}");
        response.prettyPrint();


        //step 4:
        JsonPath jsonPath=response.jsonPath();

        //test1 employee_age
        List<Integer> employeeAges=jsonPath.getList("data.employee_age");

        System.out.println("employeeAges = " + employeeAges);

        int count=0;

        for (Integer w: employeeAges){
            if (w>55){
                count++;
            }
        }
        System.out.println("count = " + count);
        assertEquals(8,count);

        //test 2->  id si 17 den büyük olanları konsola yazdırınız
        //            7 tane olduğunu assert ediniz

        List<Integer> idS=jsonPath.getList("data.findAll{it.id>17}.id");
        System.out.println("idS = " + idS);
        assertEquals(7,idS.size());

        //test 3 ödev verildi
        List<Integer> salary=jsonPath.
                getList("data.findAll{it.employee_salary<100000}.employee_name");
        System.out.println("employee_name = " +salary);
        Assert.assertTrue(salary.contains("Doris Wilder"));


    }


}
