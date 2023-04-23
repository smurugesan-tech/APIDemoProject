package APITests;

import Files.payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class complexjsonparse {

    //Print No of courses returned by API
    //Print Purchase Amount
    //Print Title of the first course
    //Print All course titles and their respective Prices
    //Print no of copies sold by RPA Course
    //Verify if Sum of all Course prices matches with Purchase Amount

    public static void main(String args[]) {

        JsonPath jsonPath = new JsonPath(payload.mockCoursePrice());

        //Print No of courses returned by API
        int coursesCount = jsonPath.getInt("courses.size()");
        System.out.println("The No of courses is: " + coursesCount);

        //Print Purchase Amount
        String pAmount = jsonPath.getString("dashboard.purchaseAmount");
        System.out.println("The Purchase amount is: " + pAmount);

        //Print Title of the first course
        String firstTitle = jsonPath.get("courses[0].title");
        System.out.println(firstTitle);

        //Print All course titles and their respective Prices
        for (int i = 0; i < coursesCount; i++) {
            String title = jsonPath.get("courses[" + i + "].title");
            int prices = jsonPath.getInt("courses[" + i + "].price");
            System.out.println("The title is: " + title);
            System.out.println("The prices is: " + prices);
        }

        //Print no of copies sold by RPA Course
        for (int i = 0; i < coursesCount; i++) {
            if (jsonPath.get("courses[" + i + "].title").equals("RPA")) {
                int noCopes = jsonPath.getInt("courses[" + i + "].copies");
                System.out.println("The number of copies print " + noCopes);
                break;
            }
        }
        String noCopies = jsonPath.get("courses[2].copies").toString();
        System.out.println(noCopies);


        //Verify if Sum of all Course prices matches with Purchase Amount
        int actualTotalAmount = 0;
        for (int i = 0; i < coursesCount; i++) {

            int price = jsonPath.getInt("courses[" + i + "].price");
            int copies = jsonPath.getInt("courses[" + i + "].copies");
            int totalPrice = price * copies;
            actualTotalAmount = actualTotalAmount + totalPrice;
        }
        Assert.assertEquals(actualTotalAmount, jsonPath.getInt("dashboard.purchaseAmount"), "The actual value is not matching with the expected value");
    }

}
