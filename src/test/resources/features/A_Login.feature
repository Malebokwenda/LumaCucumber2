Feature: Login to Luna Application

  Background:
    Given User is on LumaLogin page "https://magento.softwaretestingboard.com"

    Scenario:
      When user enter a correct username and a correct password
      And clicks the login button
      Then user should be logged in to my account