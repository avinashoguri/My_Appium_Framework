package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GS_Checkout_PageObjects {
	
	AndroidDriver<AndroidElement> driver;
	

	public GS_Checkout_PageObjects(AndroidDriver<AndroidElement> driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);	
	}


	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	public List<WebElement> productsPrize;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement totalAmount;
	
	
	@AndroidFindBy(className = "android.widget.CheckBox")
	public WebElement checkBox;
	
	@AndroidFindBy(xpath="//*[@text='Please read our terms of conditions']")
	public WebElement termsAndCon;
	
	@AndroidFindBy(id="android:id/button1")
	public WebElement button1;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	public WebElement buttonProceed;
	
}
