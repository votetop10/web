package com.cnn.capture.bdd.cucumber;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/test/resources/features/cnn/HomePage.feature",
        glue= {"com.new_york_times.capture.bdd.cucumber.stepdefinitions"}
        )
public class TestRunner {

}