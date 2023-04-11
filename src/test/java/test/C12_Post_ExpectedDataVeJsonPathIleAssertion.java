package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion {

/*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
                        Request body
                   {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                 "checkin" : "2021-06-01",
                                 "checkout" : "2021-06-10"
                                          },
                        "additionalneeds" : "wi-fi"
                    }
                        Response Body
                   {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                             }
                    }
         */

    @Test
    public void post01(){
        // 1 - Gonderecegimiz Request icin gerekli olan URL ve Request Body hazirla

        String url="https://restful-booker.herokuapp.com/booking";

        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin", "2021-06-01");
        bookingdates.put("checkout","2021-06-10");

        JSONObject requestBody=new JSONObject();

        requestBody.put("firstname" , "Ahmet");
        requestBody.put("lastname" , "Bulut");
        requestBody.put("totalprice" , 500);
        requestBody.put("depositpaid" , false);
        requestBody.put("bookingdates" ,bookingdates);
        requestBody.put("additionalneeds" , "wi-fi");



        // 2 - Eger soruda bize verilmisse Expected Data hazirla
        JSONObject expBody=new JSONObject();

        expBody.put("bookingid",24);
        expBody.put("booking",requestBody);
        System.out.println("expBody"+expBody);

        // 3 - Bize donen Response'i Actual Data olarak kaydet

        Response response=given()
                               .contentType(ContentType.JSON)
                          .when()
                               .body(requestBody.toString())
                          .post(url);
        response.prettyPrint();
        // 4 - Expected Data ile Actual Datayi karsilastirmamiz yani Assertion yapmamiz gerek
        JsonPath resJSPath=response.jsonPath();
        Assert.assertEquals(expBody.getJSONObject("booking").get("firstname"),resJSPath.get("booking.firstname"));
        Assert.assertEquals(expBody.getJSONObject("booking").get("lastname"),resJSPath.get("booking.lastname"));
        Assert.assertEquals(expBody.getJSONObject("booking").get("totalprice"),resJSPath.get("booking.totalprice"));
        Assert.assertEquals(expBody.getJSONObject("booking").get("depositpaid"),resJSPath.get("booking.depositpaid"));
        Assert.assertEquals(expBody.getJSONObject("booking").get("additionalneeds"),resJSPath.get("booking.additionalneeds"));
        Assert.assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates")
                                                                      .get("checkin"),resJSPath.get("booking.bookingdates"));

        Assert.assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates")
                                                                      .get("checkout"),resJSPath.get("booking.bookingdates"));
    }
}
