package ComputerDB.utilities;

import ComputerDB.base.DriverInstance;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

public class Utility extends DriverInstance {

    public static Object fetchProperty(String key) throws IOException
    {
        FileInputStream file = new FileInputStream("./src/main/java/resources/config/config.properties");
        Properties property = new Properties();
        property.load(file);
        property.get(key);
        return property.get(key);
    }

    public static String fetchLocator(String key ) throws IOException {

        FileInputStream file = new FileInputStream("./src/main/java/resources/config/locators.properties");
        Properties property = new Properties();
        property.load(file);
        return 	property.get(key).toString();
    }

    public static String fetchText(String key ) throws IOException {

        FileInputStream file = new FileInputStream("./src/main/java/resources/config/text.properties");
        Properties property = new Properties();
        property.load(file);
        return 	property.get(key).toString();
    }

    public static String fn_GetTimeStamp() {
        DateFormat DF = DateFormat.getDateTimeInstance();
        Date dte = new Date();

        String DateValue = DF.format(dte);
        DateValue = DateValue.replaceAll(":", "_");
        DateValue = DateValue.replaceAll(",", "");
        return DateValue;
    }

    public static void captureScreenshot(String screenshotName){

        try
        {
            TakesScreenshot ts=(TakesScreenshot)driver;

            File source=ts.getScreenshotAs(OutputType.FILE);
            //byte[] source = ts.getScreenshotAs(OutputType.BYTES);
            //File source=ts.getScreenshotAs(OutputType.BYTES);

            File copyFile = (new File("./Screenshots/"+screenshotName+".png"));

            FileUtils.copyFile(source, copyFile);

            System.out.println("Screenshot taken at" + fn_GetTimeStamp());
        }
        catch (Exception e)
        {

            System.out.println("Exception while taking screenshot "+e.getMessage());
        }
    }



}
