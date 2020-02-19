package com.runner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features="./src/main/java/in/com/hcl/ui/feature/OrderManagement.feature",
		features="./src/main/java/in/com/hcl/ui/feature/INGSavingMaximiser.feature",
		glue={"in.com.stepdefination"},
		plugin={"pretty", "html:target/Destination"}
		)
 


public class UIRunner 
{

}
