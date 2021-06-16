package ua.kiev.prog.automation.base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseUITest {
    protected WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();          // Download lasted version of chromedrover .exe
        ChromeOptions options = new ChromeOptions();      // Оптимизация производительности
        options.addArguments("--start-maximized");        // Запускаем развернутым на все окно
        options.addArguments("--disable-web-security");   // Отключает политику CORS - https off
        options.addArguments("--no-proxy-server");        // Отключает proxi server

        //options.addArguments("--headless");               // Отключает UI
        //options.addArguments("--no-sandbox");           // Отключает ...

        driver = new ChromeDriver(options);  // Create driver
        driver.get("http://zvisno.com/");   // Go to url
        //driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod(){
        if(driver != null)
            driver.quit();                             // Close drover
    }
}
