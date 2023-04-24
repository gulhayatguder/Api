package testData;

import org.json.JSONObject;

public class TestDataDummy {

    public JSONObject Dummy() {

          /*Response Body
{
"status": "success",
"data": {
"id": 3,
"employee_name": "Ashton Cox",
"employee_name": "Ashton Cox",
"employee_age": 66,
"profile_image": ""
},
"message": "Successfully! Record has been fetched."
}
    * */
        JSONObject DataBody = new JSONObject();
        DataBody.put("id",3 );
        DataBody.put("employee_name","Ashton Cox" );
        DataBody.put("employee_name","Ashton Cox" );
        DataBody.put("employee_age",66 );
        DataBody.put("profile_image", "" );


        JSONObject expBody = new JSONObject();
         expBody.put("status","success");
         expBody.put("data",DataBody);
         expBody.put("message","Successfully! Record has been fetched.");



return expBody;

    }
}
