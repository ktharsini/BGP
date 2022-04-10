package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class stepDefinition {

	WebDriver driver;	
	@Given("^User is on Login page and user will login with valid user name password$")
    public void user_is_on_login_page_and_user_will_login_with_valid_user_name_password() throws Throwable {
		 
			System.setProperty("webdriver.chrome.driver","C:\\Users\\thars\\Chrome\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
	        driver.get("https://qa-internet.bgp.onl/");
	        driver.manage().window().maximize();
			  
	        JavascriptExecutor js = (JavascriptExecutor)driver;
			WebElement element = driver.findElement(By.xpath("(//input[@id='signInFormUsername'])[1]"));
			js.executeScript("arguments[0].value='public'", element);		
			
			WebElement element1 = driver.findElement(By.xpath("(//input[@id='signInFormPassword'])[1]"));
			js.executeScript("arguments[0].click()", element1);
			js.executeScript("arguments[0].value='Let$BeC001'", element1);  
			
			JavascriptExecutor js1 = (JavascriptExecutor)driver;
			WebElement element2 = driver.findElement(By.xpath("(//input[@name='signInSubmitButton'])[1]"));
		    js1.executeScript("arguments[0].click()", element2);
    
			  boolean homepage = driver.findElement(By.id("sgds-nav-start")).isDisplayed();
			  Assert.assertTrue(homepage);
				   
 			 driver.findElement(By.id("login-button")).click();
			 
//	         ********************   Manual login page	  **********************  
			 
			 boolean corppass = driver.findElement(By.xpath("//*[text()='Manual Log In']")).isDisplayed();
			 Assert.assertTrue(corppass);
	 
			driver.findElement(By.xpath("(//input[@id='entityId'])[1]")).sendKeys("BGPQEDEMO");	    
		    driver.findElement(By.xpath("(//input[@id='userId'])[1]")).sendKeys("S1234567A");
		    driver.findElement(By.xpath("(//input[@id='userRole'])[1]")).sendKeys("Acceptor");
		    driver.findElement(By.xpath("(//input[@id='userFullName'])[1]")).sendKeys("Tan Ah Kow");
		    driver.findElement(By.xpath("(//button[@type='submit'])")).click();
	       
    }

 @When("^User enter into the new grant$")
    public void user_enter_into_the_new_grant() throws Throwable {
     
	 	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  JavascriptExecutor newgrant = (JavascriptExecutor)driver;
		  WebElement getngrant = driver.findElement(By.xpath("//*[text()='Get new grant']"));
		  newgrant.executeScript("arguments[0].click()", getngrant);
       		 
    }
 	
    @Then("^User will apply and proceed to the eligibility$")
    public void user_will_apply_and_proceed_to_the_eligibility() throws Throwable {
    	
    	
	     boolean myGbackText = driver.findElement(By.xpath("//span[@class='back-text']")).isDisplayed();
	     Assert.assertTrue(myGbackText);
	    
	     JavascriptExecutor pickselect = (JavascriptExecutor)driver;
         WebElement pickselector = driver.findElement(By.xpath("(//div[@class='itemname'])[7]"));		     	    				
	     pickselect.executeScript("arguments[0].click()", pickselector);
	
//	    	***************** Landed in I need this grant as overseas or SG  ****************
	    	
		    JavascriptExecutor pickarea = (JavascriptExecutor)driver;
		    WebElement pickgrant = driver.findElement(By.xpath("(//div[@class='itemname'])[1]"));
			pickarea.executeScript("arguments[0].click()", pickgrant);
	     
		
//		****************	What do you plan to do overseas with this grant?   ****************
			
			JavascriptExecutor pickMarket = (JavascriptExecutor)driver;
			WebElement pickMRA = driver.findElement(By.xpath("(//div[@class='itemname'])[1]"));
			pickMarket.executeScript("arguments[0].click()", pickMRA);
				 
			
			boolean  applybtn = driver.findElement(By.id("go-to-grant")).isEnabled();
			Assert.assertTrue(applybtn);
			driver.findElement(By.id("go-to-grant")).click();
					  
//	      	*********** Click the Proceed in the GRANT ACTIONS  *********************
			driver.findElement(By.id("keyPage-form-button")).click();
	    
    }
    
 	@When("^User verify the eligibility and faq$")
    public void user_verify_the_eligibility_and_faq() throws Throwable {
    
	 	String parentWindow = driver.getWindowHandle();
				
		JavascriptExecutor registersgno = (JavascriptExecutor)driver;
		WebElement optapplicantno = driver.findElement(By.xpath("(//span[@class ='radiobutton'])[2]"));
		registersgno.executeScript("arguments[0].click()", optapplicantno);
		
		boolean sgisno = driver.findElement(By.xpath("(//span[@class ='radiobutton'])[2]")).isEnabled();
		Assert.assertTrue(sgisno);
		driver.findElement(By.xpath("(//a[text()='FAQ'])[1]")).click();
		
							 
		 int winHandleNum = driver.getWindowHandles().size();
				 if(winHandleNum > 1)
				 {
					 for(String winHandle : driver.getWindowHandles())
					 	{
						 	driver.switchTo().window(winHandle);
					 	}
		
				 }
		 driver.close();
		 driver.switchTo().window(parentWindow);
				 
//****************** selecting yes for Singapore ************** 
										
		JavascriptExecutor registersgy = (JavascriptExecutor)driver;
		WebElement optapplicanty = driver.findElement(By.xpath("(//span[@class ='radiobutton'])[1]"));
		registersgy.executeScript("arguments[0].click()", optapplicanty);
		
		
//********	verify the second FAQ for sales turnover less than or equal to S$100m and employment size less than or equal to 200
		
		JavascriptExecutor salesturnno = (JavascriptExecutor)driver;
		WebElement optsalesturnno = driver.findElement(By.xpath("(//span[@class ='radiobutton'])[4]"));
		salesturnno.executeScript("arguments[0].click()", optsalesturnno);
		
		boolean salturno = driver.findElement(By.xpath("(//span[@class ='radiobutton'])[4]")).isEnabled();
		Assert.assertTrue(salturno);
		driver.findElement(By.xpath("(//a[text()='FAQ'])[2]")).click();
									 
		 int winHandleNum1 = driver.getWindowHandles().size();
				 if(winHandleNum1 > 1)
				 {
					 for(String winHandle : driver.getWindowHandles())
					 	{
						 	driver.switchTo().window(winHandle);
					 	}
			
				 }
			driver.close();
			driver.switchTo().window(parentWindow);

//******** selecting yes for sales turnover less than or equal to S$100m and employment size less than or equal to 200				 
			JavascriptExecutor salesturnovery = (JavascriptExecutor)driver;
			WebElement optappy = driver.findElement(By.xpath("(//span[@class ='radiobutton'])[3]"));
			salesturnovery.executeScript("arguments[0].click()", optappy);

//****************	verify the FAQ	for least 30 % ********************
			JavascriptExecutor least30no = (JavascriptExecutor)driver;
			WebElement optlocalno = driver.findElement(By.xpath("(//span[@class ='radiobutton'])[6]"));
			least30no.executeScript("arguments[0].click()", optlocalno);
		
			boolean lea30no = driver.findElement(By.xpath("(//span[@class ='radiobutton'])[6]")).isEnabled();
			Assert.assertTrue(lea30no);
			driver.findElement(By.xpath("(//a[text()='FAQ'])[2]")).click();
		
							 
			int winHandleNum3 = driver.getWindowHandles().size();
					if(winHandleNum3 > 1)
						{
							for(String winHandle : driver.getWindowHandles())
								{
									driver.switchTo().window(winHandle);
								}
			
						}
			 driver.close();
			 driver.switchTo().window(parentWindow);

//	************* selecting yes for least 30% ***************
			JavascriptExecutor least30y = (JavascriptExecutor)driver;
			WebElement optlocaly = driver.findElement(By.xpath("(//span[@class ='radiobutton'])[5]"));
			least30y.executeScript("arguments[0].click()", optlocaly);
		
//		************ verifying the FAQ new market  *********************
		
			JavascriptExecutor newmarketno = (JavascriptExecutor)driver;
			WebElement opttargetno = driver.findElement(By.xpath("(//span[@class ='radiobutton'])[8]"));
			newmarketno.executeScript("arguments[0].click()", opttargetno);
		
			boolean newmarkno = driver.findElement(By.xpath("(//span[@class ='radiobutton'])[8]")).isEnabled();
			Assert.assertTrue(newmarkno);
			driver.findElement(By.xpath("(//a[text()='FAQ'])[2]")).click();
			
					 
			int winHandleNum4 = driver.getWindowHandles().size();
					if(winHandleNum4 > 1)
						{
							for(String winHandle : driver.getWindowHandles())
								{
									driver.switchTo().window(winHandle);
								}
						}
			 driver.close();
			 driver.switchTo().window(parentWindow);
				 
//*********** selecting yes for new market *************
				 
			JavascriptExecutor newmarkety = (JavascriptExecutor)driver;
			WebElement opttargety = driver.findElement(By.xpath("(//span[@class ='radiobutton'])[7]"));
			newmarkety.executeScript("arguments[0].click()", opttargety);
		
//********** verifying the FAQ  for all state  ************		
			JavascriptExecutor allstateno = (JavascriptExecutor)driver;
			WebElement optprojno = driver.findElement(By.xpath("(//span[@class ='radiobutton'])[10]"));
			allstateno.executeScript("arguments[0].click()", optprojno);
		
			boolean allstatno = driver.findElement(By.xpath("(//span[@class ='radiobutton'])[10]")).isEnabled();
			Assert.assertTrue(allstatno);
			driver.findElement(By.xpath("(//a[text()='FAQ'])[2]")).click();
		
								 
			int winHandleNum5 = driver.getWindowHandles().size();
					if(winHandleNum5 > 1)
						{
							for(String winHandle : driver.getWindowHandles())
								{
									driver.switchTo().window(winHandle);
								}
						}
			 driver.close();
			 driver.switchTo().window(parentWindow);
				 
//********* selecting yes for all state ***************	
			JavascriptExecutor allstatey = (JavascriptExecutor)driver;
			WebElement optprojy = driver.findElement(By.xpath("(//span[@class ='radiobutton'])[9]"));
			allstatey.executeScript("arguments[0].click()", optprojy);
    	 
	 }

 	@Then("^User save and proceed$")
    public void user_save_and_proceed() throws Throwable {
	    	driver.findElement(By.id("save-btn")).click();
			driver.findElement(By.id("next-btn")).click(); 
	    }
    
 	@Given("^User enter the contact details$")
    public void user_enter_the_contact_details() throws Throwable {
			driver.findElement(By.xpath("//input[@id='react-contact_info-name']")).sendKeys("Tharsini Kajan");
			driver.findElement(By.xpath("//input[@id='react-contact_info-designation']")).sendKeys("Business");
			driver.findElement(By.xpath("//input[@id='react-contact_info-phone']")).sendKeys("98786754");
			driver.findElement(By.xpath("//input[@id='react-contact_info-primary_email']")).sendKeys("Mary@mail.com");
			driver.findElement(By.xpath("//input[@id='react-contact_info-secondary_email']")).sendKeys("Jhon@mail.com");
    }
 
    @When("^User verify same as mailing address$")
    public void verify() throws Throwable {
//    			**************** Mailing Address  *********************88
	
	     	driver.findElement(By.xpath("//input[@id='react-contact_info-correspondence_address-copied']")).click();
			
			boolean postcode = driver.findElement(By.xpath("//input[@id='react-contact_info-correspondence_address-postal']")).isDisplayed();
			Assert.assertTrue(postcode);
		
			boolean hdbblk = driver.findElement(By.xpath("//input[@id='react-contact_info-correspondence_address-block']")).isDisplayed();
			Assert.assertTrue(hdbblk);
			
			boolean hdbstreet = driver.findElement(By.xpath("//input[@id='react-contact_info-correspondence_address-street']")).isDisplayed();
			Assert.assertTrue(hdbstreet);
		
			boolean hdblvl = driver.findElement(By.xpath("//input[@id='react-contact_info-correspondence_address-level']")).isDisplayed();
			Assert.assertTrue(hdblvl);
			
			boolean hdbunit = driver.findElement(By.xpath("//input[@id='react-contact_info-correspondence_address-unit']")).isDisplayed();
			Assert.assertTrue(hdbunit);
    }
 
    @Then("^User verify same main contact$")
    public void user_verify_same_main_contact() throws Throwable {
    	
//    	***************	Letter Of Offer Addressee  ****************
    	
    	 
    		JavascriptExecutor jsscrocon = (JavascriptExecutor)driver;
    		WebElement scrolpop = driver.findElement(By.xpath("//input[@type='checkbox']"));
    		jsscrocon.executeScript("arguments[0].scrollIntoView(true);", scrolpop);
    			
    		JavascriptExecutor jssammacon = (JavascriptExecutor)driver;
    		WebElement sammacon = driver.findElement(By.xpath("//input[@id='react-contact_info-copied']"));
    		jssammacon.executeScript("arguments[0].click()", sammacon); 
    			
    		boolean samconname = driver.findElement(By.xpath("//input[@id='react-contact_info-offeree_name']")).isDisplayed();
    		Assert.assertTrue(samconname);
    			
    		boolean samjobtit = driver.findElement(By.xpath("//input[@id='react-contact_info-offeree_designation']")).isDisplayed();
    		Assert.assertTrue(samjobtit);
    			
    		boolean samemail = driver.findElement(By.xpath("//input[@id='react-contact_info-offeree_email']")).isDisplayed();
    		Assert.assertTrue(samemail);
  		
    		driver.findElement(By.xpath("//button[@id='save-btn']")).click();
 			driver.findElement(By.xpath("//button[@id='next-btn']")).click();  
    			

    }
   
//    ***************** Mandatory Details ****************

 	@Given("^User enter the proposal$")
    public void user_enter_the_proposal() throws Throwable {
    	
//		*******************		SUBMIT YOUR PROPOSAL   *****************************888
			driver.findElement(By.xpath("//input[@id='react-project-title']")).sendKeys("My Project");
			driver.findElement(By.xpath("//input[@id='react-project-start_date']")).sendKeys("27 Apr 2022");
			driver.findElement(By.xpath("//input[@id='react-project-end_date']")).sendKeys("27 May 2022");	
			driver.findElement(By.xpath("//textarea[@id='react-project-description']")).sendKeys("This is my BGP project");
			driver.findElement(By.xpath("(//div[@class='Select-placeholder'])[1]")).click();				 			
			driver.findElement(By.xpath("//*[text()='FTA Consultancy']")).click();		
			driver.findElement(By.xpath("(//div[@class='Select-placeholder'])[1]")).click();	 			
			driver.findElement(By.xpath("//*[text()='Denmark']")).click();
			driver.findElement(By.xpath("//span[@class ='bgp-label']")).click();
			driver.findElement(By.xpath("//button[@id='save-btn']")).click();				
			driver.findElement(By.xpath("//button[@id='next-btn']")).click();
   }
   	@When("^User enter business impact$")
    public void user_enter_business_impact() throws Throwable {
    	
//    	************************* EXPLAIN THE BUSINESS IMPACT **********************************************
		boolean verbusimp = driver.findElement(By.xpath("//*[text()=' Mandatory field']")).isDisplayed();
		Assert.assertTrue(verbusimp);
		
		driver.findElement(By.xpath("//input[@id='react-project_impact-fy_end_date_0']")).sendKeys("25 Apr 2022");
		driver.findElement(By.xpath("//input[@id='react-project_impact-overseas_sales_0']")).sendKeys("200000");
		driver.findElement(By.xpath("//input[@id='react-project_impact-overseas_sales_1']")).sendKeys("400000");
		driver.findElement(By.xpath("//input[@id='react-project_impact-overseas_sales_2']")).sendKeys("3758300");
		driver.findElement(By.xpath("//input[@id='react-project_impact-overseas_sales_3']")).sendKeys("7460000");
		
		driver.findElement(By.xpath("//input[@id='react-project_impact-overseas_investments_0']")).sendKeys("74600549870");
		driver.findElement(By.xpath("//input[@id='react-project_impact-overseas_investments_1']")).sendKeys("986783349870");
		driver.findElement(By.xpath("//input[@id='react-project_impact-overseas_investments_2']")).sendKeys("234330549870");
		driver.findElement(By.xpath("//input[@id='react-project_impact-overseas_investments_3']")).sendKeys("9323232549870");
		
	
		driver.findElement(By.xpath("//textarea[@id='react-project_impact-rationale_remarks']")).sendKeys("This is the Rationale for Projections comments section to comment on project impacts");
		driver.findElement(By.xpath("//textarea[@id='react-project_impact-benefits_remarks']")).sendKeys("This is the Non Tangible Benefits comments section to comment on project impacts");
		driver.findElement(By.xpath("//button[@id='save-btn']")).click();
		driver.findElement(By.xpath("//button[@id='next-btn']")).click();  
	}
 	
    @Then("^User enter the cost$")
    public void user_enter_the_cost() throws Throwable {
    	System.out.println("Enter cost");
//		**************************  PROVIDE DETAILS OF COSTS  *******************
//		**************** Office Space Rental ***********************
		
		driver.findElement(By.xpath("//div[text()='Office Space Rental']")).click();
		driver.findElement(By.xpath("(//button[text()='Add New Item'])[2]")).click();
		driver.findElement(By.xpath("(//textarea[@class='form-control bgp-textarea'])[1]")).sendKeys("This is the description of 500 char for Office space rental refers to only basic rental expenses. of Office Space Rental");
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("1");
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("1212500.50");
		
//		************** File upload for office space Rental ***********************
		driver.findElement(By.xpath("//button[text()='Select Files']")).click();
		WebElement browse1 = driver.findElement(By.xpath("//button[text()='Select Files']"));
	    browse1.click(); 
		
	    // creating object of Robot class
	    Robot rb1 = new Robot();
	    rb1.setAutoDelay(3000);
	    
	    // copying File path to Clipboard
	    StringSelection str1 = new StringSelection("C:\\Users\\thars\\OneDrive\\Desktop\\Test.pdf");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str1, null);
	 	rb1.setAutoDelay(3000);
	 	
	     // press Contol+V for pasting
	     rb1.keyPress(KeyEvent.VK_CONTROL);
	     rb1.keyPress(KeyEvent.VK_V);
	 
	    // release Contol+V for pasting
	    rb1.keyRelease(KeyEvent.VK_CONTROL);
	    rb1.keyRelease(KeyEvent.VK_V);
	 	rb1.setAutoDelay(3000);
	 	
	    // for pressing and releasing Enter
	    rb1.keyPress(KeyEvent.VK_ENTER);
	    rb1.keyRelease(KeyEvent.VK_ENTER);  
	    
	    rb1.setAutoDelay(3000);
	  
	     // press Contol+V for pasting
	     rb1.keyPress(KeyEvent.VK_CONTROL);
	     rb1.keyPress(KeyEvent.VK_V);
	 
	    // release Contol+V for pasting
	    rb1.keyRelease(KeyEvent.VK_CONTROL);
	    rb1.keyRelease(KeyEvent.VK_V);
	 	rb1.setAutoDelay(3000);
	 	
	    // for pressing and releasing Enter
	    rb1.keyPress(KeyEvent.VK_ENTER);
	    rb1.keyRelease(KeyEvent.VK_ENTER);  
	    
	    driver.findElement(By.xpath("//button[@id='save-btn']")).click();
	    driver.findElement(By.xpath("//button[@id='next-btn']")).click();
    }
 
//    *************************** Review and Submit ***********************
 
 	@Given("^User declare and review$")
    public void user_declare_and_review() throws Throwable {
    	
//		************************ DECLARE & ACKNOWLEDGE TERMS **************************
	    
    	JavascriptExecutor jsscroll = (JavascriptExecutor)driver;
		WebElement scrolldown = driver.findElement(By.xpath("(//span[@class='radiobutton'])[1]"));
		jsscroll.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		Thread.sleep(5000);
   
		driver.findElement(By.xpath("(//span[@class='radiobutton'])[1]")).click();
		driver.findElement(By.xpath("(//span[@class='radiobutton'])[3]")).click();
		driver.findElement(By.xpath("(//span[@class='radiobutton'])[5]")).click();
		driver.findElement(By.xpath("(//span[@class='radiobutton'])[7]")).click();
		driver.findElement(By.xpath("(//span[@class='radiobutton'])[9]")).click();
		driver.findElement(By.xpath("(//span[@class='radiobutton'])[11]")).click();
		driver.findElement(By.xpath("(//span[@class='radiobutton'])[13]")).click();
		driver.findElement(By.xpath("(//span[@class='radiobutton'])[15]")).click();
		driver.findElement(By.xpath("(//span[@class='radiobutton'])[18]")).click();
		driver.findElement(By.xpath("(//span[@class='radiobutton'])[20]")).click();
	
		WebDriverWait decrewa2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		decrewa2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));
	    
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
		WebDriverWait revsubsave = new WebDriverWait(driver, Duration.ofSeconds(50));
		revsubsave.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='save-btn']")));
	
		JavascriptExecutor jspdcsave = (JavascriptExecutor)driver;
		WebElement decsave = driver.findElement(By.xpath("//button[@id='save-btn']"));
		jspdcsave.executeScript("arguments[0].click()", decsave);
		
		WebDriverWait revsubnex = new WebDriverWait(driver, Duration.ofSeconds(50));
		revsubnex.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='review-btn']")));

		JavascriptExecutor jspdcnext = (JavascriptExecutor)driver;
		WebElement decnext = driver.findElement(By.xpath("//button[@id='review-btn']"));
		jspdcnext.executeScript("arguments[0].click()", decnext);
	
    }

 	@When("^User accept and submit$")
    public void user_accept_and_submit() throws Throwable {
    	
//    	*********************** ACCEPT and SUBMIT ***********************
		
		WebDriverWait revsubfin = new WebDriverWait(driver, Duration.ofSeconds(20));
		revsubfin.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Business Activity']")));
		
		JavascriptExecutor jsscroll = (JavascriptExecutor)driver;
		WebElement scrolldown = driver.findElement(By.xpath("//input[@type='checkbox']"));
		jsscroll.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//button[@id='submit-btn']")).click();
	  	
    }

 	@Then("^User logout$")
    public void user_logout() throws Throwable {
    	
//		*********************** LOG OUT **********************
		JavascriptExecutor jslogout = (JavascriptExecutor)driver;
     	WebElement bgplogout = driver.findElement(By.xpath("//span[text()='LOG OUT']"));		     	    				
     	jslogout.executeScript("arguments[0].click()", bgplogout);
    }
    
}
		  
		  
//		  ************************************************************************
//		  ************************** END*********************************
//		  *************************************************************************
	
		  
		  
	     

