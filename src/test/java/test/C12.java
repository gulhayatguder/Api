package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C12 {


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
                        Response Body============>Expected body
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
    public void post01() {
        // 1 - Gonderecegimiz Request icin gerekli olan URL ve Request Body hazirla

        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject bookingDates=new JSONObject();

        bookingDates.put("checkin","2021-06-01");
        bookingDates.put("checkout", "2021-06-10");


        JSONObject booking=new JSONObject();
        booking.put("firstname", "Ahmet");
        booking.put("lastname" ,"Bulut");
        booking.put("totalprice",500);
        booking.put("depositpaid",false);
        booking.put("bookingdates" ,bookingDates);
        //2- Expected body hazirla

        JSONObject expBody=new JSONObject();
        expBody.put("bookingid",24);
        expBody.put("booking",booking);
        expBody.put("additionalneeds","wi-fi");

        System.out.println(expBody);
        //3- response'i kaydet
        Response response=given().contentType(ContentType.JSON).when().body(booking.toString()).post(url);
        //4-Assertion



    }
    }
