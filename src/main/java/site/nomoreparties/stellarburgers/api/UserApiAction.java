package site.nomoreparties.stellarburgers.api;

import site.nomoreparties.stellarburgers.constants.Url;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserApiAction extends BaseApi {
    public Response postRequestCreateUser(Object obj) {
        return given(RequestSpecification())
                .body(obj)
                .post(Url.API_CREATE_USER);
    }

    public Response postRequestUserLogin(Object obj) {
        return given(RequestSpecification())
                .body(obj)
                .post(Url.API_USER_LOGIN);
    }

    public void deleteRequestRemoveUser(String userToken){
        given(RequestSpecification())
                .auth().oauth2(userToken)
                .delete(Url.API_REMOVE_USER);
    }
}
