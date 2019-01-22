package com.new_york_times.capture.bdd.cucumber.steps;
import com.new_york_times.capture.bdd.cucumber.pages.NYTimesPage;
import net.thucydides.core.annotations.Step;

public class PageLauncher {
    private NYTimesPage page;

    @Step
    public void openPage() {
    	String url = "https://www.nytimes.com/";
    	page.openAt(url);
    }
}
