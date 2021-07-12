package at.ac.tuwien.inso.swtesten.sample1;

import io.cucumber.java8.En;

public class WikipediaStepDefinitions implements En {

	private WikipediaSeleniumHelper wikiSeleniumHelper = new WikipediaSeleniumHelper();

	public WikipediaStepDefinitions() {

		AfterStep(scenario -> {
			if(scenario.isFailed()) {
				scenario.embed(wikiSeleniumHelper.takeScreenshot(), "image/png");
			}
		});

		//wikipediaSimpleSearch

		Given("the browser language is {string}", (String locale) -> {
			wikiSeleniumHelper.setBrowserLanguage(locale);
		});

		Given("I am on the Wikipedia start page", () -> {
			wikiSeleniumHelper.setUp();
		});

		Given("the English version is selected", () -> {
			wikiSeleniumHelper.selectLanguage();
		});

		When("I enter the search term {string}", (String searchTerm) -> {
			wikiSeleniumHelper.search(searchTerm);
		});

		Then("the result page with heading {string} is shown", (String searchResult) -> {
			wikiSeleniumHelper.assertSearchResultByText(searchResult);
			wikiSeleniumHelper.shutDown();
		});

		//wikipediaSimpleWrongSearch

		When("I enter the invalid search term {string}", (String invalidSearchTerm) -> {
			wikiSeleniumHelper.search(invalidSearchTerm);
		});

		Then("no results are found and an error message {string} is displayed", (String heading) -> {
			wikiSeleniumHelper.assertArticleNotExists(heading);
			wikiSeleniumHelper.shutDown();
		});

	}
}
