/**
 * 
 */
package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * @author TrungTH_CA
 *
 */

@CucumberOptions(
		
		features="src\\test\\java\\feature",
		glue = "definition"
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}
