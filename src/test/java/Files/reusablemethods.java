package Files;

import io.restassured.path.json.JsonPath;

public class reusablemethods {
    public static JsonPath rawtoJson(String response){
        JsonPath jsonPath = new JsonPath(response);
        return jsonPath;
    }
}
