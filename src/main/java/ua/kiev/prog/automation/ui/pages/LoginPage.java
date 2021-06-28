package ua.kiev.prog.automation.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import ua.kiev.prog.automation.base.BasePage;

import java.util.List;

public class LoginPage extends BasePage {

    /*static private By EMAIL_LOCATOR      =   By.xpath("//div[@id='content']//input[@id='input-email']");
    static private By PASSWD_LOCATOR     =   By.xpath("//div[@id='content']//input[@id='input-password']");
    static private By SUBMIT_LOCATOR     =   By.xpath("//div[@id='content']//input[@type='submit']");
    static private By ERROR_LOCATOR      =   By.xpath("//div[@id='account-login']//div[contains(@class, 'alert-danger')]");*/

    /*final  public WebElement emailInput       =  driver.findElement(EMAIL_LOCATOR);
    final  public WebElement passwordInput    =  driver.findElement(PASSWD_LOCATOR);
    final  public WebElement submitBtn        =  driver.findElement(SUBMIT_LOCATOR);*/
    /*final  public List<WebElement> errorMessageList = driver.findElements(ERROR_LOCATOR);*/

    @FindBy(xpath = "//div[@id='content']//input[@id='input-email']")
    public WebElement emailInput;

    @FindBy(xpath = "//div[@id='content']//input[@id='input-password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//div[@id='content']//input[@type='submit']")
    public WebElement submitBtn;

    @FindBys(@FindBy(xpath = "//div[@id='account-login']//div[contains(@class, 'alert-danger')]"))
    public List<WebElement> errorMessages;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitBtn.click();
    }
}
