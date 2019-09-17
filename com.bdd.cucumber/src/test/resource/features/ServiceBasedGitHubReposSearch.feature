Feature: This feature file is to verify the service based searching of Git Hub repos using a search keyword.

@ServiceBasedGitHubSearch
Scenario Outline: This scenario verify the searching of Git Hub repos using a search keyword.
Given User enter the url <URL>
And User enters search keyword <Keyword> for searching the api
When User trigger the service
Then User verify for successfull HTTP response code <ResponseCode>

Examples:
|			URL								| Keyword   |ResponseCode |
|https://api.github.com/search/repositories |  angular4 |     200     |
|https://api.github.com/search/repositories |   Java    |     200     |