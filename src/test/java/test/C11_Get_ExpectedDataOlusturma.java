package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C11_Get_ExpectedDataOlusturma {
    /* https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
yolladigimizda donen response body’sinin asagida verilen ile ayni oldugunu test
ediniz
Response body :
{
"userId": 3,
"id": 22,
"title": "dolor sint quo a velit explicabo quia nam",
"body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
}*/

    @Test
    public void get01() {
        JSONObject cepTel = new JSONObject();

        // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Request Body hazirla

        String url="https://jsonplaceholder.typicode.com/posts/22";
        // 2 - Eger soruda bize verilmisse Expected Data hazirla
        JSONObject expbody=new JSONObject();
        expbody.put("userId",3);
        expbody.put("id", 22);
        expbody.put("title","dolor sint quo a velit explicabo quia nam");
        expbody.put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        System.out.println(expbody);

        // 3 - Bize donen Response'i Actual Data olarak kaydet

        Response response=given().when().get(url);
        response.prettyPrint();
        // 4 - Expected Data ile Actual Datayi karsilastirmamiz yani Assertion yapmamiz gerek

                  //NOT:Dönen response'nin body'si ile islem yapmak
                  // istiyorsak bunu JSONPath objesine donusturmemiz gerekir
        JsonPath resJSPath=response.jsonPath();
        Assert.assertEquals(expbody.get("userId"),resJSPath.get("userId"));
        Assert.assertEquals(expbody.get("id"),resJSPath.get("id"));
        Assert.assertEquals(expbody.get("title"),resJSPath.get("title"));
        Assert.assertEquals(expbody.get("body"),resJSPath.get("body"));

    }
}