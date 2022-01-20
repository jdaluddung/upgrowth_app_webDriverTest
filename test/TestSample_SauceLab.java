import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.List;

public class TestSample_SauceLab {
    public static final String USERNAME = "oauth-jldaluddung-081f4";
    public static final String ACCESS_KEY = "709eec17-930d-47b4-b73d-7a092a322c3d";
    public static final String URL = "http://" + "oauth-jldaluddung-081f4" + ":" + "709eec17-930d-47b4-b73d-7a092a322c3d" + "@ondemand.saucelabs.com:80/wd/hub";

    public static void main(String[] args) throws Exception {

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "macOS 10.12");
        caps.setCapability("version", "66.0");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

        driver.get("https://o2400.csb.app/");

        WebDriverWait wait = new WebDriverWait(driver, 60);

        // Verify the app is loaded
        // Wait until the application loads
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("root")));
        System.out.println("App is loaded successfully.");

        String  searchTerm;
        searchTerm = "sun"; //input search term here

        //Verify Search text field is present and input search term
        driver.findElement(By.id("bb-id-5")).sendKeys(searchTerm);
        System.out.println("Search text field is present and input search term successful.");

        //Verify Search button is present and can be clicked
        driver.findElement(By.cssSelector(".css-1d0xvst.css-63it0p.css-1qnz8fc.bb-Box.bb-Button")).click();
        System.out.println("Search button is present and clicked successfully.");

        //Verify Search is executed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".css-iykfb.css-63it0p.css-1qnz8fc.bb-Box.bb-Container")));
        System.out.println("Search executed successfully showing images with " + searchTerm + ":");

        List<WebElement> listBoxItems = driver.findElements(By.cssSelector("div[id^='bb-id-']"));

        for(WebElement item : listBoxItems) {
            String altValue;
            altValue = item.findElement(By.tagName("img")).getAttribute("alt");

            if (altValue.contains(searchTerm)) {
                System.out.println("true");
            } else {
                System.out.println("false - " + altValue);
            }

        }

        //Close the browser
        driver.quit();

    }
}