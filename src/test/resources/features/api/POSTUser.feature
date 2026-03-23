@POSTUser
Feature: User calls POST User

  Scenario Outline: User calls POST User <Scenario>
    Given User calls POST User with values:
      | name  | <name>  |
      | email | <email> |

#    Then Expected status code 200
#    Then User calls GET items by id
    Examples:
      | Scenario     | name | email          |
      | valid values | test | test@gmail.com |

