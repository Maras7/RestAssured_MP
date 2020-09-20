import config.EmployeeConfig;
import config.EmployeeEndpoints;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class EmployeeTests extends EmployeeConfig {

    @Test
    public void getAllEmployees() {
        given()
                .log().all().
        when()
                .get("employees").
        then().
                log().all();
    }

    @Test
    public void createNewEmployee(){
        String newEmployee = "{\n" +
                "        \"employee_name\": \"michal\",\n" +
                "        \"employee_position\": \"Junior QA\",\n" +
                "        \"employee_salary\": \"100\",\n" +
                "        \"employee_age\": \"34\",\n" +
                "        \"isManager\": \"0\"\n" +
                "    }";
        given()
                .contentType(ContentType.JSON)
                .body(newEmployee);

        when()
                .post(EmployeeEndpoints.ALL_EMPLOYEES).
        then()
                .log()
                .all();
    }

    @Test
    public void updateEmployee(){

        String employee = "{\n" +
                "        \"id\": \"147\",\n" +
                "        \"employee_name\": \"michal\",\n" +
                "        \"employee_position\": \"Junior QA\",\n" +
                "        \"employee_salary\": \"100\",\n" +
                "        \"employee_age\": \"34\",\n" +
                "        \"isManager\": \"0\"\n" +
                "    }";
        given()
                .log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(employee)
        .when()
                .put("employees/147").
        then()
                .log().all();
    }

    @Test
    public void deleteEmployee(){
        given().
        when()
                .delete("employees/147").
        then();
    }



}
