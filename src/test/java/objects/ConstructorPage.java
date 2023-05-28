package objects;

import base.BaseActions;
import constants.ExpectedMessage;
import constants.TestData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class ConstructorPage extends BaseActions {
    // Кнопка "Войти в аккаунт"
    private final By loginButton = By.xpath("//button[contains(text(),'Войти в аккаунт')]");

    // Кнопка "Оформить заказ"
    private final By placeOrderButton = By.xpath("//button[contains(text(),'Оформить заказ')]");

    // Текст "Собери бургер"
    private final By buildBurgerText = By.xpath("//h1[contains(text(),'Соберите бургер')]");

    // Кнопка "Булки"
    private final By bunSection = By.xpath("//section[contains(@class, " +
            "'BurgerIngredients_ingredients')]/div/div[1]");

    // Кнопка "Соусы"
    private final By sauceSection = By.xpath("//section[contains(@class, " +
            "'BurgerIngredients_ingredients')]/div/div[2]");

    // Кнопка "Начинки"
    private final By fillingSection = By.xpath("//section[contains(@class, " +
            "'BurgerIngredients_ingredients')]/div/div[3]");

    @Step("Constructor page -> wait page loading")
    public void waitForLoadConstructorPage(WebDriver driver) {
        waitForLoadPage(driver, buildBurgerText);
    }

    @Step("Constructor page -> click to {element}")
    public void clickSectionButton(WebDriver driver, String element){
        By sectionElement = defineSection(element);
        if(element.equals(TestData.BUN_SECTION)) {
            click(driver, fillingSection);
            waitForScrollSectionProcess(driver);
        }
        click(driver, sectionElement);
        waitForScrollSectionProcess(driver);
    }

    private By defineSection(String element){
        switch (element) {
            case TestData.BUN_SECTION:
                return bunSection;
            case TestData.SAUCE_SECTION:
                return sauceSection;
            case TestData.FILLING_SECTION:
                return fillingSection;
        }
        return null;
    }

    @Step("Constructor page -> click to login button")
    public void clickLoginButton(WebDriver driver){
        click(driver, loginButton);
    }

    @Step("Constructor page -> check place order button")
    public void checkPlaceOrderButtonShown(WebDriver driver){
        waitForLoadConstructorPage(driver);
        assertTrue(ExpectedMessage.PLACE_ORDER_SHOWN,
                isElementPresent(driver, placeOrderButton));
    }

    @Step("Constructor page -> check that {element} displayed")
    public void checkThatSectionDisplayed(WebDriver driver, String element){
        By sectionElement = defineSection(element);
        assertTrue(ExpectedMessage.SELECTION_VISIBLE,
                checkAttributeContainsText(driver, sectionElement,
                        TestData.CLASS_ATTRIBUTE, TestData.CLASS_SELECTOR_VALUE));
    }
}
