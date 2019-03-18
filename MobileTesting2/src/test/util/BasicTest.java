package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BasicTest extends FunctionUtil {

    public static AppiumDriver driver;




    @BeforeSuite(alwaysRun = true)
    public void prepare(){
        FunctionUtil.emptyAllureResults();
        clearScreenshot();
    }

    @BeforeClass
    public void setUp() throws InterruptedException, MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "6.0.1");
        capabilities.setCapability("appPackage", "com.xiaomi.notes");
        capabilities.setCapability("app", "C:\\Users\\herby\\Downloads\\xiaomiNotes.apk");
        capabilities.setCapability("clearSystemFiles", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities );
        Thread.sleep(2000);


    }
    @AfterSuite(alwaysRun = true)
    public void tearDown(){
            driver.closeApp();

    }




}
