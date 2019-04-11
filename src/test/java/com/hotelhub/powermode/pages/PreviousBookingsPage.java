package com.hotelhub.powermode.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class PreviousBookingsPage extends Base {
	
	public PreviousBookingsPage()
	{
		PageFactory.initElements(driver(), this);
		
	}
	
	@FindBy(xpath="//button[contains(text(),'List bookings')]")
	public WebElement LIST_BOOKINGS;
		
	@FindBy(id="txtbookingnum")
	public WebElement BOOKING_REFERENCE;
	
//	@FindBy(xpath="//div[@class='col-lg-4 align-self-center']")
//	public WebElement BOOKING_REFERENCE_LIST;
	
	@FindBy(xpath="(//div[@class='col-4'])[2]")
	public WebElement BOOKING_REFERENCE_LIST;		
	
	@FindBy(xpath="//a[contains(@data-original-title,'GDS PNR')]")
	public WebElement PNR_LINK;
	
	@FindBy(xpath="//textarea[@class='form-control']")
	public WebElement PNR_TEXT;
	
	@FindBy(xpath="//*[@id='pnrCrypticReadContent']/div[1]/button/i")
	public WebElement PNR_PAGE_CLOSE;
	
//	@FindBy(xpath="//div[@class='modal-header']/button")
//	public WebElement PNR_PAGE_CLOSE;
	
	@FindBy(xpath="//button[@class='btn bg-s-base4 btn-sm']")
	public WebElement VIEW_EDIT_BOOKING;
	
	
	@FindBy(xpath="//i[@data-original-title='Cancel booking']")
	public WebElement CANCEL_ICON;

	
	@FindBy(id="btncancelyes")
	public WebElement CANCEL_YES;
	

	@FindBy(id="lblcancelnum")
	public WebElement CANCELLATION_REFRENCE_NUMBER;

	@FindBy(xpath="//div[@id='lblcancelclose']//i[@class='fa fa-1x icon-nm-tct-cancel-1']")
	public WebElement CANCELLATION_CLOSE;
	
	
	
	
	
	
	
}
