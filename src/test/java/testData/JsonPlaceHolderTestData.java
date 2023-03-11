package testData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class JsonPlaceHolderTestData {
    public static HashMap<String, Object> expectedData;

    public HashMap setUpDataTodos(){
        expectedData=new HashMap<>();

        expectedData.put("StatusCode",200);
        expectedData.put("Server","cloudflare");
        expectedData.put("userId",1);
        expectedData.put("id",2.0);
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("completed",false);

        return expectedData;


    }
    public HashMap setUpDataJson(){
        expectedData=new HashMap<>();


        expectedData.put("userId",10);
        expectedData.put("id",198);
        expectedData.put("title","quis eius est sint explicabo");
        expectedData.put("completed",true);

        return expectedData;


    }

    public HashMap<String,Object> setUpForPutReq(){

        expectedData=new HashMap<>();

        expectedData.put("userId",01);
        expectedData.put("title","CW FSQA API Tutorial");
        expectedData.put("completed",true);


        return expectedData;

    }


}
