package com.new_york_times.capture.bdd.cucumber.pages;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.new_york_times.capture.bdd.cucumber.common.*;

public class NYTimesPage extends PageObject{
	
    @FindBy(linkText = "Sports")
    private WebElement sportsLink;
  			
	public NYTimesPage(WebDriver driver) {
        super(driver);
    }
    
    public void clickSportsLink(){
    	waitFor(sportsLink);
    	sportsLink.click();
    }
}
