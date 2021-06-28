package ua.kiev.prog.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.kiev.prog.automation.base.BaseUITest;
import ua.kiev.prog.automation.tools.Wait;
import ua.kiev.prog.automation.ui.pages.LoginPage;

import java.util.List;
import java.util.stream.Collectors;


public class LoginTest extends BaseUITest {

    static private String LOGIN_URL      =   ("http://zvisno.com/index.php?route=account/login");
    static private By ACCOUNT_LOCATOR    =   By.xpath("//div[@id='top-links']/ul/li/a/i[contains (@class, 'fa-user')]/..");
    static private By AUTH_LOCATOR       =   By.xpath("./following-sibling::ul/li[2]/a");
    /*static private By EMAIL_LOCATOR      =   By.xpath("//div[@id='content']//input[@id='input-email']");
    static private By PASSWD_LOCATOR     =   By.xpath("//div[@id='content']//input[@id='input-password']");
    static private By SUBMIT_LOCATOR     =   By.xpath("//div[@id='content']//input[@type='submit']");
    static private By ERROR_LOCATOR      =   By.xpath("//div[@id='account-login']//div[contains(@class, 'alert-danger')]");*/

    static private String EMAIL_VALID = "zuma13298@gmail.com";
    static private String EMAIL_INVALID = "zumaXXXX13298@gmail.com";
    static private String PASSWD_VALID = "2201";
    static private String PASSWD_INVALID = "2201XXXXXXXX";

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {EMAIL_VALID,               PASSWD_VALID, null},
                {EMAIL_VALID.toUpperCase(), PASSWD_VALID, null},
                {EMAIL_INVALID,             PASSWD_VALID, "Предупреждение: Не совпадает адрес электронной почты и/или пароль."},
                {EMAIL_VALID,                PASSWD_INVALID, "Предупреждение: Не совпадает адрес электронной почты и/или пароль."},
        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String email, String password, String errorMessage) {
        driver.get(LOGIN_URL);
        WebElement account          =    driver.findElement(ACCOUNT_LOCATOR);
        account.click();
        WebElement authLink         =   account.findElement(AUTH_LOCATOR);
        authLink.click();

        /*WebElement emailInput       =    driver.findElement(EMAIL_LOCATOR);
        WebElement passwordINPUT    =    driver.findElement(PASSWD_LOCATOR);
        WebElement submitBtn        =    driver.findElement(SUBMIT_LOCATOR);
        emailInput.sendKeys(email);
        passwordINPUT.sendKeys(password);
        submitBtn.click();*/
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        Wait.sleep(1000);
        /*List<WebElement> errorMessageList = driver.findElements(ERROR_LOCATOR);*/

        List<WebElement> errorMessages = loginPage.errorMessages;
        if (errorMessage == null) {
            Assert.assertEquals(errorMessages.size(),  0, "Error messages is shown" +
                    errorMessages.stream().map(WebElement::getText).collect(Collectors.toList()));

        } else {
            Assert.assertTrue(errorMessages.size() > 0, "There is no any message");
            Assert.assertEquals(errorMessages.get(0).getText(), errorMessage, "Error message is not as expected");
        }

    }


}
