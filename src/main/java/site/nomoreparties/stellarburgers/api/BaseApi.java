package site.nomoreparties.stellarburgers.api;

import site.nomoreparties.stellarburgers.constants.Url;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseApi {
    protected RequestSpecification RequestSpecification()
    {
        RestAssured.baseURI = Url.STELLARBURGER_URL;
        return RestAssured.given()
                .header("Content-type", "application/json");
    }
}
