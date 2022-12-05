package ru.netology.Postman_echo;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {
    @Test
    void shouldReturnDemoAccounts() {
        // Given - When - Then
        // Предусловия
        String value = "some data";
        given()
                .baseUri("https://postman-echo.com")
                .body(value) // отправляемые данные (заголовки и query можно выставлять аналогично)
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo(value));
    }

    @Test
    void postRequestTest() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("пост запрос")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("пост запрос"));
    }

}
