package com.foxnews.capture.bdd.cucumber.steps;
import com.foxnews.capture.bdd.cucumber.pages.FoxNewsPage;

import net.thucydides.core.annotations.Step;

public class PageLauncher {
    private FoxNewsPage page;

    @Step
    public void openPage() {
    	String url = "https://www.foxnews.com/";
    	page.openAt(url);
    }
}
