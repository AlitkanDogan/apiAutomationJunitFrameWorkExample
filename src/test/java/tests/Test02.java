package tests;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Test02 {

    /*
    https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
        gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
     */


    @Test
    public void test(){

        //1-End Point ve Request Body oluşturulur.
        String url="https://restful-booker.herokuapp.com/booking/10";

        //2-Expected Data oluşturulur

        String expectedGetStatusLine="HTTP/1.1 200 OK";

        //3- Requset (sorgu) gnderilir, dönen Responce (cevap) kaydedilir.
        Response response=given()
                          .when()
                          .get(url);

      // System.out.println("statüs codu : "+response.statusCode()); //200
      // System.out.println("Content Type : "+response.getContentType()); //application/json; charset=utf-8,
      // System.out.println("header : "+response.getHeader("Server")); //Cowboy
      // System.out.println("statüs line : "+response.getStatusLine()); //Line’in HTTP/1.1 200 OK
      // System.out.println("responce time : "+response.getTime()); //1464

        String actualStatusLine=response.getStatusLine();
        //4- Assertion

        Assert.assertEquals(expectedGetStatusLine,actualStatusLine);


    }
}
