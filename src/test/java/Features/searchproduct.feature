Feature: Search and Place the Order for Products

@SearchOffer
Scenario Outline: Search Experience for product search in home and offers page

Given user is on Greenkart landing page
When user searched with shortname <Name> and extracted actual name of product
Then user searched for <Name> shortname in offers page 
And validate productname in offerspage matches with landing page

Examples:
|  Name  |
|  Tom   |
|  Beet  |