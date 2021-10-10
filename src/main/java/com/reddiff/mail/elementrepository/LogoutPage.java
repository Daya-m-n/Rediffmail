package com.reddiff.mail.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {
	
	@FindBy(linkText="Rediff Home")
	private WebElement rediffHomeLink;
	
	@FindBy(linkText="Feedback")
	private WebElement feedbackLink;
	
	public WebElement getRediffHomeLink() {
		return rediffHomeLink;
	}

	public WebElement getFeedbackLink() {
		return feedbackLink;
	}

	public LogoutPage(WebDriver driver) {
		super(driver);
	}
	
	public DashboardPage clickOnRediffHomeLink() {
		rediffHomeLink.click();
		return new DashboardPage(driver);
	}
	
	public FeedbackPage clickOnFeedbackLink() {
		feedbackLink.click();
		return new FeedbackPage(driver);
	}
}
