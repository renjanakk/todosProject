package Utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClass.baseClass;


public class utility extends baseClass{
	WebElement element;
	WebDriverWait wait;
	
	public static long IMPLICIT_WAIT=20;
	
	//scroll into view to see the element
	public void lookForElement(WebElement seeEle) {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView();", seeEle);		 
		 wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		 wait.until(ExpectedConditions.visibilityOf(seeEle));
	}
	
	//switch to frame
	public void switchToFrame(WebElement frameEle) {
		 driver.switchTo().frame(frameEle);
		 
	}
	
	//switch to parentFrame
	public void switchToparentFrame() {
		 driver.switchTo().frame(parentWindow);
	}
	
	//switch to other tabs
	public void switchToTabs(WebElement seeEle) {
		Set<String> allWindows=driver.getWindowHandles();
		Iterator<String> i=allWindows.iterator();
		while(i.hasNext()) {
			String childWindow=i.next();
			if (!childWindow.equalsIgnoreCase(parentWindow)) {
				driver.switchTo().window(childWindow);
				seeEle.click();
				//System.out.println("i--"+ i +" child--"+ childWindow);
			}
			else {
				//System.out.println("There are no children");
			}
		}
	}
	public void switchToAlert() {
		try {
			if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
				System.out.println("---alert was not present");
			} else {
				Alert alert = driver.switchTo().alert();
				alert.dismiss();
				System.out.println("---alert was present and accepted");
			}
		}
		catch(Exception e){
			System.out.println("---Check the \"switchToAlert()\" function code");
		}
	}
	
}
