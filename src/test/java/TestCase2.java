import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class TestCase2 {
    public RemoteWebDriver driver;
    @BeforeTest
    public void setup() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("MicrosoftEdge");
        EdgeOptions browserOptions = new EdgeOptions();
        browserOptions.setPlatformName("macOS Sierra");
        browserOptions.setBrowserVersion("87");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "prabhakarang1102");
        ltOptions.put("accessKey", "X3TsmCgVaCKAb2iycZUCYlHXTuk7eyf1SmcgnkcBcm0czm6qeG");
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("network", true);
        ltOptions.put("project", "Untitled");
        ltOptions.put("console", "true");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        browserOptions.setCapability("LT:Options", ltOptions);
        try {
            driver = new RemoteWebDriver(new URL("https://" + "prabhakarang1102" + ":" + "X3TsmCgVaCKAb2iycZUCYlHXTuk7eyf1SmcgnkcBcm0czm6qeG" + "@hub.lambdatest.com/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void test() {
        try {
            driver.get("https://www.lambdatest.com/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
            WebElement seeAllIntegrations = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[8]/div[1]/div[1]/div[1]/div[1]/a[1]"));
            WebElement Scroll_Down = driver.findElement(By.cssSelector("div[class='clearfix']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Scroll_Down);
            Actions actions = new Actions(driver);
            actions.keyDown(Keys.LEFT_CONTROL)
                    .click(seeAllIntegrations)
                    .keyUp(Keys.LEFT_CONTROL)
                    .build()
                    .perform();
            System.out.println("Website is opened in New Tab ");
            Set<String> windowHandles = driver.getWindowHandles();
            List<String> windows = new ArrayList<>(windowHandles);
            System.out.println("Total Windows open:" + windows.size());
            driver.switchTo().window(windows.get(1));
            try {
                Assert.assertEquals(driver.getCurrentUrl(), "https://www.lambdatest.com/integrations");
            } catch (AssertionError e) {
                System.out.println("The Name of the website is Incorrect");
            }
            WebElement codelessAutomation = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(4) > section:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(5) > div:nth-child(2) > div:nth-child(4)"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", codelessAutomation);
            WebElement test_whiz = driver.findElement(By.xpath("//a[contains(@href,\"https://www.lambdatest.com/support/docs/testingwhiz-integration/\")]"));
            test_whiz.click();
            try {
                Assert.assertEquals(driver.getTitle(), "TestingWhiz Integration | LambdaTest");
            } catch (AssertionError error) {
                System.out.println("The Name of the website is Incorrect");
            }
            driver.close();
            System.out.println("Current window count: " + driver.getWindowHandles().size());
            driver.switchTo().window(windows.get(0));
            driver.get("https://www.lambdatest.com/blog");
            driver.findElement(By.cssSelector("li[id='menu-item-10121'] a")).click();
            try {
                Assert.assertEquals(driver.getCurrentUrl(), "https://community.lambdatest.com/");

            } catch (AssertionError e) {
                System.out.println("The Name of the website is Incorrect");
            }
        }catch (Exception i){
            i.printStackTrace();
        }
    }
    @AfterTest
    public void teardown(){
        driver.close();
        driver.quit();
    }

}
