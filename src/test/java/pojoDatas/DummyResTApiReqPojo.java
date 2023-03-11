package pojoDatas;

public class DummyResTApiReqPojo {



        /*
         {
    "status": "success",
    "data": {
        "name": "Drake F.",
        "salary": "40000",
        "age": "27",
        "id": 4545
    },
    "message": "Successfully! Record has been added."
}
         */


    private String status;
    private DummyRestApiPojo dummyRestApiPojo;
    private String message;

    public DummyResTApiReqPojo() {
    }

    public DummyResTApiReqPojo(String status, DummyRestApiPojo dummyRestApiPojo, String message) {
        this.status = status;
        this.dummyRestApiPojo = dummyRestApiPojo;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DummyRestApiPojo getDummyRestApiPojo() {
        return dummyRestApiPojo;
    }

    public void setDummyRestApiPojo(DummyRestApiPojo dummyRestApiPojo) {
        this.dummyRestApiPojo = dummyRestApiPojo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DummyResTApiReqPojo{" +
                "status='" + status + '\'' +
                ", dummyRestApiPojo=" + dummyRestApiPojo +
                ", message='" + message + '\'' +
                '}';
    }
}