package objects;

import base.BaseActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends BaseActions {
    // Лого
    private final By siteLogo = By.xpath("//div[contains(@class, 'AppHeader_header__logo')]");

    // Кнопка "Конструктор"
    private final By constructorButton = By.xpath("//ul[contains(@class," +
            "'AppHeader_header__list')]/li[1]/a");

    // Кнопка "Личный кабинет"
    private final By personalAccountButton = By.xpath("//a[contains(@class, 'AppHeader_header')" +
            "and contains(@href, 'account')]");

    @Step("Header -> click to personal account button")
    public void clickPersonalAccountButton(WebDriver driver){
        click(driver, personalAccountButton);
    }

    @Step("Header -> click to logo")
    public void clickLogo(WebDriver driver){
        click(driver, siteLogo);
    }

    @Step("Header -> click to constructor button")
    public void clickConstructButton(WebDriver driver){
        click(driver, constructorButton);
    }

}
