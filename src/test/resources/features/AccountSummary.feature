Feature: Account summary page should have the title Zero – Account summary.

  Scenario: user loggin and confirm that title is changed
    When Authorized user logged in
    Then  user click on account Summary
    And title should has "Zero - Account Summary"

  Scenario: Account summary Page should contains following options

    When Authorized user logged in
    Then user click on account Summary
    And  following modules should be displayed
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |


  Scenario: Credit Accounts table must have columns Account, Credit Card and Balance.
    When Authorized user logged in
    Then user click on account Summary
    And Credit Accounts table must have columns
      | Account     |
      | Credit Card |
      | Balance     |



    Scenario: Brokerage account redirect
      When Authorized user logged in
      Then  user click on account Summary
      Then user click on brokerage and should be redirected
      And account droupdown should change to "Brokerage"

  Scenario: Brokerage account redirect
    When Authorized user logged in
    Then  user click on account Summary
    Then user click on checking and should be redirected
    And account dropdown should change to "Checking"


  Scenario: Brokerage account redirect
    When Authorized user logged in
    Then  user click on account Summary
    Then user click on creditCard and should be redirected
    And account dropdown should change to "Credit Card"

  Scenario: Brokerage account redirect
    When Authorized user logged in
    Then  user click on account Summary
    Then user click on loan and should be redirected
    And account dropdown should change to "Loan"



