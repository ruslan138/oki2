Feature: Pay Bills page should have the title Zero – Pay Bills.

  Scenario: when user click on Pay bills title should change

    When Authorized user logged in
    Then user click on checking account Summary
    Then  click on Pay Bills
    And  title is should change to "Zero - Pay Bills"


    Scenario:  user completes a successful Pay operation, The payment was successfully submitted.
      When Authorized user logged in
      Then  user click on checking account Summary
      Then click on Pay Bills
      And fill out all form succesful notification should displayed "The payment was successfully submitted."
