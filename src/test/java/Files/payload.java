package Files;

public class payload {
    public static String addPlace() {
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Petta house\",\n" +
                "  \"phone_number\": \"(+91) 983 893 9937\",\n" +
                "  \"address\": \"29, Rameshwaram, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}\n";
    }

    public static String updatePlace(String placeID, String newAddress) {

        return "      {\n" +
                "            \"place_id\":\"" + placeID + "\",\n" +
                "                \"address\":\"" + newAddress + "\",\n" +
                "                \"key\":\"qaclick123\"\n" +
                "        }";

    }

    public static String mockCoursePrice() {

        return "{\n" +
                "\n" +
                "\"dashboard\": {\n" +
                "\n" +
                "\"purchaseAmount\": 910,\n" +
                "\n" +
                "\"website\": \"rahulshettyacademy.com\"\n" +
                "\n" +
                "},\n" +
                "\n" +
                "\"courses\": [\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"Selenium Python\",\n" +
                "\n" +
                "\"price\": 50,\n" +
                "\n" +
                "\"copies\": 6\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"Cypress\",\n" +
                "\n" +
                "\"price\": 40,\n" +
                "\n" +
                "\"copies\": 4\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"RPA\",\n" +
                "\n" +
                "\"price\": 45,\n" +
                "\n" +
                "\"copies\": 10\n" +
                "\n" +
                "}\n" +
                "\n" +
                "]\n" +
                "\n" +
                "}\n" +
                "\n";

    }


    public static String addBook(String isbn, String aisle) {
        return "{\n" +
                "    \"name\": \"Iearn Appium Automation with Java\",\n" +
                "    \"isbn\": \""+isbn+"\",\n" +
                "    \"aisle\": \""+aisle+"\",\n" +
                "    \"author\": \"Sarn foer\"\n" +
                "\n" +
                "}";

    }
}
