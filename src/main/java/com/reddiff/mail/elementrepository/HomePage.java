package com.reddiff.mail.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	@FindBy(linkText="Write mail")
	private WebElement writeMailLink;
	
	@FindBy(linkText="Logout")
	private WebElement logoutLink;
	
	@FindBy(id="TO_IDcmp2")
	private WebElement toTextField;
	
	@FindBy(xpath="//label[text()='Subject:']/following-sibling::input")
	private WebElement subjectTextField;
	
	@FindBy(css="iframe[title='Rich Text Editor, rdMailEditorcmp2']")
	private WebElement bodyFrame;
	
	public WebElement getBodyFrame() {
		return bodyFrame;
	}

	@FindBy(xpath="//body[contains(@class,'cke_editable_themed')]")
	private WebElement bodyTextArea;
	
	@FindBy(linkText="Send")
	private WebElement sendLink;
	
	@FindBy(linkText="Sent")
	private WebElement sentLink;
	
	@FindBy(xpath="//span[@class='rd_from']")
	private WebElement sentToEmail;
	
	@FindBy(xpath="//span[@class='rd_subject']")
	private WebElement sentToSubject;
	
	public WebElement getSentLink() {
		return sentLink;
	}

	public WebElement getSentToEmail() {
		return sentToEmail;
	}

	public WebElement getSentToSubject() {
		return sentToSubject;
	}

	public WebElement getWriteMailLink() {
		return writeMailLink;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getToTextField() {
		return toTextField;
	}

	public WebElement getSubjectTextField() {
		return subjectTextField;
	}

	public WebElement getBodyTextArea() {
		return bodyTextArea;
	}

	public WebElement getSendLink() {
		return sendLink;
	}

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void sendEmail(String emailId, String subject, String bodyText) {
		writeMailLink.click();
		toTextField.sendKeys(emailId);
		subjectTextField.sendKeys(subject);
		driver.switchTo().frame(bodyFrame);//transfer the driver control to frame from default content area
		bodyTextArea.sendKeys(bodyText);
		driver.switchTo().defaultContent();//transfer the driver control back to default content area
		sendLink.click();
	}
	
	public boolean isEmailSent(String emailId, String subject) {
		sentLink.click();
		return sentToEmail.getText().equalsIgnoreCase(emailId) 
				&& sentToSubject.getText().equalsIgnoreCase(subject);
	}
	
	public LogoutPage clickOnLogout() {
		logoutLink.click();
		return new LogoutPage(driver);
	}
}

