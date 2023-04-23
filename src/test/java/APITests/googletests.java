package APITests;

import Files.payload;
import Files.reusablemethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class googletests {
    public static void main(String args[]) throws IOException {
        //given - All input details
        //when - Submit the API - resource,http method
        //then - validate the response
        //content of the file to String -> content of the file can convert into Byto -> Byte data to String
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String newAddress = "70 updated address, Srilanka";

        //Create Place
        String createPlace = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").body(new String (Files.readAllBytes(Paths.get("C:\\Users\\saravanan.mu\\IdeaProjects\\APIDemoProject\\src\\test\\java\\Files\\testdata.json"))))
                .when().post("maps/api/place/add/json")
                .then().assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server", "Apache/2.4.41 (Ubuntu)")
                .extract().response().asString();
        System.out.println("The response is "+createPlace);
        //Extracting values from the response
        JsonPath jsonPath = reusablemethods.rawtoJson(createPlace); //JsonPath is used to extract values from json
        String placeId = jsonPath.getString("place_id");
        System.out.println("*******The place Id is: "+placeId);

        //Update Place
        given().log().all().queryParam("key","qaclick123").header("Content-Type", "application/json").body(payload.updatePlace(placeId,newAddress))
                .when().put("maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200).body("msg" , equalTo("Address successfully updated"));


        //Get Place
        String getPlace = given().log().all().queryParam("key","qaclick123").queryParam("place_id",placeId)
                .when().get("maps/api/place/get/json")
                .then().assertThat().log().all().statusCode(200).extract().asString();
        JsonPath jsonPath1 = reusablemethods.rawtoJson(getPlace);
        String actualAddress = jsonPath1.getString("address");
        System.out.println("*******The updated addresses is: "+actualAddress);
        Assert.assertEquals(newAddress,newAddress);
    }

}
