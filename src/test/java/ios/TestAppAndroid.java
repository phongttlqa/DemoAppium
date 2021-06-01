package ios;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.applitools.eyes.appium.Eyes;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestAppAndroid {

//	AndroidDriver<?> driver;
	AppiumDriver<MobileElement> driver = null;
	
 
    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app", "C:\\Users\\LQA\\AppData\\Local\\Android\\Sdk\\platform-tools\\calculator.apk");
        // khai báo platform
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        // khai báo deviceName
        cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        // Tìm app và cài đặt app
        driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    
    
    @Test
    public void x() { // dang khong tim duoc version chromedriver giống với emulator nen khong chay duoc
    	//AppiumDriver<MobileElement> driver = null;
//		try {
//			DesiredCapabilities caps = new DesiredCapabilities();
//			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
//			caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
//			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
//			caps.setCapability("browserName", "Chrome");
//			URL url;
//			url = new URL("http://0.0.0.0:4723/wd/hub");
//			driver = new AppiumDriver<MobileElement>(url, caps);
//			try {
//				driver.get("https://www.lotus-qa.com/");
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
    }
 
    @Test
    public void addTest() {
        WebElement button_2 = 
                driver.findElementById("com.google.android.calculator:id/digit_2");
        WebElement button_9 = 
                driver.findElementById("com.google.android.calculator:id/digit_9");
        WebElement op_mul = 
                driver.findElementById("com.google.android.calculator:id/op_mul");
        WebElement button_equal = 
                driver.findElementById("com.google.android.calculator:id/eq");
 
        button_2.click();
        op_mul.click();
        button_9.click();
        button_equal.click();
 
        WebElement result = 
                driver.findElementById("com.google.android.calculator:id/result");
        assertEquals(result.getText(), "18");
    }
 
    @Test
    public void mulTest() {
        WebElement button_1 = 
                driver.findElementById("com.google.android.calculator:id/digit_1");
        WebElement button_9 = 
                driver.findElementById("com.google.android.calculator:id/digit_9");
        WebElement op_add = 
                driver.findElementById("com.google.android.calculator:id/op_add");
        WebElement button_equal = 
                driver.findElementById("com.google.android.calculator:id/eq");
 
        button_1.click();
        op_add.click();
        button_9.click();
        button_equal.click();
 
        WebElement result = 
                driver.findElementById("com.google.android.calculator:id/result");
        assertEquals(result.getText(), "10");
    }
}
