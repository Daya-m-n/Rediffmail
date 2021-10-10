package com.reddiff.mail.elementrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
	
	@FindBy(xpath="//div[@class='cell topicons']/a")
	private List<WebElement> menuIconsList;
	
	public List<WebElement> getMenuIconsList() {
		return menuIconsList;
	}

	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	public BasePage clickOnMenuIcon(String menuName) {
		for(WebElement ele:menuIconsList) {
			if(ele.getText().equalsIgnoreCase(menuName)) {
				ele.click();
				break;
			}
		}
		
		menuName = menuName.toLowerCase();
		switch(menuName) {
			case "rediffmail": return new LoginPage(driver);
			case "money": return new MoneyPage(driver);
			case "enterprise email": return new EnterpriseEmailPage(driver);
			case "videos": return new VideosPage(driver);
			case "business email": return new BusinessEmailPage(driver);
			case "shopping": return new ShoppingPage(driver);
			default: return null;
		}
	}
}
