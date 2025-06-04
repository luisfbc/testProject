package hooks;

import base.WebDriverFactory;
import io.cucumber.java.After;

public class Hooks {
    @After
    public void quitTest() {
        WebDriverFactory.quitDriver();
    }
}
