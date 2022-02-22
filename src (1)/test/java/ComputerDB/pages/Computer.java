package ComputerDB.pages;

import ComputerDB.base.DriverInstance;
import ComputerDB.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;

public class Computer extends DriverInstance {


    public void GetUrl() throws IOException {
        driver.get(Utility.fetchProperty("URL").toString());
        driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1440, 803));
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

    }
    public void CreateComp() throws IOException {

        driver.findElement(By.xpath(Utility.fetchLocator("addnew_data_btn_xpath"))).click();
        driver.findElement(By.xpath(Utility.fetchLocator("add_compname_field_xpath"))).sendKeys("Test data");
        driver.findElement(By.xpath(Utility.fetchLocator("add_introduced_field_xpath"))).sendKeys("2022-02-21");
        driver.findElement(By.xpath(Utility.fetchLocator("add_discontinued_field_xpath"))).sendKeys("2022-02-21");

        driver.findElement(By.xpath(Utility.fetchLocator("select_company_xpath"))).click();
        driver.findElement(By.xpath(Utility.fetchLocator("select_company_xpath"))).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath(Utility.fetchLocator("select_company_xpath"))).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath(Utility.fetchLocator("create_data_btn_xpath"))).click();

        String success_msg = driver.findElement(By.xpath(Utility.fetchLocator("success_msg"))).getText();
        assertEquals(success_msg,"Done! Computer Test data has been created");
    }

    public void UpdateComp() throws IOException, InterruptedException {

        driver.findElement(By.xpath(Utility.fetchLocator("search_data_field_xpath"))).sendKeys("Test data");
        driver.findElement(By.xpath(Utility.fetchLocator("search_btn_xpath"))).click();
       String searched_data = driver.findElement(By.xpath(Utility.fetchLocator("select_searched_data_xpath"))).getText();

        assertEquals(searched_data,"Test data");


        driver.findElement(By.xpath(Utility.fetchLocator("select_searched_data_xpath"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("add_introduced_field_xpath"))).clear();
        driver.findElement(By.xpath(Utility.fetchLocator("add_introduced_field_xpath"))).sendKeys("2022-02-22");

        driver.findElement(By.xpath(Utility.fetchLocator("update_data_btn_xpath"))).click();

        String success_msg = driver.findElement(By.xpath(Utility.fetchLocator("success_msg"))).getText();
        assertEquals(success_msg,"Done! Computer Test data has been updated");


    }




    public void DeleteComp() throws IOException, InterruptedException {


        driver.findElement(By.xpath(Utility.fetchLocator("select_searched_data_xpath"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("delete_data_btn_xpath"))).click();


    }

    public void ViewComp() throws IOException {

        driver.findElement(By.xpath(Utility.fetchLocator("search_data_field_xpath"))).sendKeys("Test data");
        driver.findElement(By.xpath(Utility.fetchLocator("search_btn_xpath"))).click();
        String searched_data = driver.findElement(By.xpath(Utility.fetchLocator("select_searched_data_xpath"))).getText();



       assertEquals(searched_data,"Test data");
    }



}
