package APITests;

import Files.payload;
import Files.reusablemethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class dynamicjson {

    @Test(dataProvider = "BooksData")
    public void addBook(String isbn, String aisle) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().header("Content-Type", "application/json").body(payload.addBook(isbn,aisle))
                .when().post("/Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();

        System.out.println("The response data is" + response);
        JsonPath jsonPath = reusablemethods.rawtoJson(response);

        String bookID = jsonPath.get("ID");
        System.out.println("***************The book id is :" + bookID);
    }

    @DataProvider(name="BooksData")
    public Object[][] getData() {
        //array - collection of elements
        //multidimensional array - collection of arrays
        return new Object[][]{{"bqd", "8457"}, {"opi", "9845"}, {"wrl", "7516"}};

    }
}
