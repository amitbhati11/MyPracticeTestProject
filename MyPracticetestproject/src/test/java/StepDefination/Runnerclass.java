package StepDefination;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Feature",glue= {"StepDefination"},
plugin= {"pretty","json:JSON/JsonReport/report.json","html:HTML/htrmlReport/report.html","junit:JUNIT/Junitreport/report.xml"},
		
tags=("@smoke or @Regression or @sainty ")
		)

public class Runnerclass {

}
