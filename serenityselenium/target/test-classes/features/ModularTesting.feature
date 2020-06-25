Feature: Lookup a definition

  
  Scenario: Looking up the definition of 'apple'
    Given the user is on the Wikionary home page
    Then the user looks up the definition of the word 'Apple'
    