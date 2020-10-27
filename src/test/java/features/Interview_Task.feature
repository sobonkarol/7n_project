Feature: Interview Task

  @Interview_Task
  Scenario: Black iPhone 11 allegro.pl investigation
    Given User go to Allegro.pl
    When User is searching for "iPhone 11"
    And User is searching for black iPhone
    And Number of available offers on the first page is displayed
    Then The highest price on the first page is displayed

