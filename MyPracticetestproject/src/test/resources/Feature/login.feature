Feature: 

  @smoke
  Scenario Outline: verify with valid credentasils
    Given enter login url
    And verify with valid credentasils enter <username> and <password>
    When click on login button
    Then navigate to home page

    Examples: 
      | username | password |
      | amit     |    12345 |

  @sanity
  Scenario Outline: verify with invalid credentasils
    Given enter login url
    And verify with invalid credentasils enter <username> and <password>
    When click on login button
    Then navigate to home page

    Examples: 
      | username | password |
      | sumit    |   123456 |

  @Regression
  Scenario Outline: verify with valid credentasils
    Given enter login url
    And verify with valid credentasils enter <username> and <password>
    When click on login button
    Then navigate to home page

    Examples: 
      | username | password |
      | Ravi     |    12345 |

  @sanity @smoke
  Scenario Outline: verify with invalid credentasils
    Given enter login url
    And verify with invalid credentasils enter <username> and <password>
    When click on login button
    Then navigate to home page

    Examples: 
      | username | password |
      | sourav   |   123456 |

  Scenario Outline: verify with invalid credentasils
    Given enter login url
    And verify with invalid credentasils enter <username> and <password>
    When click on login button
    Then navigate to home page

    Examples: 
      | username | password |
      | sumitb   |  1234567 |
