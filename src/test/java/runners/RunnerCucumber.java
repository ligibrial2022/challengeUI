package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import io.cucumber.junit.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features"
        ,tags = "@Login"
        ,snippets = SnippetType.CAMELCASE
        ,glue = "steps")

@RunWith(CucumberWithSerenity.class)
public class RunnerCucumber {

}
