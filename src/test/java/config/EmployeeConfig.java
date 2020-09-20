package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

public class EmployeeConfig {

    public static RequestSpecification employee_requestSpec;
    public static ResponseSpecification employee_responseSpec;

    @BeforeClass
    public static void setup(){

        employee_requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://manzhos.me")
                .setBasePath("/api/v1/")
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();

        employee_responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

        RestAssured.requestSpecification = employee_requestSpec;
        RestAssured.responseSpecification = employee_responseSpec;

    }
}
