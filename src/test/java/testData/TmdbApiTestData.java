package testData;

public class TmdbApiTestData {

    private  String apiKey="80d0ae2d4c11c5a68712b718924fca23";

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String formatted(String a){

        String b=String.format("{%s}",a);

        return b;

    }

}
