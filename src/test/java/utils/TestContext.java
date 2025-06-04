package utils;

import base.WebDriverFactory;
import managers.PageObjectManager;

public class TestContext {

    private final PageObjectManager pageObjectManager;
    private final ScenarioContext scenarioContext;

    public TestContext() {
        pageObjectManager = new PageObjectManager(WebDriverFactory.getDriver());
        scenarioContext = new ScenarioContext();
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
