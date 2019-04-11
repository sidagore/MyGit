package com.hotelhub.powermode.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class ChooseHotelPage extends Base{
	
	public ChooseHotelPage()
	{
		PageFactory.initElements(driver(), this);
		
	}
	
//	@FindBy(xpath="(//img[contains(@id,'ImgBusy')])[1]")
//	public WebElement FIRST_RESULT_SPIN;
	
	@FindBy(xpath="(//img[contains(@src,'/v1/Content/images/loading1.gif')])[1]")
	public WebElement FIRST_RESULT_SPIN;
	
	
	
	@FindBy(xpath="//span[@class='badge badge-default']")
	public WebElement hotelSearchResults;
	
	@FindBy(xpath="//div[contains(text(),'Aggregator')]")
	public WebElement AGGREGATOR_LINK;
	
	@FindBy(xpath="//div[contains(text(),'RoomIt rates')]")
	public WebElement ROOM_IT_RATES_LINK;
	
	@FindBy(xpath="//div[contains(text(),'On Request Rates')]")
	public WebElement ON_REQUEST_RATES_LINK;
	
	@FindBy(xpath="//div[contains(text(),'Public Rates')]")
	public WebElement PUBLIC_RATES_LINK;
	
	@FindBy(xpath="//div[contains(text(),'Client rates')]")
	public WebElement CLIENT_RATES_LINK;
	
	@FindBy(xpath="//a[starts-with(@id,'viewdetails')]")
	public WebElement VIEW_DETAILS;
	
	@FindBy(xpath="//a[contains(text(),'View more rates')and contains(@id,'_4')]")
	public WebElement VIEW_ALL_RATES_ROOMIT;
	
	@FindBy(xpath="//a[contains(text(),'View more rates')and contains(@id,'_25')]")
	public WebElement VIEW_ALL_RATES_PUBLIC;
	
	@FindBy(xpath="//a[contains(text(),'View more rates')and contains(@id,'_26')]")
	public WebElement VIEW_ALL_RATES_AGGREGATOR;
	
	@FindBy(xpath="//a[contains(text(),'View more rates')and contains(@id,'_27')]")
	public WebElement VIEW_ALL_RATES_ONRQUEST;
	
	@FindBy(xpath="//div/div/span[contains(@data-original-title,'Booking.com')]/ancestor::div[1]/following-sibling::div[contains(text(),'Cancellable')]/ancestor::div[1]/following-sibling::div/div/a[contains(text(),'Select Rate')]")
	public WebElement SELECT_RATE_FIRST_BCOM_CANCELLABLE;
	
	@FindBy(xpath="//div/div/span[contains(@data-original-title,'Booking.com')]/ancestor::div[1]/following-sibling::div[contains(text(),'Cancellable')]/ancestor::div[1]/following-sibling::div/div/a[contains(text(),'Auto Book')]")
	public WebElement AUTO_BOOK_FIRST_BCOM_CANCELLABLE;
	
	@FindBy(xpath="//div[contains(text(),'Cancellable')]/ancestor::div[1]/following-sibling::div/div/a[contains(text(),'Select Rate')]")
	public WebElement SELECT_RATE_FIRST_ONLINE_CANCELLABLE;
	
	@FindBy(xpath="//div[contains(text(),'Cancellable')]/ancestor::div[1]/following-sibling::div/div/a[contains(text(),'Auto Book')]")
	public WebElement AUTO_BOOK_FIRST_ONLINE_CANCELLABLE;
	
	@FindBy(xpath="//div/div/span[contains(@data-original-title,'CRS by CWT')]/ancestor::div[1]/following-sibling::div[contains(text(),'Cancellable')]/ancestor::div[1]/following-sibling::div/div/a[contains(text(),'Select Rate')]")
	public WebElement SELECT_RATE_FIRST_HHE_CANCELLABLE;
	
	@FindBy(xpath="//div/div/span[contains(@data-original-title,'CRS by CWT')]/ancestor::div[1]/following-sibling::div[contains(text(),'Cancellable')]/ancestor::div[1]/following-sibling::div/div/a[contains(text(),'Auto Book')]")
	public WebElement AUTO_BOOK_FIRST_HHE_CANCELLABLE;
	
	@FindBy(xpath="//button[contains(text(),'On request')]")
	public WebElement ONREQUEST_BUTTTON;
		
	@FindBy(xpath="//h5[@class='has-no-margin']")
	public WebElement ROOMS_RATES;
	
	public static By ROOMS_RATES_BY() {
		By byObj = By.xpath("//h5[@class='has-no-margin']");
		return byObj;
	}
	
	public static By NO_ROOM_RATES_BY() {
		By byObj = By.xpath("//span[contains(text(),'No room or rate found.')]");
		return byObj;
	}
	
	@FindBy(xpath="(//div[contains(@id,'hotelinfopm')]/p)[1]")
	public WebElement HOTEL_INFORMATION_ADDRESS;
	
	@FindBy(xpath="(//div[contains(@id,'hotelinfopm')]/div)[1]/div/p")
	public WebElement HOTEL_INFORMATION_CONTACT;
	
	@FindBy(xpath="(//div[contains(@id,'hotelinfopm')]/p)[2]")
	public WebElement HOTEL_INFORMATION_DESCRIPTION;
	
	@FindBy(xpath="//h6[contains(text(),'Cancellation Policy')]//following::div[1]")
	public WebElement ROOM_DETAILS_CANCELLATION_POLICY;
	
	@FindBy(xpath="//h6[contains(text(),'Average Rate Per Night')]//following::div[1]")
	public WebElement ROOM_DETAILS_AVERAGE_RATE_PER_NIGHT;
	
	@FindBy(xpath="//h6[contains(text(),'Total Amount (Subject to taxes)')]//following::div[1]")
	public WebElement ROOM_DETAILS_TOTAL_AMOUNT;
	
	@FindBy(xpath="//h6[(text()='Tax')]//following::div[1]")
	public WebElement ROOM_DETAILS_TAX;
	
	@FindBy(xpath="//h6[contains(text(),'Cancellation Policy')]//following::div[1]")
	public WebElement ROOM_DETAILS_ROOM_DESCRIPTION;
	
	@FindBy(xpath="//h6[contains(text(),'Cancellation Policy')]//following::div[1]")
	public WebElement ROOM_DETAILS_RATE_DESCRIPTION;
	
	@FindBy(xpath="//h6[contains(text(),'Cancellation Policy')]//following::div[1]")
	public WebElement ROOM_DETAILS_ADDITIONAL_DETAILS;
	
	

}
