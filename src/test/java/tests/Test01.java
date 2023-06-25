package tests;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Test01 {


    @Test
    public void test() {

        //1-End Point ve Request Body oluşturulur.
        String url = "https://restful-booker.herokuapp.com/booking";

        //2-Expected Data oluşturulur
        int expectedstatus = 200;

        //3- Requset (sorgu) gnderilir, dönen Responce (cevap) kaydedilir.

        Response response = given()
                .when()
                .get(url);

        response.prettyPrint();
        System.out.println(response.getContentType());


        //4- Assertion
        //statüs code 200 olduğunuı dğrula
        Assert.assertEquals(expectedstatus, response.statusCode());

    }
}
