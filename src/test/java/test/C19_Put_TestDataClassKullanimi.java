package test;

import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;

public class C19_Put_TestDataClassKullanimi extends JsonPlaceHolderBaseURL {

    /*  https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir
PUT request yolladigimizda donen response’in
status kodunun 200, content type’inin “application/json; charset=utf-8”,
Connection header degerinin “keep-alive”
ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
TEST DATA CLASS KULLANIMI
Expected Data :
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}
Request Body
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}
 */
   @Test
    public void put01(){
       //1- url hazirla
       specJsonPlace.pathParams("pp1","posts","pp2","70");
       TestDataJsonPlaceHolder testDataJsonPlaceHolder=new TestDataJsonPlaceHolder();
      JSONObject reqBody=testDataJsonPlaceHolder.expectedBodyOlusturJson();

      //2- Expectet data olustur
       JSONObject expBody=testDataJsonPlaceHolder.expectedBodyOlusturJson();

       //3-Response'i kaydet
       Response response=given().spec(specJsonPlace).contentType(ContentType.JSON).when().body(reqBody.toString()).put("/{pp1},{pp2}");
   }



}
