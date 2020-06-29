package runner

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.AfterClass
import org.junit.runner.RunWith
import util.Report_Builder

@RunWith(Cucumber::class)
@CucumberOptions(
    plugin = [
        "pretty",
        "html:src/main/report",
        "json:src/main/report/cucumber.json",
        "junit:src/main/report/cucumber.xml"
    ],
    features = [
        "src/main/resources/features"
    ],
    glue = [
        "stepDefinition",
        "hooks"
    ],
    stepNotifications = true,
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    strict = true,
    dryRun = false,
    monochrome = false,
    tags = [
        "@restAssured"
    ]
)
class Runner {

    companion object {
        @AfterClass
        @JvmStatic
        fun tearDown(){
            Report_Builder().main()
        }
    }
}