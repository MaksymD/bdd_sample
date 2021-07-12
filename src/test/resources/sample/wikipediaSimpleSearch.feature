# Gherkin Reference
# Keywords
# Each line that isn’t a blank line has to start with a Gherkin keyword, followed by any text you like.
# The only exceptions are the feature and scenario descriptions.
#
# The primary keywords are:
#
# Feature
# Rule (as of Gherkin 6)
# Example (or Scenario)
# Given, When, Then, And, But for steps (or *)
# Background
# Scenario Outline (or Scenario Template)
# Examples (or Scenarios)

# There are a few secondary keywords as well:
#
# "" (Doc Strings)
# | (Data Tables)
# @ (Tags)
# # (Comments)

Feature: Search for Wikipedia article

  Background:
	Given the browser language is "EN"
	And I am on the Wikipedia start page
	And the English version is selected

  Scenario Outline: direct search article
	When I enter the search term "<term>"
	Then the result page with heading "<result>" is shown

	Examples:
	| term | result |
	| BDD | BDD |
	| Apple | Apple|
	| Icecream | Ice cream |
