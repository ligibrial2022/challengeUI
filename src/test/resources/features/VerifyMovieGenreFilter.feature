

@VerifyMovieGenre
Feature: VerifyGenreFilter

  @VerifyMovieGenre
  Scenario Outline: VerifyGenreFilter

  Given the user wants to see the top-rated movies
  And the user wants to filter for ‘action’ movies
  When the user applies the ‘action’ filter
  And the user selects any movie <nameMovie>
  Then the user should see the genre of the movie includes <genreToCompare>

    Examples:
      |nameMovie                                    |genreToCompare |
      |"Evangelion: 3.0+1.0 Thrice Upon a Time"     | "Action"      |