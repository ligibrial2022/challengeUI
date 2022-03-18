@SuccessfullySearch
Feature: Successfully Search

  @SuccessfullySearch
  Scenario Outline: SuccessfullySearch
    Given the user wants to search for a movie
    When   the user enters the title <nameMovie>
    Then  the user should see the movie as the first result <nameMoviestoCompare>

    Examples:
      |nameMovie        |nameMoviestoCompare |
      |"Fight Club"     | "Fight Club"        |
