package com.foxnews.capture.bdd.cucumber;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/test/resources/features/foxnews/HomePage.feature",
        glue= {"com.foxnews.capture.bdd.cucumber.stepdefinitions"}
        )
public class TestRunner {

}
