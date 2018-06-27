
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;


	
	public class Test_NG  {
		WebDriver driver;
		Tatoc obj;
		@BeforeTest
		public void setDiver()
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\akashtiwari\\Downloads\\chromedriver_win32\\chromedriver.exe");
			 
			driver=new ChromeDriver();
			obj = new Tatoc(driver);
		}
		
		
       @Test
       public void test1()
       {
    	   obj.geturl();
       }
	
       
       @Test
		public void test2() {
			obj.greenbox();
		}
		
	@Test
	public void test3()
	{ obj.frame();
}
  
  @Test
  public void test4()
  {obj.drop();
	  
	  
  }
 
 @Test
 public void test5()
 {
	obj.popup();
 }

@Test
public void test6()
{
	 obj.token();
}
	

}




	
	