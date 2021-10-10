package com.reddiff.mail.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	@FindBy(id="login1")
	private WebElement usernameTextField;
	
	@FindBy(id="password")
	private WebElement passwordField;
	
	@FindBy(name="proceed")
	private WebElement signInButton;
		
	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getSignInButton() {
		return signInButton;
	}

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public HomePage login(String userData, String pwdData) {
		usernameTextField.sendKeys(userData);
		passwordField.sendKeys(pwdData);
		signInButton.click();
		return new HomePage(driver);
	}
	
}

