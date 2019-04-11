package com.hotelhub.powermode.tests;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hotelhub.powermode.helpers.HotelBookingHelper;
import com.hotelhub.powermode.helpers.LoginHelper;
import com.relevantcodes.extentreports.ExtentTest;

import base.Base;
import base.PowerModeConstants;
import bsh.org.objectweb.asm.Constants;
import utils.ReportingUtils;


@Listeners(utils.MyListener.class)

public class HotelBookingTest extends Base{

	
	@BeforeMethod(alwaysRun=true)
	void loginToTheApplication() throws Throwable
	{
		reportingUtils =new ReportingUtils();
		LoginHelper loginHelper = new LoginHelper();
//		ExtentTest test = ExtentTestManager.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		loginHelper.login(test);
	}
	
	@Test(groups="login")
	void loginTest()
	{
		System.out.println("Login Successfull");
	}
	
	@Test(groups={"DailyBooking","",},priority=2)
	void BCOMbookingWithPortraitCard() throws Throwable
	{
		String methodName=new Object(){}.getClass().getEnclosingMethod().getName();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		
		reportingUtils.setTestCaseNumber("TC02");
		reportingUtils.setSummary("Verify user is able to create BCOM booking");
		reportingUtils.setExecutionTime(timeStamp);
		reportingUtils.setTestCaseName(methodName);
//		SessionId sessionId = driver().getSessionId();
//		System.out.println("Session ID : "+sessionId.toString());
		HotelBookingHelper hotelBookingHelper = new HotelBookingHelper();
//		hotelBookingHelper.initializeInputData();
		hotelBookingHelper.enterCustomerOrPNROrReferenceNumber(PowerModeConstants.TEST_PNR_AMADEUS,"");
		hotelBookingHelper.searcHotel(PowerModeConstants.BCOM_BOOKING_TEST_HOTEL);
		hotelBookingHelper.selectCheckInCheckOutDate();
		hotelBookingHelper.clickOnSearchHotels();
		hotelBookingHelper.chooseHotel("BCOM","");
		hotelBookingHelper.fillOnlineBookingDetails();
		hotelBookingHelper.clickOnBookButton();
		hotelBookingHelper.verifyBookingConfirmation();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.cancelBooking();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.logOut(test);
		reportingUtils.setTestResult("PASS");
		
	}
	
	@Test(groups={"DailyBooking","addnewcard","Bcom"},priority=2)
	void BCOMbookingByAddingNewVISACard() throws Throwable
	{
		String methodName=new Object(){}.getClass().getEnclosingMethod().getName();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		
		reportingUtils.setTestCaseNumber("TC02");
		reportingUtils.setSummary("Verify user is able to create BCOM booking");
		reportingUtils.setExecutionTime(timeStamp);
		reportingUtils.setTestCaseName(methodName);
//		SessionId sessionId = driver().getSessionId();
//		System.out.println("Session ID : "+sessionId.toString());
		HotelBookingHelper hotelBookingHelper = new HotelBookingHelper();
//		hotelBookingHelper.initializeInputData();
		hotelBookingHelper.enterCustomerOrPNROrReferenceNumber(PowerModeConstants.TEST_PNR_SABRE,"");
		hotelBookingHelper.searcHotel(PowerModeConstants.BCOM_BOOKING_TEST_HOTEL);
		hotelBookingHelper.selectCheckInCheckOutDate();
		hotelBookingHelper.clickOnSearchHotels();
		hotelBookingHelper.chooseHotel("BCOM","");
		hotelBookingHelper.addNewCard(PowerModeConstants.PAYMENT_CARD_VISA);
		hotelBookingHelper.fillOnlineBookingDetails();
		hotelBookingHelper.clickOnBookButton();
		hotelBookingHelper.verifyBookingConfirmation();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.cancelBooking();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.logOut(test);
		reportingUtils.setTestResult("PASS");
		
	}
	
	@Test(groups={"DailyBooking","addnewcard","Bcom"},priority=1)
	void BCOMbookingByAddingNewAMEXCard() throws Throwable
	{
		String methodName=new Object(){}.getClass().getEnclosingMethod().getName();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		
		reportingUtils.setTestCaseNumber("TC02");
		reportingUtils.setSummary("Verify user is able to create BCOM booking");
		reportingUtils.setExecutionTime(timeStamp);
		reportingUtils.setTestCaseName(methodName);
//		SessionId sessionId = driver().getSessionId();
//		System.out.println("Session ID : "+sessionId.toString());
		HotelBookingHelper hotelBookingHelper = new HotelBookingHelper();
//		hotelBookingHelper.initializeInputData();
		hotelBookingHelper.enterCustomerOrPNROrReferenceNumber(PowerModeConstants.TEST_PNR_SABRE,"");
		hotelBookingHelper.searcHotel(PowerModeConstants.BCOM_BOOKING_TEST_HOTEL);
		hotelBookingHelper.selectCheckInCheckOutDate();
		hotelBookingHelper.clickOnSearchHotels();
		hotelBookingHelper.chooseHotel("BCOM","");
		hotelBookingHelper.addNewCard(PowerModeConstants.PAYMENT_CARD_AMEX);
		hotelBookingHelper.fillOnlineBookingDetails();
		hotelBookingHelper.clickOnBookButton();
		hotelBookingHelper.verifyBookingConfirmation();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.cancelBooking();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.logOut(test);
		reportingUtils.setTestResult("PASS");
		
	}
	
	@Test(groups={"DailyBooking","Bcom"},priority=1)
	void BCOMbookingWithAutoBookFeature() throws Throwable
	{
		String methodName=new Object(){}.getClass().getEnclosingMethod().getName();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		
		reportingUtils.setTestCaseNumber("TC03");
		reportingUtils.setSummary("Verify user is able to create BCOM booking with Auto Book feature");
		reportingUtils.setExecutionTime(timeStamp);
		reportingUtils.setTestCaseName(methodName);

		HotelBookingHelper hotelBookingHelper = new HotelBookingHelper();
//		hotelBookingHelper.initializeInputData();
		hotelBookingHelper.enterCustomerOrPNROrReferenceNumber(PowerModeConstants.TEST_PNR_AMADEUS,"AMADEUS");
		hotelBookingHelper.searcHotel(PowerModeConstants.BCOM_BOOKING_TEST_HOTEL);
		hotelBookingHelper.selectCheckInCheckOutDate();
		hotelBookingHelper.clickOnSearchHotels();
		hotelBookingHelper.chooseHotel("BCOM","Auto Book");
		hotelBookingHelper.verifyBookingConfirmation();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.cancelBooking();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.logOut(test);
		reportingUtils.setTestResult("PASS");
		
	}
	
	@Test(groups="DailyBooking",priority=3)
	void HHEbookingWithPortraitCard() throws Throwable
	{
		String methodName=new Object(){}.getClass().getEnclosingMethod().getName();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		
		reportingUtils.setTestCaseNumber("TC03");
		reportingUtils.setSummary("Verify user is able to create HHE booking");
		reportingUtils.setExecutionTime(timeStamp);
		reportingUtils.setTestCaseName(methodName);
		
		HotelBookingHelper hotelBookingHelper = new HotelBookingHelper();
//		hotelBookingHelper.initializeInputData();
		hotelBookingHelper.enterCustomerOrPNROrReferenceNumber(PowerModeConstants.TEST_PNR_AMADEUS,"");
		hotelBookingHelper.searcHotel(PowerModeConstants.HHE_BOOKING_TEST_HOTEL);
		hotelBookingHelper.selectCheckInCheckOutDate();
		hotelBookingHelper.chooseHotel("HHE","");
		hotelBookingHelper.fillOnlineBookingDetails();
		hotelBookingHelper.clickOnBookButton();
		hotelBookingHelper.verifyBookingConfirmation();
		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.cancelBooking();
		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.logOut(test);
		reportingUtils.setTestResult("PASS");
		
	}
	
	@Test(groups={"DailyBooking","addnewcard",""},priority=4)
	void HHEbookingByAddingNewVISACard() throws Throwable
	{
		String methodName=new Object(){}.getClass().getEnclosingMethod().getName();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		
		reportingUtils.setTestCaseNumber("TC03");
		reportingUtils.setSummary("Verify user is able to create HHE booking");
		reportingUtils.setExecutionTime(timeStamp);
		reportingUtils.setTestCaseName(methodName);
		
		HotelBookingHelper hotelBookingHelper = new HotelBookingHelper();
//		hotelBookingHelper.initializeInputData();
		hotelBookingHelper.enterCustomerOrPNROrReferenceNumber(PowerModeConstants.TEST_PNR_SABRE,"");
		hotelBookingHelper.searcHotel(PowerModeConstants.HHE_BOOKING_TEST_HOTEL);
		hotelBookingHelper.selectCheckInCheckOutDate();
		hotelBookingHelper.chooseHotel("HHE","");
		hotelBookingHelper.addNewCard(PowerModeConstants.PAYMENT_CARD_VISA);
		hotelBookingHelper.fillOnlineBookingDetails();
		hotelBookingHelper.clickOnBookButton();
		hotelBookingHelper.verifyBookingConfirmation();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.cancelBooking();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.logOut(test);
		reportingUtils.setTestResult("PASS");
		
	}
	
	@Test(groups={"DailyBooking","addnewcard"},priority=3)
	void HHEbookingByAddingNewAMEXCard() throws Throwable
	{
		String methodName=new Object(){}.getClass().getEnclosingMethod().getName();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		
		reportingUtils.setTestCaseNumber("TC03");
		reportingUtils.setSummary("Verify user is able to create HHE booking");
		reportingUtils.setExecutionTime(timeStamp);
		reportingUtils.setTestCaseName(methodName);
		
		HotelBookingHelper hotelBookingHelper = new HotelBookingHelper();
//		hotelBookingHelper.initializeInputData();
		hotelBookingHelper.enterCustomerOrPNROrReferenceNumber(PowerModeConstants.TEST_PNR_SABRE,"");
		hotelBookingHelper.searcHotel(PowerModeConstants.HHE_BOOKING_TEST_HOTEL);
		hotelBookingHelper.selectCheckInCheckOutDate();
		hotelBookingHelper.chooseHotel("HHE","");
		hotelBookingHelper.addNewCard(PowerModeConstants.PAYMENT_CARD_AMEX);
		hotelBookingHelper.fillOnlineBookingDetails();
		hotelBookingHelper.clickOnBookButton();
		hotelBookingHelper.verifyBookingConfirmation();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.cancelBooking();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.logOut(test);
		reportingUtils.setTestResult("PASS");
		
	}
	
	@Test(groups={"DailyBooking",""},priority=3)
	void HHEbookingWithAutoBookFeature() throws Throwable
	{
		String methodName=new Object(){}.getClass().getEnclosingMethod().getName();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		
		reportingUtils.setTestCaseNumber("TC04");
		reportingUtils.setSummary("Verify user is able to create HHE booking with Auto Book feature");
		reportingUtils.setExecutionTime(timeStamp);
		reportingUtils.setTestCaseName(methodName);
		
		HotelBookingHelper hotelBookingHelper = new HotelBookingHelper();
//		hotelBookingHelper.initializeInputData();
		hotelBookingHelper.enterCustomerOrPNROrReferenceNumber(PowerModeConstants.TEST_PNR_AMADEUS,"AMADEUS");
		hotelBookingHelper.searcHotel(PowerModeConstants.HHE_BOOKING_TEST_HOTEL);
		hotelBookingHelper.selectCheckInCheckOutDate();
		hotelBookingHelper.chooseHotel("HHE","Auto Book");
		hotelBookingHelper.verifyBookingConfirmation();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.cancelBooking();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.logOut(test);
		reportingUtils.setTestResult("PASS");
		
	}
	
	
//	@Test(groups="NormalBook")
	void SABREbookingWithPortraitCard() throws Throwable
	{
		String methodName=new Object(){}.getClass().getEnclosingMethod().getName();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		
		reportingUtils.setTestCaseNumber("TC05");
		reportingUtils.setSummary("Verify user is able to create SABRE booking");
		reportingUtils.setExecutionTime(timeStamp);
		reportingUtils.setTestCaseName(methodName);
		
		HotelBookingHelper hotelBookingHelper = new HotelBookingHelper();
//		hotelBookingHelper.initializeInputData();
		hotelBookingHelper.enterCustomerOrPNROrReferenceNumber(PowerModeConstants.TEST_PNR_SABRE,"SABRE");
		hotelBookingHelper.searcHotel(PowerModeConstants.SABRE_BOOKING_TEST_HOTEL_ONLINE);
		hotelBookingHelper.selectCheckInCheckOutDate();
		hotelBookingHelper.chooseHotel("SABRE","");
		hotelBookingHelper.fillOnlineBookingDetails();
		hotelBookingHelper.clickOnBookButton();
		hotelBookingHelper.verifyBookingConfirmation();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.cancelBooking();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.logOut(test);
		reportingUtils.setTestResult("PASS");
	}
	
//	@Test(groups={"NormalBook"})
	void SABREbookingByAddingNewVISACard() throws Throwable
	{
		String methodName=new Object(){}.getClass().getEnclosingMethod().getName();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		
		reportingUtils.setTestCaseNumber("TC05");
		reportingUtils.setSummary("Verify user is able to create SABRE booking");
		reportingUtils.setExecutionTime(timeStamp);
		reportingUtils.setTestCaseName(methodName);
		
		HotelBookingHelper hotelBookingHelper = new HotelBookingHelper();
//		hotelBookingHelper.initializeInputData();
		hotelBookingHelper.enterCustomerOrPNROrReferenceNumber(PowerModeConstants.TEST_PNR_SABRE,"SABRE");
		hotelBookingHelper.searcHotel(PowerModeConstants.SABRE_BOOKING_TEST_HOTEL_ONLINE);
		hotelBookingHelper.selectCheckInCheckOutDate();
		hotelBookingHelper.chooseHotel("SABRE","");
		hotelBookingHelper.addNewCard(PowerModeConstants.PAYMENT_CARD_VISA);
		hotelBookingHelper.fillOnlineBookingDetails();
//		hotelBookingHelper.clickOnBookButton();
//		hotelBookingHelper.verifyBookingConfirmation();
//		hotelBookingHelper.segmentVerification();
//		hotelBookingHelper.cancelBooking();
//		hotelBookingHelper.segmentVerification();
//		hotelBookingHelper.logOut(test);
		reportingUtils.setTestResult("PASS");
	}
	
//	@Test(groups={"AutoBook"})
	void SABREbookingWithAutoBookFeature() throws Throwable
	{
		String methodName=new Object(){}.getClass().getEnclosingMethod().getName();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		
		reportingUtils.setTestCaseNumber("TC05");
		reportingUtils.setSummary("Verify user is able to create SABRE booking with Auto Book feature");
		reportingUtils.setExecutionTime(timeStamp);
		reportingUtils.setTestCaseName(methodName);
		
		HotelBookingHelper hotelBookingHelper = new HotelBookingHelper();
//		hotelBookingHelper.initializeInputData();
		hotelBookingHelper.enterCustomerOrPNROrReferenceNumber(PowerModeConstants.TEST_PNR_SABRE,"SABRE");
		hotelBookingHelper.searcHotel(PowerModeConstants.SABRE_BOOKING_TEST_HOTEL_ONLINE);
		hotelBookingHelper.selectCheckInCheckOutDate();
		hotelBookingHelper.chooseHotel("SABRE","Auto Book");
		hotelBookingHelper.verifyBookingConfirmation();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.cancelBooking();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.logOut(test);
		reportingUtils.setTestResult("PASS");
		
	}
	
//	@Test(groups="DailyBooking")
	void AMADEUSbookingWithVISACard() throws Throwable
	{
		String methodName=new Object(){}.getClass().getEnclosingMethod().getName();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		
		reportingUtils.setTestCaseNumber("TC06");
		reportingUtils.setSummary("Verify user is able to create AMADEUS booking");
		reportingUtils.setExecutionTime(timeStamp);
		reportingUtils.setTestCaseName(methodName);
		
		HotelBookingHelper hotelBookingHelper = new HotelBookingHelper();
//		hotelBookingHelper.initializeInputData();
		hotelBookingHelper.enterCustomerOrPNROrReferenceNumber(PowerModeConstants.TEST_PNR_AMADEUS,"AMADEUS");
		hotelBookingHelper.searcHotel(PowerModeConstants.AMADEUS_BOOKING_TEST_HOTEL_ONLINE);
		hotelBookingHelper.selectCheckInCheckOutDate();
		hotelBookingHelper.chooseHotel("AMADEUS","");
		hotelBookingHelper.fillOnlineBookingDetails();
		hotelBookingHelper.clickOnBookButton();
		hotelBookingHelper.verifyBookingConfirmation();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.cancelBooking();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.logOut(test);
		reportingUtils.setTestResult("PASS");
		
	}
	
//	@Test(groups={"NormalBook","DailyBooking"})
	void AMADEUSbookingByAddingNewVISACard() throws Throwable
	{
		String methodName=new Object(){}.getClass().getEnclosingMethod().getName();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		reportingUtils.setTestCaseNumber("TC06");
		reportingUtils.setSummary("Verify user is able to create AMADEUS booking");
		reportingUtils.setExecutionTime(timeStamp);
		reportingUtils.setTestCaseName(methodName);
		
		HotelBookingHelper hotelBookingHelper = new HotelBookingHelper();
//		hotelBookingHelper.initializeInputData();
		hotelBookingHelper.enterCustomerOrPNROrReferenceNumber(PowerModeConstants.TEST_PNR_AMADEUS,"AMADEUS");
		hotelBookingHelper.searcHotel(PowerModeConstants.AMADEUS_BOOKING_TEST_HOTEL_ONLINE);
		hotelBookingHelper.selectCheckInCheckOutDate();
		hotelBookingHelper.chooseHotel("AMADEUS","");
		hotelBookingHelper.addNewCard(PowerModeConstants.PAYMENT_CARD_VISA);
		hotelBookingHelper.fillOnlineBookingDetails();
		hotelBookingHelper.clickOnBookButton();
		hotelBookingHelper.verifyBookingConfirmation();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.cancelBooking();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.logOut(test);
		reportingUtils.setTestResult("PASS");
		
	}
	
//	@Test(groups={"AutoBook","DailyBooking"})
	void AMADEUSbookingWithAutoBookFeature() throws Throwable
	{
		String methodName=new Object(){}.getClass().getEnclosingMethod().getName();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		
		reportingUtils.setTestCaseNumber("TC06");
		reportingUtils.setSummary("Verify user is able to create AMADEUS booking with Auto Book feature");
		reportingUtils.setExecutionTime(timeStamp);
		reportingUtils.setTestCaseName(methodName);
		
		HotelBookingHelper hotelBookingHelper = new HotelBookingHelper();
//		hotelBookingHelper.initializeInputData();
		hotelBookingHelper.enterCustomerOrPNROrReferenceNumber(PowerModeConstants.TEST_PNR_AMADEUS,"AMADEUS");
		hotelBookingHelper.searcHotel(PowerModeConstants.AMADEUS_BOOKING_TEST_HOTEL_ONLINE);
		hotelBookingHelper.selectCheckInCheckOutDate();
		hotelBookingHelper.chooseHotel("AMADEUS","Auto Book");
		hotelBookingHelper.verifyBookingConfirmation();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.cancelBooking();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.logOut(test);
		reportingUtils.setTestResult("PASS");
		
	}
	
	
	@Test()
	void OnRequestBookingFulfillNow() throws Throwable
	{
		String methodName=new Object(){}.getClass().getEnclosingMethod().getName();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		
		reportingUtils.setTestCaseNumber("TC06");
		reportingUtils.setSummary("Verify user is able to create On-request booking with Fulfill now feature");
		reportingUtils.setExecutionTime(timeStamp);
		reportingUtils.setTestCaseName(methodName);
		
		HotelBookingHelper hotelBookingHelper = new HotelBookingHelper();
//		hotelBookingHelper.initializeInputData();
		hotelBookingHelper.enterCustomerOrPNROrReferenceNumber(PowerModeConstants.TEST_PNR_AMADEUS,"AMADEUS");
		hotelBookingHelper.searcHotel(PowerModeConstants.BCOM_BOOKING_TEST_HOTEL);
		hotelBookingHelper.selectCheckInCheckOutDate();
		hotelBookingHelper.clickOnSearchHotels();
		hotelBookingHelper.chooseHotel("ONREQUEST","");
		hotelBookingHelper.fulFillNowDetailsAndClickBookButton();
		hotelBookingHelper.proceedButtonFulFillNow();
		hotelBookingHelper.verifyBookingConfirmationOnRequest();
		hotelBookingHelper.cancelBookingOnRequest();
		hotelBookingHelper.logOut(test);
		reportingUtils.setTestResult("PASS");
		
	}
	
	@Test(groups={"",""},priority=1)
	void VerificationOfRepeatBookingFeatureForBcom() throws Throwable
	{
		String methodName=new Object(){}.getClass().getEnclosingMethod().getName();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		
		reportingUtils.setTestCaseNumber("TC03");
		reportingUtils.setSummary("Verify user is able to perform repeat booking");
		reportingUtils.setExecutionTime(timeStamp);
		reportingUtils.setTestCaseName(methodName);
                                                                                                                                                                                                                      
		HotelBookingHelper hotelBookingHelper = new HotelBookingHelper();
//		hotelBookingHelper.initializeInputData();
		hotelBookingHelper.enterCustomerOrPNROrReferenceNumber(PowerModeConstants.TEST_PNR_AMADEUS,"AMADEUS");
		hotelBookingHelper.searcHotel(PowerModeConstants.BCOM_BOOKING_TEST_HOTEL);
		hotelBookingHelper.selectCheckInCheckOutDate();
		hotelBookingHelper.clickOnSearchHotels();
		hotelBookingHelper.chooseHotel("BCOM","Auto Book");
		hotelBookingHelper.verifyBookingConfirmation();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.cancelBooking();
//		hotelBookingHelper.segmentVerification();
		Thread.sleep(1000);
		hotelBookingHelper.repeatBooking(PowerModeConstants.TEST_PNR_AMADEUS);
		hotelBookingHelper.clickOnBookButton();
		hotelBookingHelper.verifyBookingConfirmation();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.cancelBooking();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.logOut(test);
		reportingUtils.setTestResult("PASS");
	}
	
	@Test(groups={"",""},priority=1)
	void VerificationOfRepeatBookingWhenRatesAreAvailable() throws Throwable
	{
		String methodName=new Object(){}.getClass().getEnclosingMethod().getName();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		
		reportingUtils.setTestCaseNumber("TC03");
		reportingUtils.setSummary("Verify user is able to create BCOM booking with Auto Book feature");
		reportingUtils.setExecutionTime(timeStamp);
		reportingUtils.setTestCaseName(methodName);

		HotelBookingHelper hotelBookingHelper = new HotelBookingHelper();
//		hotelBookingHelper.initializeInputData();
		hotelBookingHelper.enterCustomerOrPNROrReferenceNumber(PowerModeConstants.TEST_PNR_AMADEUS,"AMADEUS");
		hotelBookingHelper.searcHotel(PowerModeConstants.BCOM_BOOKING_TEST_HOTEL);
		hotelBookingHelper.selectCheckInCheckOutDate();
		hotelBookingHelper.clickOnSearchHotels();
		hotelBookingHelper.chooseHotel("BCOM","Auto Book");
		hotelBookingHelper.verifyBookingConfirmation();
		hotelBookingHelper.cancelBooking();
		Thread.sleep(1000);
		hotelBookingHelper.repeatBooking(PowerModeConstants.TEST_PNR_AMADEUS);
		hotelBookingHelper.clickOnBookButton();
		hotelBookingHelper.verifyBookingConfirmation();
		hotelBookingHelper.cancelBooking();
		hotelBookingHelper.logOut(test);
		reportingUtils.setTestResult("PASS");
	}
	
	@Test(groups={"",""},priority=3)
	void VerificationOfRepeatBookingFeatureForHHE() throws Throwable
	{
		String methodName=new Object(){}.getClass().getEnclosingMethod().getName();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		
		reportingUtils.setTestCaseNumber("TC04");
		reportingUtils.setSummary("Verify user is able to create HHE booking with Auto Book feature");
		reportingUtils.setExecutionTime(timeStamp);
		reportingUtils.setTestCaseName(methodName);
		
		HotelBookingHelper hotelBookingHelper = new HotelBookingHelper();
//		hotelBookingHelper.initializeInputData();
		hotelBookingHelper.enterCustomerOrPNROrReferenceNumber(PowerModeConstants.TEST_PNR_AMADEUS,"AMADEUS");
		hotelBookingHelper.searcHotel(PowerModeConstants.HHE_BOOKING_TEST_HOTEL);
		hotelBookingHelper.selectCheckInCheckOutDate();
		hotelBookingHelper.chooseHotel("HHE","Auto Book");
		hotelBookingHelper.chooseOtherRoom();
		hotelBookingHelper.verifyBookingConfirmation();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.cancelBooking();
		hotelBookingHelper.repeatBooking(PowerModeConstants.TEST_PNR_AMADEUS);
		hotelBookingHelper.clickOnBookButton();
		hotelBookingHelper.verifyBookingConfirmation();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.cancelBooking();
		hotelBookingHelper.logOut(test);
		reportingUtils.setTestResult("PASS");
		
	}
	
	@Test(groups={"",""},priority=3)
	void VerificationOfRepeatBookingFeatureForHHEWhenRatesAreNotAvailable() throws Throwable
	{
		String methodName=new Object(){}.getClass().getEnclosingMethod().getName();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		
		reportingUtils.setTestCaseNumber("TC04");
		reportingUtils.setSummary("Verify user is able to create HHE booking with Auto Book feature");
		reportingUtils.setExecutionTime(timeStamp);
		reportingUtils.setTestCaseName(methodName);
		
		HotelBookingHelper hotelBookingHelper = new HotelBookingHelper();
//		hotelBookingHelper.initializeInputData();
		hotelBookingHelper.enterCustomerOrPNROrReferenceNumber(PowerModeConstants.TEST_PNR_AMADEUS,"AMADEUS");
		hotelBookingHelper.searcHotel(PowerModeConstants.HHE_BOOKING_TEST_HOTEL);
		hotelBookingHelper.selectCheckInCheckOutDate();
		hotelBookingHelper.chooseHotel("HHE","Auto Book");
//		hotelBookingHelper.chooseOtherRoom();
		hotelBookingHelper.verifyBookingConfirmation();
//		hotelBookingHelper.segmentVerification();
//		hotelBookingHelper.cancelBooking();
		hotelBookingHelper.repeatBooking(PowerModeConstants.TEST_PNR_AMADEUS);
		hotelBookingHelper.clickOnBookButton();
		hotelBookingHelper.verifyBookingConfirmation();
//		hotelBookingHelper.segmentVerification();
		hotelBookingHelper.cancelBooking();
		hotelBookingHelper.cancelBooking();
		hotelBookingHelper.logOut(test);
		reportingUtils.setTestResult("PASS");
		
	}
	
	@Test()
	void VerificationOfRepeatBookingFeatureForOnRequest() throws Throwable
	{
		String methodName=new Object(){}.getClass().getEnclosingMethod().getName();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		
		reportingUtils.setTestCaseNumber("TC06");
		reportingUtils.setSummary("Verify user is able to create On-request booking with Fulfill now feature");
		reportingUtils.setExecutionTime(timeStamp);
		reportingUtils.setTestCaseName(methodName);
		
		HotelBookingHelper hotelBookingHelper = new HotelBookingHelper();
//		hotelBookingHelper.initializeInputData();
		hotelBookingHelper.enterCustomerOrPNROrReferenceNumber(PowerModeConstants.TEST_PNR_AMADEUS,"AMADEUS");
		hotelBookingHelper.searcHotel(PowerModeConstants.BCOM_BOOKING_TEST_HOTEL);
		hotelBookingHelper.selectCheckInCheckOutDate();
		hotelBookingHelper.clickOnSearchHotels();
		hotelBookingHelper.chooseHotel("ONREQUEST","");
		hotelBookingHelper.fulFillNowDetailsAndClickBookButton();
		hotelBookingHelper.proceedButtonFulFillNow();
		hotelBookingHelper.verifyBookingConfirmationOnRequest();
//		hotelBookingHelper.cancelBookingOnRequest();
		hotelBookingHelper.repeatBooking(PowerModeConstants.TEST_PNR_AMADEUS);
		hotelBookingHelper.cancelBookingOnRequest();
		hotelBookingHelper.logOut(test);
		reportingUtils.setTestResult("PASS");
		
	}
	
	@Test(dataProvider="dataProvide")
	public void cancelOnRequestBooking(String bref) throws InterruptedException
	{
		HotelBookingHelper hotelBookingHelper = new HotelBookingHelper();
		hotelBookingHelper.cancelBookingOnRequest();
		hotelBookingHelper.logOut(test);
	}
	
	@DataProvider
	public String[][] dataProvide()
	{
		String[][] bref={{"DN200002959-1"},{"DN200002956-1"},{"DN200002956-1"},{"DN200002954-1"},{"DN200002953-1"},{"DN200002951-1"},{"DN200002950-1"},{"DN200002945-1"},{"DN200002944-1"},{"DN200002937-1"},{"DN200002934-1"},{"DN200002933-1"},{"DN200002932-1"},{"DN200002929-1"},{"DN200002926-1"},{"DN200002925-1"},{"DN200002923-1"},{"DN200002920-1"},{"DN200002918-1"},{"DN200002917-1"},{"DN200002916-1"},{"DN200002913-1"},{"DN200002912-1"},{"DN200002907-1"},{"DN200002906-1"},{"DN200002902-1"},{"DN200002901-1"},{"DN200002900-1"},{"DN200002899-1"},{"DN200002898-1"},{"DN200002871-1"},{"DN200002848-1"},{"DN200002846-1"},{"DN200002835-1"}};
		return bref;
	}
	
	@Test
	void PNRRead() throws InterruptedException
	{
		HotelBookingHelper hotelBookingHelper = new HotelBookingHelper();
	}
	
	
}
