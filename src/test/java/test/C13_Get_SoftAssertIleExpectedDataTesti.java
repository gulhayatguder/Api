package test;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C13_Get_SoftAssertIleExpectedDataTesti {
    /*  http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
Response Body
{
"status": "success",
"data": {
    "id": 3,
    "employee_name": "Ashton Cox",
    "employee_salary": 86000,
    "employee_age": 66,

},
"message": "Successfully! Record has been fetched."
} */
    @Test
    public void get01(){
        // 1 - Gonderecegimiz Request icin gerekli olan URL hazirla
        String url="http://dummy.restapiexample.com/api/v1/employee/3";
        // 2 - Eger soruda bize verilmisse Expected Data hazirla

        JSONObject expData=new JSONObject();
        expData.put( "id",3);
        expData.put( "employee_name","Ashton Cox");
        expData.put( "employee_salary",86000);
        expData.put( "employee_age",66);
        expData.put("profile_image","");


        JSONObject expBody=new JSONObject();
        expBody.put("status","success");
        expBody.put("data",expData);
        System.out.println(expBody);


        // 3 - Bize donen Response'i Actual Data olarak kaydet

        Response response=given().when().get(url);
        response.prettyPrint();

        // 4 - Expected Data ile Actual Datayi karsilastirmamiz yani Assertion yapmamiz gerek
    }



}
