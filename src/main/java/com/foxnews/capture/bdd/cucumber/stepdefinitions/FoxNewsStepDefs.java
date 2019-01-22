package com.foxnews.capture.bdd.cucumber.stepdefinitions;
import java.util.List;
import java.util.Map;
import com.foxnews.capture.bdd.cucumber.steps.FoxNewsSteps;
import com.new_york_times.capture.bdd.cucumber.steps.PageLauncher;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.StepDefAnnotation;
import net.thucydides.core.annotations.Steps;

@StepDefAnnotation
public class FoxNewsStepDefs {
		
	@Steps
	private FoxNewsSteps fxSteps;
	
	@Steps
	private PageLauncher pageLauncher;

	
	@Given("^I have navigated to the fox news home page$")
	public void i_am_viewing_the_ny_times_home_page() {
	    pageLauncher.openPage();
	}

	@Then("^I can click on the fox news business link$")
	public void i_can_click_on_the_sports_link()  {
		fxSteps.clickBusinessLink();
	}
	
}