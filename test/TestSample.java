import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class TestSample {
    public static void main(String[] args) throws Exception {

        // Set the property for webdriver.chrome.driver to be the location to your local download of chromedriver
        System.setProperty("webdriver.chrome.driver", "/Users/jldaluddung/Downloads/chromedriver");

        // Create new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // And now use this to visit the test app
        driver.get("https://o2400.csb.app/");

        WebDriverWait wait = new WebDriverWait(driver, 60);

        // Verify the app is loaded
        // Wait until the application loads
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("root")));
        System.out.println("App is loaded successfully.");

        String  searchTerm;
        searchTerm = "star"; //input search term here

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
