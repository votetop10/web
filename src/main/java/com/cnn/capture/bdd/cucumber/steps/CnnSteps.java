package com.cnn.capture.bdd.cucumber.steps;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.List;
import java.util.Map;
import com.cnn.capture.bdd.cucumber.pages.CnnPage;
import net.thucydides.core.annotations.Step;

public class CnnSteps {
	private CnnPage cnnPage;
	
    @Step
    public void clickBusinessLink(){
    	cnnPage.clickBusinessLink();
    }
}