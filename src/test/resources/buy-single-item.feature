Feature:Customer buys an item of clothing
 Description: Customer navigates clicks on an item and finalizes a purchase

 @BuySingleItem
 Scenario: Customer wants to buy a specific clothing item
  Given Customer is logged in
  When Customer clicks specific clothing item link
  And Customer adds item to cart
  And Customer continues shopping
  And Customer clicks another specific clothing item link
  And Customer adds another item to cart
  And Customer proceeds to checkout
  And Customer proceeds to shipping details
  And Customer agrees with the terms and conditions
  And Customer click pay by bank wire
  Then Customer confirms the order