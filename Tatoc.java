


import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import junit.framework.Assert;

public class Tatoc {
	WebDriver driver;
	
	public  Tatoc(WebDriver driver) {
		this.driver=driver;
	}
	public void geturl() {
		
		driver.get("http://10.0.1.86/tatoc");
 	   driver.findElement(By.linkText("Basic Course"));
 	   textwrittenornot();
 	   driver.findElement(By.linkText("Basic Course")).click();
 	      
	}
	public void textwrittenornot()
    {        
			Assert.assertTrue("basic course is not displayed", driver.findElement(By.linkText("Basic Course")).isDisplayed());
              System.out.println("Basic course is written");
    }
	public void greenbox() {
		driver.findElement(By.className("greenbox"));
		verifyGreenBox();
		verifyOnlyOneGreenBoxIsDisplayed();
		driver.findElement(By.className("greenbox")).click();;
	}
	public void verifyGreenBox()
	{
		Assert.assertTrue("Green box is not displayed", driver.findElement(By.className("greenbox")).isDisplayed());
		Reporter.log("Green box is displayed");
	}
	public void verifyOnlyOneGreenBoxIsDisplayed()
	{
		int countGreen=0, countRed=0;
		List<WebElement> boxes=driver.findElements(By.cssSelector("div[class*='box']"));
		for(WebElement e: boxes)
		{
			String color=e.getAttribute("class");
			if(color.equals("redbox"))
				countRed++;
			else if(color.equals("greenbox"))
				countGreen++;
		}
		System.out.println("Number of red boxes: "+countRed);
		System.out.println("Number of green boxes: "+countGreen);
		//Assert.assertTrue("**[ASSERT FAILED]: Green box is more than 1", countGreen==1);
		Assert.assertEquals(1, countGreen);
		System.out.println("Green box is only 1 as expected");
		
	}
	public void frame() {
		driver.switchTo().frame(0);
		WebElement box1 = driver.findElement(By.xpath("//*[@id=\"answer\"]"));
		String Box1_color = box1.getAttribute("class");
		String Box2_color = "";
		while(!Box1_color.equals(Box2_color)){
			  
			    driver.switchTo().defaultContent();
			    driver.switchTo().frame(0);
			    driver.findElement(By.xpath("/html/body/center/a[1]")).click();
			    driver.switchTo().frame(0);
			    Box2_color=driver.findElement(By.id("answer")).getAttribute("class");
			     }
		
		   driver.switchTo().defaultContent();
		   driver.switchTo().frame(0);
		   repaint();
		   driver.findElement(By.linkText("Proceed")).click();
	}
	public void repaint()
	{
		  Assert.assertTrue("repaint is not written",driver.findElement(By.cssSelector("body > center > a:nth-child(7)")).isDisplayed());
		  System.out.println("repaint box 2 is visible");
	     // Assert.assertFalse("proceed is not written",!(driver.findElement(By.linkText("Proceed")).isDisplayed()));
	}
	public void drop() {
		Actions action = new Actions(driver);
		   WebElement drag= driver.findElement(By.id("dragbox"));
		 WebElement drop= driver.findElement(By.id("dropbox"));
		 action.dragAndDrop(drag, drop).perform();
		 proceed();
		   driver.findElement(By.linkText("Proceed")).click();
	} 
	public void proceed()
	  {
		  Assert.assertTrue("proceed is not displayed",driver.findElement(By.linkText("Proceed")).isDisplayed());
	       System.out.println("proceed is displayed");
	  }
	public void popup() {
		 driver.findElement(By.linkText("Proceed"));
		 text();
		
		   driver.findElement(By.linkText("Launch Popup Window")).click();
		   String parentwindow=driver.getWindowHandle();
		   String subWindow=null;
		   java.util.Set<String> windows = driver.getWindowHandles();
		   Iterator<String> itr = ((java.util.Set<String>) windows).iterator();
		   while(itr.hasNext()){
		   	subWindow = (String) itr.next();
		   }
		   driver.switchTo().window(subWindow);
		   driver.findElement(By.id("name")).sendKeys("abc");
		   driver.findElement(By.id("submit")).click();
		   driver.switchTo().window(parentwindow);
		   driver.findElement(By.linkText("Proceed")).click();
		   
	}
	 public void text()
	 {
	 	Assert.assertTrue("launch pop up window is not working", driver.findElement(By.linkText("Launch Popup Window")).isDisplayed());
	     System.out.println("launch pop window is properly working");
	 }
	 public void token() { 
		  driver.findElement(By.linkText("Generate Token"));
		  push();
		  driver.findElement(By.linkText("Generate Token")).click();
		   String token_value=driver.findElement(By.id("token")).getText();
		   String[] value 	=	 token_value.split(":");
		   Cookie cookies=new Cookie("Token",value[1].trim());
		   driver.manage().addCookie(cookies);
		   driver.findElement(By.linkText("Proceed")).click();

		 
	 }
	 public void push()
	 {
	 	Assert.assertTrue("Generate Token is not written", driver.findElement(By.linkText("Generate Token")).isDisplayed());
	 	System.out.println("Generate Token is written");
	 }

}