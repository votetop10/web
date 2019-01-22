package com.new_york_times.capture.bdd.cucumber.steps;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.List;
import java.util.Map;
import com.new_york_times.capture.bdd.cucumber.pages.NYTimesPage;
import net.thucydides.core.annotations.Step;

public class NYTimesSteps {
	private NYTimesPage nytPage;
	
    @Step
    public void clickSportsLink(){
    	nytPage.clickSportsLink();
    }
}