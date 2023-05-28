package base;

import api.UserApiAction;
import constants.TestData;
import constants.Url;
import generation.GenerateUserData;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import objects.*;
import org.openqa.selenium.WebDriver;
import resources.UserCard;
import resources.UserTokenCard;

public class BaseTest extends BaseSettings {
    public WebDriver driver;
    protected final ConstructorPage constructorPage = new ConstructorPage();
    protected final RegPage regPage = new RegPage();
    protected final LoginPage loginPage = new LoginPage();
    protected final RecoverPassPage recoverPassPage = new RecoverPassPage();
    protected final PersonalPage personalPage = new PersonalPage();
    protected final UserApiAction userApiAction = new UserApiAction();
    protected final Header header = new Header();
    protected final GenerateUserData generateUserData = new GenerateUserData();
    protected UserCard userCard;
    private UserTokenCard userTokenCard;

    @Step("Open {browser} browser")
    protected void setBrowser(String browser) {
        driver = SetDriver(browser);
    }

    @Step("Open main page of site")
    protected void openMainPage(){
        driver.get(Url.STELLARBURGER_URL);
        constructorPage.waitForLoadConstructorPage(driver);
    }

    @Step("Generate new UserCard, count of symbols: {countOfSymbols}")
    protected void generateNewTestUserData(int countOfSymbols){
        userCard = generateUserData.generateNewUserCard(countOfSymbols);
        userTokenCard = new UserTokenCard(TestData.USER_NOT_CREATED);
    }

    @Step("Generate new UserCard, count of symbols: {TestData.COUNT_OF_SYMBOLS_6}")
    protected void generateNewTestUserData(){
        userCard = generateUserData.generateNewUserCard(TestData.COUNT_OF_SYMBOLS_6);
    }

    @Step("Create test-user by api")
    protected void createTestUserByApi(){
        generateNewTestUserData();
        Response response = userApiAction.postRequestCreateUser(userCard);
        saveUserToken(response);
    }

    private void saveUserToken(Response response){
        JsonPath jsonPathEvaluator = response.jsonPath();
        String userToken = jsonPathEvaluator.get("accessToken");
        userTokenCard = new UserTokenCard(userToken.substring(7));
    }

    @Step("Remove test-user by api")
    protected void removeTestUser(){
        if(userTokenCard == null)
        {
            saveUserToken(userApiAction.postRequestUserLogin(userCard));
        }
        if(!userTokenCard.getUserToken().equals(TestData.USER_NOT_CREATED)) {
            userApiAction.deleteRequestRemoveUser(userTokenCard.getUserToken());
        }
    }

    @Step("Open reg page")
    protected void openRegPage(){
        constructorPage.clickLoginButton(driver);
        loginPage.clickRegButton(driver);
    }

    @Step("Open login page")
    protected void openLoginPage(String element){
        switch (element) {
            case TestData.LOGIN_MAIN:
                constructorPage.clickLoginButton(driver);
                break;
            case TestData.LOGIN_ACCOUNT:
                header.clickPersonalAccountButton(driver);
                break;
            case TestData.LOGIN_REG_FORM:
                openRegPage();
                regPage.clickLoginButton(driver);
                break;
            case TestData.LOGIN_RESET_PASS:
                constructorPage.clickLoginButton(driver);
                loginPage.clickRecoverPassButton(driver);
                recoverPassPage.clickLoginButton(driver);
                break;
        }
        loginPage.waitForLoadLoginPage(driver);
    }

    @Step("Login as test-user")
    protected void loginTestUser(){
        header.clickPersonalAccountButton(driver);
        loginPage.fillLoginForm(driver, userCard);
        loginPage.clickLoginButton(driver);
        constructorPage.waitForLoadConstructorPage(driver);
    }

    @Step("Open personal account")
    public void openPersonalAccount(){
        header.clickPersonalAccountButton(driver);
        personalPage.waitForLoadPersonalPage(driver);
    }

    @Step("Open constructor by {element} click")
    protected void openConstructor(String element){
        switch (element) {
            case TestData.CONSTRUCTOR_BUTTON:
                header.clickConstructButton(driver);
                break;
            case TestData.SITE_LOGO:
                header.clickLogo(driver);
                break;
        }
        constructorPage.waitForLoadConstructorPage(driver);
    }
}
