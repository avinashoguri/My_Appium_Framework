package pageObjects;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GS_LestShop_PageObjects {

	AndroidDriver<AndroidElement> driver;
	public GS_LestShop_PageObjects(AndroidDriver<AndroidElement> driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	//@AndroidFindBy(id="com.androidsample.generalstore:id/nameFields")
	//public WebElement nameField;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement nameField;
	
	
	
	@AndroidFindBy(xpath="//*[@text='Female']")
	public WebElement female;
	
	
	
	@AndroidFindBy(id="android:id/text1")
	public WebElement countrySelect;
	
	@AndroidFindBy(xpath="//*[@text='Argentina']")
	public WebElement Argentina;
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement lestShopButton;
	
	
	
	
	
}
