@rebalance
Feature: CNet Global Login Scenario

  @rebalance
  Scenario Outline: Login
    Given Launch Browser and Navigate to CNet URL
    Then Switch to MainFrame
    And Verify whether Login page is correctly opened or not
    When Enter Username and Password as "<Username>" and "<Password>"
    Then Verify whether Home page is correctly opened or not
    When Click on User Menu Dropdown
    And Click on Logout

    Examples: 
      | Username  |  | Password |
      | test.user |  | test     |
