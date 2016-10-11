Feature: As as Comparethemarket user
  I should be able to compare the energy prices in my area

  Background:
    Given I am on the comparethemarket energy page
    And I search for energy prices for postcode "PE2 6YS"

  @ctm
  Scenario Outline: Questions should dynamically show/hide when I have my bill handy
    When I <bill_handy?> my bill handy
    Then I <electricity_supply_questions> see question "Who supplies your electricity?"
    And I <gas_supply_question> see question "Who supplies your gas?"

    Examples:
      |bill_handy?          |electricity_supply_questions| gas_supply_question      |
      |have                 |should not                  |should not                |
      |dont have            |should                      |should                    |


  @ctm
  Scenario Outline: I should be asked additional questions if my gas and electricity suppliers aren't from same company
    Given I <bill_handy?> my bill handy
    When I want to compare gas and electricity
    And my gas and electricity <same_supplier?> from same supplier
    Then I <who_supplies_electricity_question> see question "Who supplies your electricity?"
    And I <who_supplies_gas_question> see question "Who supplies your gas?"

    Examples:
      |bill_handy?|same_supplier?   |who_supplies_electricity_question| who_supplies_gas_question   |
      |dont have  |are not          |should                           |should                       |
      |have       |are              |should not                       |should not                   |







