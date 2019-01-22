package com.cnn.capture.bdd.cucumber.stepdefinitions;
import java.util.List;
import java.util.Map;
import com.cnn.capture.bdd.cucumber.steps.CnnSteps;
import com.cnn.capture.bdd.cucumber.steps.PageLauncher;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.StepDefAnnotation;
import net.thucydides.core.annotations.Steps;

@StepDefAnnotation
public class CnnStepDefs {
		
	@Steps
	private CnnSteps cnnSteps;
	
	@Steps
	private PageLauncher pageLauncher;

	
	@Given("^I have navigated to the cnn home page$")
	public void i_am_viewing_the_ny_times_home_page() {
	    pageLauncher.openPage();
	}

	@Then("^I can click on the cnn Business link$")
	public void i_can_click_on_the_business_link()  {
		cnnSteps.clickBusinessLink();
	}
	
}