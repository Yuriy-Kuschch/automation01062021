package ua.kiev.prog.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.kiev.prog.automation.base.BaseUITest;
import ua.kiev.prog.automation.tools.Wait;


public class TestClassTest extends BaseUITest {



    @Test
    public void testMethod() {
        WebElement tablets = driver.findElement(By.xpath("//nav[@id='menu']//ul/li[normalize-space()='Tablets']"));
        tablets.click();
        WebElement addToCard = driver.findElement(By.xpath("//div[@id='content']//div[contains(@class,'product-thumb')]//button[1]"));
        addToCard.click();
        Wait.sleep(20000);
        WebElement successMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-success')]"));
        Assert.assertTrue(successMessage.isDisplayed(), "Succes message is not displayed");
        Assert.assertTrue(successMessage.getText().contains("Успешно. Вы добавили"), "Succes message text is wrong");


        Wait.sleep(20000);
    }

}
