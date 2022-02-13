Feature: Navigating to specific accounts in Accounts Activity

  @login
  Scenario Outline: <AccountType> Account redirect
    Given the user is logged in
    When the user clicks on "<AccountType>" link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have "<AccountType>" selected

    Examples:
      | AccountType |
      | Savings     |
      | Brokerage   |
      | Checking    |
      | Credit Card |
      | Loan        |









