@POSTItem
Feature: User calls GET Booking

  Scenario Outline:

    And User calls POST Items with "<OverrideField>"
    Examples:
      | Scenario               | OverrideField       |
      | User calls POST        |                     |
      | User calls Custom name | name=test,year=2025 |


