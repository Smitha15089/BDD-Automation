Feature: This feature file is to verify to temperature conversion from centigrade to Fahrenheit value using webpage url.

@WebUrlBasedConversion
Scenario Outline: This scenario validates the temperature conversion from centigrade to Fahrenheit value using Web URL
Given User launches temperature convertion site
And User enters centigrade value <CentigradeValue> for equivalent fahrenheit conversion
When User clicks on temperature convert button
Then User verify for web url based centigrade equivalent Fahrenheit value <FahrenheitValue>
And User close the browser

Examples:
|CentigradeValue|FahrenheitValue|
|       35      |       95.0    |