Feature: Account Activity page should have the title Zero – Account activity.

  Scenario: user login and title changes

    When Authorized user logged in
    Then user click on checking account Summary
    Then  title is changes to "Zero - Account Activity"

  Scenario: accountDropdown should have following options Savings, Checking, Loan, Credit Card, Brokerage.
    When Authorized user logged in
    Then  user click on checking account Summary
    Then  default options on Account column Should be "Savings"
    And  accountDropdown should have following options
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  Scenario: Transactions table should have column names

    When Authorized user logged in
    Then user click on checking account Summary
    And Transactions table should have column names
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |


  Scenario: Search description
    Given Authorized user logged in
    When user click on checking account Summary
    And  user Click on findTransaction
    Then results table should only show descriptions containing "ONLINE" and click, search description should contain given word
    Then results table should only show descriptions containing "OFFICE" search description should contain given word


  Scenario: Search description case insensitive
    Given Authorized user logged in
    When user click on checking account Summary
    And user Click on findTransaction
    Then results table should only show descriptions containing "ONLINE" and click, search description should contain given word
    When the user enters description "online" and confrims that given word not displayed


  Scenario: Type
    Given Authorized user logged in
    Then  user click on checking account Summary
    And user Click on findTransaction
    Then then under Type module he  selecting type "Deposit" and results table should show at least one result under Deposit


  Scenario: Type
    Given Authorized user logged in
    Then  user click on checking account Summary
    And user Click on findTransaction
    Then then under Type module he  selecting typee "Withdrawal" and results table should show at least one result under Widhrawal


  Scenario Outline: Add a new payee
    Given Authorized user logged in
    Then user click on checking account Summary
    Then  click on Pay Bills and go to new payee
    And creates new payee using following information "<Payee Name>" ,"<Payee Address>" , "<Account>" , "<Payee details>"
    Then  "The Law Offices of Hyde, Price & Scharks was successfully created" should be displayed

    Examples: below
      | Payee Name                               | Payee Address                    | Account  |  | Payee details |
      | The Law Offices of Hyde, Price & Scharks | 100 Same st, Anytown, USA, 10001 | Checking |  | XYZ account   |


  Scenario: Available currencies
    Given Authorized user logged in
    Then user click on checking account Summary
    Then  click on Pay Bills and go purchuase new currency
    Then following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Hong Kong (dollar)    |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Sweden (krona)        |
      | Singapore (dollar)    |
      | Thailand (baht)       |





  Scenario: Error message for not selecting currency
    Given Authorized user logged in
    Then user click on checking account Summary
    Then  click on Pay Bills and go purchuase new currency
    When user tries to calculate cost without selecting a currency eror message should be displayed


  Scenario: Error message for not entering value
    Given Authorized user logged in
    Then user click on checking account Summary
    Then  click on Pay Bills and go purchuase new currency
    Then user tries to calculate cost without entering a value , error message should be displayed


