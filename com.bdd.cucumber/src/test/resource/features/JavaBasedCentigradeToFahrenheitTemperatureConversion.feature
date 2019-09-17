Feature: This feature file is to verify to temperature conversion from centigrade to Fahrenheit value using standard java program.

@FormulaBasedConversion
Scenario Outline: This scenario validates the temperature conversion from centigrade to Fahrenheit value using standard java program
Given User enters centigrade value <CentigradeValue> for converting the temperature from centigrade to fahrenheit
When User triggers to convert centigrade value to fahrenheit value
Then User verify for formula based centigrade equivalent Fahrenheit value <Fahrenheitvalue>

Examples:
|CentigradeValue|Fahrenheitvalue|
|       35      |       95.0    |
