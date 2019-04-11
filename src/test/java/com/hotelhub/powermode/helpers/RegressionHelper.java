package com.hotelhub.powermode.helpers;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.hotelhub.powermode.pages.BookHotelPage;
import com.hotelhub.powermode.pages.BookingConfirmationPage;
import com.hotelhub.powermode.pages.ChooseHotelPage;
import com.hotelhub.powermode.pages.HomePage;
import com.hotelhub.powermode.pages.PreviousBookingsPage;
import com.hotelhub.powermode.pages.SearchHotelStep1Page;
import com.hotelhub.powermode.pages.TravellersDetailsStep1Page;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.Base;
import base.PowerModeConstants;


public class RegressionHelper extends Base {

	private Logger _logger = LogManager.getLogger(RegressionHelper.class.getName());
	
	static int count=0;
	public static String Hotel;
	WebDriverWait wait=new WebDriverWait(driver(), 50);
	JavascriptExecutor js = (JavascriptExecutor) driver();
	
	public void clickOnBookAHotel()
	{
		_logger.info("Click on Book a Hotel button");
		HomePage homePage = new HomePage();
		homePage.BOOK_HOTEL.click();
	}
	
	public void selectCustomerOrPNROrReferenceNumber(String PNR, String GDS) throws Throwable
	{
		
		TravellersDetailsStep1Page travellersDetailsStep1Page = new TravellersDetailsStep1Page();

		
		
		travellersDetailsStep1Page.TRAVELLER_DETAILS_INPUT.sendKeys(PNR);
		if(GDS.equals("AMADEUS"))
		{
			Select select = new Select(travellersDetailsStep1Page.SELECT_GDS);
			select.selectByVisibleText("Amadeus");
		}
		if(GDS.equals("APOLLO"))
		{
			Select select = new Select(travellersDetailsStep1Page.SELECT_GDS);
			select.selectByVisibleText("Apollo");
		}	
		if(GDS.equals("GALILEO"))
		{
			Select select = new Select(travellersDetailsStep1Page.SELECT_GDS);
			select.selectByVisibleText("Galileo");
		}
		Thread.sleep(2000);	
		travellersDetailsStep1Page.FIRST_TRAVELLER.click();

		ScreenShot("PNR Read successful ","INFO",test);
		
	}
	
	public void verifyPNRGDSMismatchError(String PNR) throws InterruptedException
	{
		
		TravellersDetailsStep1Page travellersDetailsStep1Page = new TravellersDetailsStep1Page();
		travellersDetailsStep1Page.TRAVELLER_DETAILS_INPUT.sendKeys(PNR);
		Assert.assertTrue(travellersDetailsStep1Page.TRAVELLER_DETAILS_PNR_GDS_ERROR.getText().contains(PowerModeConstants.GDS_PNR_MISMATCH_ERROR));
		ScreenShot("PNR GDS Error display", "PASS", test);
		
	}
	
	public void verifyPreviouslySelectedPNRorCustomer() throws InterruptedException
	{
		
		TravellersDetailsStep1Page travellersDetailsStep1Page = new TravellersDetailsStep1Page();
		Thread.sleep(2000);
		Assert.assertTrue(travellersDetailsStep1Page.PREVIOUS_SEARCH.isDisplayed());
		ScreenShot("Previously searched PNR or Customers are displaying", "PASS", test);
		
	}
	
	public void clickCustomerSelectProceedButton()
	{	
		TravellersDetailsStep1Page travellersDetailsStep1Page = new TravellersDetailsStep1Page();
		travellersDetailsStep1Page.PROCEED_BUTTON.click();
		
	}
	
	
	
	public void selectDestinationType(String destinationType) throws InterruptedException
	{
		SearchHotelStep1Page searchHotelStep1Page = new SearchHotelStep1Page();
		searchHotelStep1Page.DESTINATION_TYPE.click();
		Thread.sleep(2000);
		if(destinationType.equals("HOTEL"))
		searchHotelStep1Page.DESTINATION_TYPE_HOTEL.click();	
		else if(destinationType.equals("AIRPORT"))
		searchHotelStep1Page.DESTINATION_TYPE_AIRPORT.click();	
		else if(destinationType.equals("GOOGLE"))
		searchHotelStep1Page.DESTINATION_TYPE_GOOGLE.click();
		else if(destinationType.equals("GOOGLE_AIRPORT"))
		{
			searchHotelStep1Page.DESTINATION_TYPE_GOOGLE.click();
			searchHotelStep1Page.DESTINATION_TYPE_AIRPORT.click();
		}
		else if(destinationType.equals("GOOGLE_HOTEL"))
		{
			searchHotelStep1Page.DESTINATION_TYPE_GOOGLE.click();
			searchHotelStep1Page.DESTINATION_TYPE_HOTEL.click();	
		}
		else if(destinationType.equals("AIRPORT_HOTEL"))
		{
			searchHotelStep1Page.DESTINATION_TYPE_AIRPORT.click();
			Thread.sleep(2000);
			searchHotelStep1Page.DESTINATION_TYPE_HOTEL.click();	
		}
	}
	
	public void searchLocation(String searchKey) throws InterruptedException
	{
		SearchHotelStep1Page searchHotelStep1Page = new SearchHotelStep1Page();
		this.Hotel=searchKey;
//		searchHotelStep1Page.DESTINATION_SEARCH_INPUT.click();
		searchHotelStep1Page.DESTINATION_SEARCH_INPUT.sendKeys(searchKey);
		reportingUtils.setInputData(searchKey);
		WebDriverWait wait=new WebDriverWait(driver(), 120);
		wait.until(ExpectedConditions.invisibilityOf(SearchHotelStep1Page.DESTINATION_SEARCH_SPINNER));
		Thread.sleep(2000);
		
	}
	
	public void verifyDestinationType(String destinationType) throws InterruptedException
	{
		SearchHotelStep1Page searchHotelStep1Page = new SearchHotelStep1Page();
		if(destinationType.equals("HOTEL"))
		{
			
			Assert.assertTrue(isElementPresent(searchHotelStep1Page.FIRST_HOTEL_RESULT_BY()));
			Assert.assertTrue(!isElementPresent(searchHotelStep1Page.FIRST_GOOGLE_RESULT_BY()));
			Assert.assertTrue(!isElementPresent(searchHotelStep1Page.FIRST_IATA_RESULT_BY()));
			ScreenShot("Verification of Hotel Destination Type is sucessful", "PASS", test);
		}
		if(destinationType.equals("AIRPORT"))
		{
			Assert.assertTrue(isElementPresent(searchHotelStep1Page.FIRST_IATA_RESULT_BY()));
			Assert.assertTrue(!isElementPresent(searchHotelStep1Page.FIRST_GOOGLE_RESULT_BY()));
			Assert.assertTrue(!isElementPresent(searchHotelStep1Page.FIRST_HOTEL_RESULT_BY()));
			ScreenShot("Verification of Airport Destination Type is sucessful", "PASS", test);
		}
		if(destinationType.equals("GOOGLE"))
		{
			Assert.assertTrue(isElementPresent(searchHotelStep1Page.FIRST_GOOGLE_RESULT_BY()));
			Assert.assertTrue(!isElementPresent(searchHotelStep1Page.FIRST_IATA_RESULT_BY()));
			Assert.assertTrue(!isElementPresent(searchHotelStep1Page.FIRST_HOTEL_RESULT_BY()));
			ScreenShot("Verification of Google Destination Type is sucessful", "PASS", test);
		}
		if(destinationType.equals("ALL"))
		{
			Assert.assertTrue(isElementPresent(searchHotelStep1Page.FIRST_GOOGLE_RESULT_BY()));
			Assert.assertTrue(isElementPresent(searchHotelStep1Page.FIRST_IATA_RESULT_BY()));
			Assert.assertTrue(isElementPresent(searchHotelStep1Page.FIRST_HOTEL_RESULT_BY()));
			ScreenShot("Verification of All Destination Type is sucessful", "PASS", test);
		}
		
		if(destinationType.equals("GOOGLE_AIRPORT"))
		{
			Assert.assertTrue(isElementPresent(searchHotelStep1Page.FIRST_GOOGLE_RESULT_BY()));
			Assert.assertTrue(isElementPresent(searchHotelStep1Page.FIRST_IATA_RESULT_BY()));
			Assert.assertTrue(!isElementPresent(searchHotelStep1Page.FIRST_HOTEL_RESULT_BY()));
			ScreenShot("Verification of Google Destination Type is sucessful", "PASS", test);
		}
		
		if(destinationType.equals("GOOGLE_HOTEL"))
		{
			Assert.assertTrue(isElementPresent(searchHotelStep1Page.FIRST_GOOGLE_RESULT_BY()));
			Assert.assertTrue(!isElementPresent(searchHotelStep1Page.FIRST_IATA_RESULT_BY()));
			Assert.assertTrue(isElementPresent(searchHotelStep1Page.FIRST_HOTEL_RESULT_BY()));
			ScreenShot("Verification of Google Destination Type is sucessful", "PASS", test);
		}
		
		if(destinationType.equals("AIRPORT_HOTEL"))
		{
			Assert.assertTrue(!isElementPresent(searchHotelStep1Page.FIRST_GOOGLE_RESULT_BY()));
			Assert.assertTrue(isElementPresent(searchHotelStep1Page.FIRST_IATA_RESULT_BY()));
			Assert.assertTrue(isElementPresent(searchHotelStep1Page.FIRST_HOTEL_RESULT_BY()));
			ScreenShot("Verification of Google Destination Type is sucessful", "PASS", test);
		}
		
		
	}
	
	public boolean isElementPresent(By locatorKey) {
	    try {
	        driver().findElement(locatorKey);
	        return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }
	}
	
	public void selectLocation(String LocationType) throws InterruptedException
	{
		SearchHotelStep1Page searchHotelStep1Page = new SearchHotelStep1Page();
		if(LocationType.isEmpty())
		{
			searchHotelStep1Page.FIRST_RESULT.click();
		}
		else if(LocationType.contains("Google"))
		{	
			Thread.sleep(5000);
			searchHotelStep1Page.FIRST_GOOGLE_RESULT.click();
			ScreenShot("Selected GOOGLE result type from the search results ","INFO",test);
		}
		else if(LocationType.contains("IATA"))
		{
			Thread.sleep(5000);
			searchHotelStep1Page.FIRST_IATA_RESULT.click();
			ScreenShot("Selected IATA result type from the search results ","INFO",test);
		}
		else if(LocationType.contains("Hotel"))
		{	
			Thread.sleep(5000);
			searchHotelStep1Page.FIRST_HOTEL_RESULT.click();
			ScreenShot("Selected HOTEL result type from the search results ","INFO",test);
		}
	}
	

	
	public void selectCheckInCheckOutDate() throws InterruptedException
	{
		test.log(LogStatus.INFO, "<b style='color:#3b3f42;Font-size:12px;font-family: verdana'>"+ "Select Check-In and Check-Out date" + "<b>");
		SearchHotelStep1Page searchHotelStep1Page = new SearchHotelStep1Page();

		searchHotelStep1Page.CHECK_IN_DATE_SELECTION_BUTTON.click();
		searchHotelStep1Page.CHECK_IN_DATE_SELECTION_STEP1.click();
		searchHotelStep1Page.CHECK_IN_DATE_SELECTION_MONTH.click();
		searchHotelStep1Page.CHECK_IN_DATE_SELECTION_DAY.click();
		ScreenShot("Check in - Check out date selection successful", "INFO", test);
		searchHotelStep1Page.SEARCH_HOTELS.click();
		ScreenShot("Hotel Listing successful", "INFO", test);
		
	}
	
	public void selectCheckInCheckOutDateDelete() throws InterruptedException
	{
		test.log(LogStatus.INFO, "<b style='color:#3b3f42;Font-size:12px;font-family: verdana'>"+ "Select Check-In and Check-Out date" + "<b>");
		SearchHotelStep1Page searchHotelStep1Page = new SearchHotelStep1Page();

		String date =searchHotelStep1Page.CHECK_IN_DATE.getText();
//		searchHotelStep1Page.CHECK_IN_DATE.sendKeys("12-Jun-2019");
		
		System.out.println("Date "+date);
		Thread.sleep(10000);
		
	}
	
	public void clickOnSearchHotelsButton() throws InterruptedException
	{
		SearchHotelStep1Page searchHotelStep1Page = new SearchHotelStep1Page();
		searchHotelStep1Page.SEARCH_HOTELS_BUTTON.click();
	}
	
	public void verifySearchResultsAreDisplayed(ExtentTest test) throws InterruptedException
	{
		
		ChooseHotelPage chooseHotelPage = new ChooseHotelPage();
		
		if(chooseHotelPage.hotelSearchResults.isDisplayed())
		{
			ScreenShot("Verification of Search Results is Successful ","PASS",test);
		}
		
		else
		{
			ScreenShot("Search Results are not displaying ","FAIL",test);
		}
		
		
	}
	
	public void verifyRates(String Param) throws InterruptedException
	{
		ChooseHotelPage chooseHotelPage = new ChooseHotelPage();
		
		if(Param.toLowerCase().equals("sabre"))
		{
			String xpath="//span[contains(text(),\"_hotelName\")]";
			String xpath_replace=xpath.replaceAll("_hotelName", Hotel);
//			wait.until(ExpectedConditions.invisibilityOf(chooseHotelPage.FIRST_RESULT_SPIN));
//			driver().findElement(By.xpath(xpath_replace)).click();
			chooseHotelPage.ROOM_IT_RATES_LINK.click();
//			test.log(LogStatus.INFO, "<b style='color:#3b3f42;Font-size:12px;font-family: verdana'>"+ "RoomIt rates are displaying " + "<b>");
			js.executeScript("window.scrollBy(0,300)");
			ScreenShot("RoomIt rates are available", "INFO", test);
			chooseHotelPage.PUBLIC_RATES_LINK.click();
			ScreenShot("Public rates are available", "INFO", test);
		}
		if(Param.toLowerCase().equals("hhe"))
		{
			
			chooseHotelPage.PUBLIC_RATES_LINK.click();
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,1200)");
			Thread.sleep(1000);
//			js.executeScript("window.scrollBy(0,200)");
			ScreenShot("HHE Public rates are available", "INFO", test);
			
		}
		if(Param.toLowerCase().equals("hheonrequest"))
		{
			
//			chooseHotelPage.ON_REQUEST_RATES_LINK.click();
			Thread.sleep(10000);
//			chooseHotelPage.VIEW_ALL_RATES_ONRQUEST.click();
//			chooseHotelPage.SELECT_RATE_FIRST_ONLINE_CANCELLABLE.click();
			js.executeScript("window.scrollBy(0,300)");
			js.executeScript("window.scrollBy(0,200)");
			ScreenShot("HHE On-request rates available", "INFO", test);
			
		}
		if(Param.toLowerCase().equals("amadeus"))
		{
			
			String xpath="//span[contains(text(),\"_hotelName\")]";
			String xpath_replace=xpath.replaceAll("_hotelName", Hotel);
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_replace)));
//			driver().findElement(By.xpath(xpath_replace)).click();
			Assert.assertTrue(chooseHotelPage.CLIENT_RATES_LINK.isDisplayed());
//			chooseHotelPage.CLIENT_RATES_LINK.click();
			js.executeScript("window.scrollBy(0,200)");
			ScreenShot("Client rates are available", "INFO", test);
			Assert.assertTrue(chooseHotelPage.ROOM_IT_RATES_LINK.isDisplayed());
			js.executeScript("window.scrollBy(0,200)");
//			test.log(LogStatus.INFO, "<b style='color:#3b3f42;Font-size:12px;font-family: verdana'>"+ "RoomIt rates are displaying " + "<b>");
			ScreenShot("RoomIt rates are available", "INFO", test);
			Assert.assertTrue(chooseHotelPage.PUBLIC_RATES_LINK.isDisplayed());
//			chooseHotelPage.PUBLIC_RATES_LINK.click();
			js.executeScript("window.scrollBy(0,200)");
			ScreenShot("Public rates are available", "INFO", test);
			
		}
		
		
		if(Param.toLowerCase().equals("bcom"))
		{
			
			chooseHotelPage.AGGREGATOR_LINK.click();
			js.executeScript("window.scrollBy(0,300)");
			js.executeScript("window.scrollBy(0,200)");
//			Assert.assertTrue(chooseHotelPage.SELECT_RATE_FIRST_BCOM_CANCELLABLE.isDisplayed());
			ScreenShot("Public rates are available", "INFO", test);
		}
		
		
	}
	
	public void chooseHotel(String BookingType,String BookingFlow) throws InterruptedException
	{
		test.log(LogStatus.INFO, "<b style='color:#3b3f42;Font-size:12px;font-family: verdana'>"+ "Choose the hotel" + "<b>");
		ChooseHotelPage chooseHotelPage = new ChooseHotelPage();
		BookHotelPage bookHotelPage = new BookHotelPage();
		if(BookingType.equals("BCOM"))
		{
//			chooseHotelPage.AGGREGATOR_LINK.click();
			wait.until(ExpectedConditions.visibilityOf(chooseHotelPage.VIEW_ALL_RATES_AGGREGATOR));
			chooseHotelPage.VIEW_ALL_RATES_AGGREGATOR.click();
			if(BookingFlow.toLowerCase().equals("auto book"))
			{
				
				chooseHotelPage.AUTO_BOOK_FIRST_BCOM_CANCELLABLE.click();
			}
			else
			chooseHotelPage.SELECT_RATE_FIRST_BCOM_CANCELLABLE.click();
			
		}
	
		if(BookingType.equals("SABRE"))
		{
			String xpath="//span[contains(text(),\"_hotelName\")]";
			String xpath_replace=xpath.replaceAll("_hotelName", Hotel);
			Thread.sleep(5000);
			driver().findElement(By.xpath(xpath_replace)).click();
			chooseHotelPage.ROOM_IT_RATES_LINK.click();
			chooseHotelPage.VIEW_ALL_RATES_ROOMIT.click();
			if(BookingFlow.toLowerCase().equals("auto book"))
			{
				chooseHotelPage.AUTO_BOOK_FIRST_BCOM_CANCELLABLE.click();
			}
			else
			chooseHotelPage.SELECT_RATE_FIRST_ONLINE_CANCELLABLE.click();	
		}
		
		
		if(BookingType.equals("SABRE"))
		{
			String xpath="//span[contains(text(),\"_hotelName\")]";
			String xpath_replace=xpath.replaceAll("_hotelName", Hotel);
			Thread.sleep(5000);
			driver().findElement(By.xpath(xpath_replace)).click();
			chooseHotelPage.ROOM_IT_RATES_LINK.click();
			chooseHotelPage.VIEW_ALL_RATES_ROOMIT.click();
			if(BookingFlow.toLowerCase().equals("auto book"))
			{
				chooseHotelPage.AUTO_BOOK_FIRST_BCOM_CANCELLABLE.click();
			}
			else
			chooseHotelPage.SELECT_RATE_FIRST_ONLINE_CANCELLABLE.click();	
		}
		
		if(BookingType.equals("HHE"))
		{
			
			chooseHotelPage.PUBLIC_RATES_LINK.click();
			wait.until(ExpectedConditions.visibilityOf(chooseHotelPage.VIEW_ALL_RATES_PUBLIC));
			chooseHotelPage.VIEW_ALL_RATES_PUBLIC.click();
			if(BookingFlow.toLowerCase().equals("auto book"))
			{
				
				chooseHotelPage.AUTO_BOOK_FIRST_HHE_CANCELLABLE.click();
			}
			else
			chooseHotelPage.SELECT_RATE_FIRST_HHE_CANCELLABLE.click();	
		}
		
	
	
		ScreenShot("Hotel Selection Successful", "INFO", test);
		wait.until(ExpectedConditions.visibilityOf(bookHotelPage.NOTIFICATION_EMAIL_INPUT));
		
	}
	
	
	
	public void addNewCard() throws InterruptedException
	{
		BookHotelPage bookHotelPage = new BookHotelPage();
		bookHotelPage.ADD_NEW_CARD.click();
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "<b style='color:#3b3f42;Font-size:12px;font-family: verdana'>"+ "Enter the new card details" + "<b>");
		
		Select s=new Select(bookHotelPage.CARD_TYPE_DROPDOWN);
		s.selectByVisibleText("Visa");
		bookHotelPage.CARD_NUMBER.sendKeys("411111111111111");
		bookHotelPage.NAME_CARD.sendKeys("Test User");

		Select s1=new Select(bookHotelPage.EXPIRY_MONTH_DROPDOWN);
		s1.selectByVisibleText("JAN");
		
		Select s2=new Select(bookHotelPage.EXPIRY_YEAR_DROPDOWN);
		s2.selectByVisibleText("2022");
		ScreenShot("Card details entered successfully", "INFO", test);
	}
	
	public void fillOnlineBookingDetails() throws InterruptedException
	{
		
		BookHotelPage bookHotelPage = new BookHotelPage();
		if(bookHotelPage.NOTIFICATION_EMAIL_INPUT.isDisplayed())
		{
			bookHotelPage.NOTIFICATION_EMAIL_INPUT.clear();
		}
		else
		{
			bookHotelPage.CONTACT_INFORMATION.click();
			bookHotelPage.NOTIFICATION_EMAIL_INPUT.clear();
		}
	
		Thread.sleep(1000);
		
		bookHotelPage.ADD_REMARKS.click();
		test.log(LogStatus.INFO, "<b style='color:#3b3f42;Font-size:12px;font-family: verdana'>"+ "Enter the SI Remarks" + "<b>");
		bookHotelPage.INTERNAL_REMARKS.sendKeys("This is test booking, please cancel");
		ScreenShot("Booking details input successful", "INFO", test);
	
	}
	
	public void clickOnBookButton() throws InterruptedException
	{
		BookHotelPage bookHotelPage = new BookHotelPage();
		bookHotelPage.PROCEED_BUTTON.click();
		Thread.sleep(5000);
	}
	
	public void fulFillNowDetailsAndClickBookButton(String PaymentType, String PaymentCard)
	{
		
	}
	
	public void verifyBookingConfirmation() throws InterruptedException
	{
		BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
		
		wait.until(ExpectedConditions.visibilityOf(bookingConfirmationPage.BOOKING_CONFIRMATION_SUCCESS_TEST_BOOKINGS));
		ScreenShot("Booking Confirmation Page", "INFO", test);
		test.log(LogStatus.INFO, "<b style='color:#3b3f42;Font-size:12px;font-family: verdana'>"+ "Verify the booking cofirmation" + "<b>");
		Assert.assertTrue(bookingConfirmationPage.BOOKING_CONFIRMATION_SUCCESS_TEST_BOOKINGS.isDisplayed(),"Booking confirmation failed");
		String BookingReferenceNumber= bookingConfirmationPage.BOOKING_REFERENCE_NUMBER.getText();
		ScreenShot("Booking Confirmation successful", "PASS", test);
		System.out.println(BookingReferenceNumber);
		reportingUtils.setOutPutData(BookingReferenceNumber);
//		logOut(test);
		cancelBookingPH(BookingReferenceNumber,test);
		
	}
	
	
	
	public void cancelBookingPH(String BookingReferenceNumber, ExtentTest test) throws InterruptedException
	{
		test.log(LogStatus.INFO, "<b style='color:#3b3f42;Font-size:12px;font-family: verdana'>"+ "Cancel the Booking" + "<b>");
		driver().get("https://dev.hotelhub.net/CWT/v1570/book/default.aspx");
		driver().findElement(By.id("txtUserId")).sendKeys("TCT10290");
		driver().findElement(By.id("txtPwd")).sendKeys("welcome@1");
		driver().findElement(By.id("lnkLogin")).click();
		driver().findElement(By.id("txtCnclOrMdfy")).sendKeys(BookingReferenceNumber);
		driver().findElement(By.xpath("//*[@id='aetmIFrame']/div/div[5]/div[1]/div[2]/ul/li[3]/button")).click();
		
//		driver().findElement(By.id("lnkmore")).click();
//		driver().findElement(By.id("PREVBKNGHSTRY")).click();
//		driver().findElement(By.id("txtRefConfNo")).sendKeys(BookingReferenceNumber);
//		driver().findElement(By.xpath("//span/em[contains(text(),'List bookings')]")).click();
//		driver().findElement(By.xpath("//div[contains(@class,'table_row_sm1')]/p[contains(text(),'Confirmed')]")).click();
//		driver().findElement(By.xpath("//span[contains(text(),'View or edit booking details')]")).click();
		driver().findElement(By.id("btnDivCancel")).click();
		driver().findElement(By.id("btncontinue")).click();
		Thread.sleep(3000);
		ScreenShot("Booking Cancelled sucessfully", "PASS", test);
		driver().findElement(By.id("hhheader_lnkSignout")).click();
	
		
	}
	
	
	public void cancelBooking(String BookingReferenceNumber, ExtentTest test) throws InterruptedException
	{
		HomePage homePage = new HomePage();
		BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
		PreviousBookingsPage previousBookingsPage = new PreviousBookingsPage();
		driver().get("https://ngbeta.hotelhub.net/v1");
		homePage.MORE.click();
		homePage.PREVIOUS_BOOKINGS.click();
		wait.until(ExpectedConditions.visibilityOf(previousBookingsPage.BOOKING_REFERENCE));
		previousBookingsPage.BOOKING_REFERENCE.sendKeys(BookingReferenceNumber);
		previousBookingsPage.LIST_BOOKINGS.click();
		previousBookingsPage.CANCEL_ICON.click();
		wait.until(ExpectedConditions.visibilityOf(previousBookingsPage.CANCEL_YES));
		previousBookingsPage.CANCEL_YES.click();
//		wait.until(ExpectedConditions.visibilityOf(previousBookingsPage.CANCELLATION_REFRENCE_NUMBER));
//		String CancellationRefrenceNumber=previousBookingsPage.CANCELLATION_REFRENCE_NUMBER.getText();
//		System.out.println(CancellationRefrenceNumber);
		
	}
	
	
	public void logOut(ExtentTest test) throws InterruptedException
	{
		HomePage homePage= new HomePage();
		test.log(LogStatus.INFO, "<b style='color:#3b3f42;Font-size:12px;font-family: verdana'>"+ "Logout from the application" + "<b>");
		homePage.SETTINGS_ICON.click();
		homePage.LOG_OUT.click();
		ScreenShot("Logged out from the application successfully", "INFO", test);
		
	}
	
}
