
Feature: Test App functionality

Scenario: Displaying the mainPage
    Given I have launched the MainActivity
    When I view the list
    Then I should see the list displayed

Scenario: Tap fab icon
    Given Open add page

Scenario: Adding a new item with valid input
    Given I have launched the MainActivity
    And I navigate to the AddItemFragment
    When I enter "New Item" in the todo text
    And I set the priority to 5
    And I click the submit button
    Then the new item should be added to the list

Scenario: Adding a new item with empty input
    Given I have launched the MainActivity
    And I navigate to the AddItemFragment
    When I leave the todo text empty
    And I click the submit button
    Then the new item should not be added to the list

Scenario: Tap toolbar icon
    Given I should navigate to settings Activity

   Scenario: Changing order type to name
     Given I have launched the SettingsActivity
     When I select the "Sort by Name" option
     Then the order type should be set to name

   Scenario: Changing order type to priority
     Given I have launched the SettingsActivity
     When I select the "Sort by Priority" option
     Then the order type should be set to priority

   Scenario: Toggling the ascending switch
     Given I have launched the SettingsActivity
     When I toggle the ascending switch
     Then the order should be set to ascending

Scenario: Sorting the list by priority
    Given I have set the sort order to priority ascending
    When I update the list
    Then the items should be sorted by priority in ascending order

Scenario: Displaying the no items label
    Given I have an empty list
    When I update the list
    Then I should see the no items label

