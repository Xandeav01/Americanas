package americanas;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		dryRun     = false,
		monochrome = true,
		features   = { "src/test/resources/" },
		glue 	   = { "americanas/" },
		plugin	   = { "pretty",
					   "html:target/relatoriosimples",
					   "json:target/relatoriosimples.json",
					   "com.cucumber.listener.ExtentCucumberFormatter:target/relatoriodetalhado/dashboard.html"
					 }
)
public class Runner {

}
