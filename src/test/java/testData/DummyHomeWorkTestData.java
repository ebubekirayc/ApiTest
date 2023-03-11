package testData;

import java.util.HashMap;

public class DummyHomeWorkTestData {

    /*
 {
"status": "success",
"data": {
    "name": "Drake F.",
    "salary": "40000",
    "age": "27",
    "id": 4545
},
 */
    public HashMap<String,Object> bodyExpectedData(String status, String data, String name, String salary, String age, int id){
        HashMap<String,Object> bodyExpectedDataMap= new HashMap<>();
        bodyExpectedDataMap.put("status",status);
        bodyExpectedDataMap.put("data",data);
        bodyExpectedDataMap.put("name",name);
        bodyExpectedDataMap.put("salary",salary);
        bodyExpectedDataMap.put("age",age);
        bodyExpectedDataMap.put("id",id);


        return bodyExpectedDataMap;
    }
}
