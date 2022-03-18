@sortbyOrder
Feature: Sort By Ascending Order

  @ValidateActingTimeline
  Scenario: Sort By Ascending Order
    Given  the user wants to sort top-rated movies by their date
    When  the user sorts by date on ascending order
    Then the user should see the dates of the first  movies in ascending order