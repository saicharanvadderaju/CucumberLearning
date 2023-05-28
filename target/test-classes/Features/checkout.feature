Feature: Search and Place the Order for Products

@PlaceOrder
Scenario Outline: Search Experience for product search in home and offers page

Given user is on Greenkart landing page
When user searched with shortname <Name> and extracted actual name of product
And added "3" items of the selected product to the cart
Then user proceeds to checkout and validate <Name> items in checkout page
And verify user has the ability to apply promocode and place the order

Examples:
|  Name  |
|  Tom   |
