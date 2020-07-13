package resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import bsh.Capabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {

	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;

	public AppiumDriverLocalService appiumStartServer() {
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
		return service;

	}

	public static void emulatorStart() throws Throwable {
		try {
			Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Emulator.bat");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(6000);
	}

	public static AndroidDriver<AndroidElement> capabulities(String appName) throws IOException{
		// TODO Auto-generated method stub

		FileInputStream pf=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");

		Properties prop=new Properties();
		prop.load(pf);



		File f=new File("src/main/java");
		File fs=new File(f,prop.getProperty(appName));

		//ApiDemos-debug
		//API Demos for Android_v1.9.0_apkpure.com.apk
		//General-Store.apk
		DesiredCapabilities cap=new DesiredCapabilities();

		//cap.setCapability(MobileCapabilityType.DEVICE_NAME,"ZY2224FLQR");
		//AVIPie
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,prop.getProperty("emulator"));

		
		if(prop.getProperty("emulator").equalsIgnoreCase("AVIPie")) {
			try {
				emulatorStart();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else {
			// give real device name in the cap field
		}

		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		//cap.setCapability(MobileCapabilityType.VERSION, "5.1.1");//9.0
		cap.setCapability(MobileCapabilityType.VERSION, "9.0");//9.0

		cap.setCapability(MobileCapabilityType.PLATFORM, "Android");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());

		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);

		driver.manage().timeouts().implicitlyWait(16, TimeUnit.SECONDS);

		return driver;

	}

	public static void getScreenshot(String result) throws IOException
	{
		//time and date stamp
		String TD=systemDateAndTime();

		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\Screenshots\\"+TD+result+".png"));



	}
	public static String systemDateAndTime() {

		//system current time and date stamp.
		String date1 = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
		return date1;
	}


}
