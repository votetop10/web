package com.cnn.capture.bdd.cucumber.pages;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.new_york_times.capture.bdd.cucumber.common.*;

public class CnnPage extends PageObject{
	
    @FindBy(linkText = "Business")
    private WebElement businessLink;
	
	public CnnPage(WebDriver driver) {
        super(driver);
    }
    
    public void clickBusinessLink(){
    	waitFor(businessLink);
    	businessLink.click();
    }
}
