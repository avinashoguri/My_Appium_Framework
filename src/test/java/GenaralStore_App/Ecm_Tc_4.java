package GenaralStore_App;

import java.net.MalformedURLException;
import resources.Base;
import resources.Utills;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.GS_Checkout_PageObjects;
import pageObjects.GS_LestShop_PageObjects;
import pageObjects.GS_Store_PageObjects;

public class Ecm_Tc_4 extends Base{


	@Test
	public void cartSum() throws IOException, Throwable {


		appiumStartServer();
		Thread.sleep(10000);


		driver=capabulities("GeneralStore");


		GS_LestShop_PageObjects gl=new GS_LestShop_PageObjects(driver);

		gl.nameField.sendKeys("Hello");

		driver.hideKeyboard();
		gl.female.click();


		gl.countrySelect.click();

		Utills ut=new Utills(driver);

		ut.scrollToText("Argentina");
		gl.Argentina.click();
		gl.lestShopButton.click();

		GS_Store_PageObjects gs=new GS_Store_PageObjects(driver);

		gs.addToCart.get(0).click();
		gs.addToCart.get(0).click();
		gs.cartButton.click();
		Thread.sleep(4000);

		GS_Checkout_PageObjects gc=new GS_Checkout_PageObjects(driver);

		int count=gc.productsPrize.size();
		double sum=0;
		for(int i=0;i<count;i++) {
			String amount=gc.productsPrize.get(i).getText();
			sum+=getAmount(amount);
		}
		System.out.println("total sum : "+sum);

		String total=gc.totalAmount.getText();
		double totalAmount=getAmount(total);
		System.out.println("total amount "+totalAmount);
		Assert.assertEquals(totalAmount,sum);

		//Mobile Gestures

		WebElement checkbox=gc.checkBox;
		WebElement tc=gc.termsAndCon;
		ut.touchOptions(checkbox, tc);
		gc.button1.click();
		gc.buttonProceed.click();

		appiumStartServer().stop();

	}

	public static double getAmount(String value) {

		return Double.parseDouble(value.substring(1));

	}

}
