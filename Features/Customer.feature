Feature: Customers

@Test1
Scenario: Add a new Customer
	Given user launches Chrome browser 
	When User opens URL "http://admin-demo.nopcommerce.com/login" 
	And User enters Email as "admin@yourstore.com" and password as "admin" 
	And Click on Login
	Then User can view Dashboard
	When User click on customer Menu
	And click on customers Menu Item
	And click on Add new button
	Then User can view Add new customer page
	When User enter customer info
	And Click on Save button
	Then User can view confirmation message "The new customer has been added successfully."
	And close browser

@Test2	
Scenario: Serach Customer by EmaiID
	Given user launches Chrome browser 
	When User opens URL "http://admin-demo.nopcommerce.com/login" 
	And User enters Email as "admin@yourstore.com" and password as "admin" 
	And Click on Login
	Then User can view Dashboard
	When User click on customer Menu
	And click on customers Menu Item
	When User click on customer Menu
	And click on customers Menu Item
	And Enter customer Email
	When Click on search button
	Then User should found Email in the Search table
	And close browser
	 