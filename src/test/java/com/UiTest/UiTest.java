package com.UiTest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class UiTest {
    @Test
    public void uiPostTest(){
            RestAssured.given().header("auth-key","d18f4f1f-2524-4fa0-8937-d93115d82e70").
                    and().param("q", "parramatta").and().param("state", "NSW").
                    when().get("https://digitalapi.auspost.com.au/postcode/search.json").
                    then().assertThat().body("localities.locality.postcode", equalTo(2150));
    }
}
