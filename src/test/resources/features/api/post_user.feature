@POSTUser
Feature: User calls POST User

  Scenario Outline: User calls POST User <Scenario>
    Given User calls POST User with values:
      | name  | <name>  |
      | email | <email> |
    Then Validate POST User response
    Examples:
      | Scenario     | name | email          |
      | valid values | test | test@gmail.com |

