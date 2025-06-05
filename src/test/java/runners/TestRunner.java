package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefs", "hooks"},
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
