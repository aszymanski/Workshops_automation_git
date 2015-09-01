import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EnterWeb {

    public AppiumDriver driver;
    String timeStamp = new SimpleDateFormat("yyyy.MM.dd_(HH-mm-ss)").format(new Date());

    public void takeScreenshot(String testName, String timeStamp) throws IOException {

        File file  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("test-output\\screens\\" + timeStamp + "\\" + testName + ".jpg"));
    }

    @BeforeClass
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("platformName","Android");
        //capabilities.setCapability("deviceName","LG G2 Mini");
        //capabilities.setCapability("uid","LGD620875202e3");
        capabilities.setCapability("deviceName","Galaxy S6");
        capabilities.setCapability("udid","03157df364ee5719");
        capabilities.setCapability("version","5.0.1");
        capabilities.setCapability("app","D://selendroid-test-app-0.16.0.apk");
        capabilities.setCapability("deviceReadyTimeout","35");
        capabilities.setCapability("androidDeviceReadyTimeout","35");
        capabilities.setCapability("noReset","false");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void enterWeb() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean webViewTab;

        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buttonStartWebview")));
        driver.findElement(By.id("buttonStartWebview")).click();
        webViewTab = driver.findElement(By.id("webviewTable")).isEnabled();

        takeScreenshot("Enter Web", timeStamp);

        Assert.assertEquals(webViewTab, true);
    }


}
