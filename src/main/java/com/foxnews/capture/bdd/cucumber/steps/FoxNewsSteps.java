package com.foxnews.capture.bdd.cucumber.steps;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.List;
import java.util.Map;
import com.foxnews.capture.bdd.cucumber.pages.FoxNewsPage;
import net.thucydides.core.annotations.Step;

public class FoxNewsSteps {
	private FoxNewsPage fxPage;
	
    @Step
    public void clickBusinessLink(){
    	fxPage.clickBusinessLink();
    }
}