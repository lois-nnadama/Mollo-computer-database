package ComputerDB.base;


import ComputerDB.utilities.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class DriverInstance {

    public static WebDriver driver;

    @BeforeClass
    public static void setUp() throws IOException {

       if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/java/resources/drivers/chromedriver95.exe");

            driver = new ChromeDriver();

        }
        else if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "./src/main/java/resources/drivers/geckodriver-use.exe");

            driver = new FirefoxDriver();

        } else if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "./src/main/java/resources/drivers/msedgedriver.exe");
            driver = new EdgeDriver();

        }

    }


    @AfterClass
    public static void tearDown() {
        driver.close();

    }
}
