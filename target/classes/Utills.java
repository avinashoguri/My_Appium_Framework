package resources;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import org.openqa.selenium.WebElement;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.ElementOption;

public class Utills {


	AndroidDriver<AndroidElement> driver;

	public Utills(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;	
	}

	public void scrollToText(String text) {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");

	}

	public void touchOptions(WebElement tapping,WebElement longpress) {
		TouchAction t=new TouchAction(driver);
		t.tap(tapOptions().withElement(element(tapping))).perform();
		t.longPress(longPressOptions().withElement(element(longpress)).withDuration(ofSeconds(2))).release().perform();
		
	}


}
