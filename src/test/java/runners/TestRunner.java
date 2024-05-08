package runners;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/results/swagLabs/cucumber-report.json", "html:target/results/flipTest"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = {"@flip"}
)


public class TestRunner extends BaseTestRunner{
}
