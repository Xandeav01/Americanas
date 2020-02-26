Feature: Buy in Americanas.com
	Scenario: Add to Cart
		Given I acess Americanas site
		When I type the term "Armani Code" and click Enter and I click in a product 
		And I press Buy 
		Then I see the Carts Page



