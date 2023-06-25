package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Test03 {

    /*
   https://jsonplaceholder.typicode.com/posts url’ine asagidaki body ile bir POST request
        gonderdigimizde
            {
            "title":"API",
            "body":"API ogrenmek ne guzel",
            "userId":10,
            }


            donen Response’un,
            status code’unun 201,
            ve content type’inin application/json
            ve Response Body'sindeki,
            "title"'in "API" oldugunu
            "userId" degerinin 100'den kucuk oldugunu
            "body" nin "API" kelimesi icerdigini
            test edin.
            }
     */

    @Test
    public void test(){
        //1-End Point ve Request Body oluşturulur.
        String url="https://jsonplaceholder.typicode.com/posts"; //End point

        JSONObject requestbody=new JSONObject();
        requestbody.put("title","API");
        requestbody.put("body","API ogrenmek ne guzel");
        requestbody.put("userId",10);
        //2-Expected Data oluşturulur


        //3- Requset (sorgu) gnderilir, dönen Responce (cevap) kaydedilir.

        Response response=given().contentType(ContentType.JSON)
                         .when().body(requestbody.toString())
                            .post(url);

        //response.prettyPrint();

        //4- Assertion

       response
               .then()
               .assertThat()
               .statusCode(201)
               .contentType("application/json")
               .body("title", Matchers.equalTo("API"))
               .body("userId",Matchers.lessThan(100))
               .body("body", Matchers.containsString("API"));


    }
}
