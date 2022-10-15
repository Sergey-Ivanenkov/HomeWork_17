package in.reqres;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class ReqresInTest {

/*
https://reqres.in/api/*
 */

    @Test
    void loginSuccessfulTest() {
        TestData testData = new TestData();
        testData
                .setEmail("eve.holt@reqres.in")
                .setPassword("cityslicka");

        given()
                .log().uri()
                .log().body()
                .contentType(JSON)
                .body(testData)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    void registrationSuccessfulTest() {
        TestData testData = new TestData();
        testData
                .setEmail("eve.holt@reqres.in")
                .setPassword("pistol");

        given()
                .log().uri()
                .log().body()
                .contentType(JSON)
                .body(testData)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("id", is(4))
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    void registrationUnsuccessfulTest() {
        TestData testData = new TestData();
        testData
                .setEmail("sydney@fife");

        given()
                .log().uri()
                .log().body()
                .contentType(JSON)
                .body(testData)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing password"));

    }

    @Test
    void createTest() {
        TestData testData = new TestData();
        testData
                .setName("morpheus")
                .setJob("leader");

        given()
                .log().uri()
                .log().body()
                .contentType(JSON)
                .body(testData)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .body("name", is("morpheus"))
                .body("job", is("leader"))
                .body("id", notNullValue())
                .body("createdAt", notNullValue());
    }

    @Test
    void updateTest() {
        TestData testData = new TestData();
        testData
                .setName("morpheus")
                .setJob("zion resident");

        given()
                .log().uri()
                .log().body()
                .contentType(JSON)
                .body(testData)
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("name", is("morpheus"))
                .body("job", is("zion resident"))
                .body("updatedAt", notNullValue());
    }


}
