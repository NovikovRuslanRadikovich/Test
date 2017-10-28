import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class TestT {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver","C:\\Users\\ruslan\\Desktop\\geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "https://simplenote.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testT() throws Exception {
        driver.get(baseUrl + "/");
        Thread.sleep(500);
        driver.findElement(By.linkText("Sign in")).click();
        Thread.sleep(500);
        driver.findElement(By.id("password")).clear();
        Thread.sleep(400);
        driver.findElement(By.id("password")).sendKeys("BarcelonaBest");
        Thread.sleep(500);
        driver.findElement(By.id("email")).clear();
        Thread.sleep(500);
        driver.findElement(By.id("email")).sendKeys("ruslandia996@gmail.com");
        driver.findElement(By.cssSelector("input.submit.button")).click();

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("input.searchfield")).clear();
        driver.findElement(By.cssSelector("input.searchfield")).sendKeys("Novikov");
        driver.findElement(By.linkText("Add")).click();
        driver.findElement(By.cssSelector("li.with-1-preview-lines.selected")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("as-prompt")).sendKeys("Ruslan");
        Thread.sleep(3000);
        driver.findElement(By.id("txtarea")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("user_account_menu")).click();
        driver.findElement(By.id("signout")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("BarcelonaBest");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("ruslandia996@gmail.com");
    }
    @Test
    public void testTDelete() throws Exception {
        driver.get(baseUrl + "/");
        Thread.sleep(500);
        driver.findElement(By.linkText("Sign in")).click();
        Thread.sleep(500);
        driver.findElement(By.id("password")).clear();
        Thread.sleep(400);
        driver.findElement(By.id("password")).sendKeys("BarcelonaBest");
        Thread.sleep(500);
        driver.findElement(By.id("email")).clear();
        Thread.sleep(500);
        driver.findElement(By.id("email")).sendKeys("ruslandia996@gmail.com");
        driver.findElement(By.cssSelector("input.submit.button")).click();
        driver.findElement(By.cssSelector("input.searchfield")).clear();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input.searchfield")).sendKeys("ruslandia996@gmail.com");

        driver.findElement(By.id("tagmenu")).click();
        driver.findElement(By.linkText("All Notes")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("span.delete.tbutton")).click();
        driver.findElement(By.id("user_account_menu")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("signout")).click();

    }




    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
