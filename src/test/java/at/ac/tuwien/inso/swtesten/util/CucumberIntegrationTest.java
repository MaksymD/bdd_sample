package at.ac.tuwien.inso.swtesten.util;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Executes Cucumber .feature files as JUnit test.
 * <p>
 * The two @CucumberOptions run either all sample .feature Files from src/test/resources/sample/, currently active
 * or the file you are implementing during the lab from src/test/resources/lab/.
 * <p>
 * Do not forget to change activate the correct @CucumberOptions during the lab!
 */

@RunWith(Cucumber.class)

@CucumberOptions(features = {"src/test/resources/sample"},
	glue = {"at.ac.tuwien.inso.swtesten.sample1"}, //either "sample1" (Helper Pattern) or "sample2" (Page Object Pattern)
	plugin ={"pretty" , "html:cucumberReport"}
)
//@CucumberOptions(features = {"src/test/resources/lab"},
//		glue = {"at.ac.tuwien.inso.swtesten.lab"},
//		plugin ={"pretty" , "html:cucumberReport"}
//)
public class CucumberIntegrationTest {
}
