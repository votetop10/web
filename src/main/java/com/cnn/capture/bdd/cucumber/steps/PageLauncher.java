package com.cnn.capture.bdd.cucumber.steps;
import com.cnn.capture.bdd.cucumber.pages.CnnPage;
import net.thucydides.core.annotations.Step;

public class PageLauncher {
    private CnnPage page;

    @Step
    public void openPage() {
    	String url = "https://www.cnn.com/";
    	page.openAt(url);
    }
}
