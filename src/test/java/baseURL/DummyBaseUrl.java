package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyBaseUrl {

    // http://dummy.restapiexample.com
     protected RequestSpecification specDummy;
     @Before
         public void setup () {
             specDummy = new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com").build();

     }
}
