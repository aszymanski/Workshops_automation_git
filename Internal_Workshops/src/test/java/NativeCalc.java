import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;





public class NativeCalc {

    private AndroidDriver driver;

    @Before
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName","Appium");
        //capabilities.setCapability("deviceName","LG G2 Mini");
        capabilities.setCapability("deviceName","myEmulator2");
        capabilities.setCapability("uid","emulator-5554");
        //capabilities.setCapability("uid","LGD620875202e3");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceReadyTimeout","90");
        capabilities.setCapability("androidDeviceReadyTimeout","90");
        capabilities.setCapability("avdReadyTimeout","90");
        capabilities.setCapability("version","5.0.1");
        capabilities.setCapability("avd","myEmulator2");
        //capabilities.setCapability("appPackage","com.android.calculator2");
        //capabilities.setCapability("appActivity","com.android.calculator2.Calculator");
        //capabilities.setCapability("appWaitActivity","com.android.calculator2.Calculator");
        capabilities.setCapability("appPackage","com.sec.android.app.popcalculator");
        capabilities.setCapability("appActivity","com.sec.android.app.popcalculator.Calculator");
        capabilities.setCapability("appWaitActivity","com.sec.android.app.popcalculator.Calculator");

        capabilities.setCapability("noReset","true");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        Thread.sleep(1000);

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void sum() throws Exception {

            Thread.sleep(1000);

        driver.findElement(By.id("com.android.calculator2:id/digit_8")).click();

            Thread.sleep(1000);

        driver.findElement(By.id("com.android.calculator2:id/op_add")).click();

            Thread.sleep(1000);

        driver.findElement(By.id("com.android.calculator2:id/digit_8")).click();

            Thread.sleep(1000);

        driver.findElement(By.id("com.android.calculator2:id/eq")).click();

    }

    @Test
    public void sum2() throws Exception{

            Thread.sleep(1000);

        driver.findElement(By.id("com.android.calculator2:id/digit_4")).click();

            Thread.sleep(1000);

        driver.findElement(By.id("com.android.calculator2:id/op_add")).click();

            Thread.sleep(1000);

        driver.findElement(By.id("com.android.calculator2:id/digit_6")).click();

            Thread.sleep(1000);

        driver.findElement(By.id("com.android.calculator2:id/eq")).click();

    }

    @Test
    public void sum3() throws Exception{

            Thread.sleep(1000);

        driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();

            Thread.sleep(1000);

        driver.findElement(By.id("com.android.calculator2:id/op_add")).click();

            Thread.sleep(1000);

        driver.findElement(By.id("com.android.calculator2:id/digit_9")).click();

            Thread.sleep(1000);

        driver.findElement(By.id("com.android.calculator2:id/eq")).click();

    }

}
