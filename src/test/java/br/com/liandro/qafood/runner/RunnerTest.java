package br.com.liandro.qafood.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber-report/cucumber.json", "html:target/generated-report/cucumber.html"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true,
        features = {"src/test/resources/features"},
        glue = {"br/com/liandro/qafood/steps"},
        tags = "@Regressive"
)
public class RunnerTest {

}
