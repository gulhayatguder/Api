package test;

import baseURL.JsonPlaceHolderBaseURL;
import org.junit.Test;
import pojos.JsonPlaceHolderReqBodyPojo;

public class C25_Put_PojoClass extends JsonPlaceHolderBaseURL {
    /* https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir
PUT request yolladigimizda donen response’in response body’sinin asagida
verilen ile ayni oldugunu test ediniz
POJO CLASS ILE EXPECTED DATA TESTI
Request Body
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}

Expected Data :
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}
  */

    @Test
    public void put01() {
        //1-Url ve Body hazirla
        specJsonPlace.pathParams("pp1", "posts", "pp2", 70);
        JsonPlaceHolderReqBodyPojo reqBody = new JsonPlaceHolderReqBodyPojo("Ahmet", "Merhaba", 10, 70);


    }
}


