Feature: As a user, I should be able to compare energy prices from various providers


  @ctm
  Scenario: I should be able to create a new compare request
    Given I am on the comparethemarket energy page
    And I search for energy prices for postcode "PE2 6YS"
    When I enter all the mandatory information for creating a compare request
    Then I should see all the providers with prices


