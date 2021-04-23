# power-nine
The main functionality in this branch is the search endpoint which can be reached at `<host address>/search`. Currently its hosted at http://localhost:8080/search it takes a post http request and takes a `Search` object.
This object has the following fields coresponding to different fields that should come from an html form POST method

- String `name`
  - takes a string and preforms a regex on card names. The search is case insensitive
- String[] `color`
  - takes all colors wanted in the search. Colors should be repersented by "W", "U", "B", "R", "G"
  - these repersent the colors white, blue, black, red, and green repsoectively (should come from checkboxes)
- String `matching`
  - takes a string of either `"exactly"` or `"any"`. This will select weather cards returned match any of the above colors or match exactly.
- String `statMatching`
  - this takes one of 5 strings to determine what type of search criteria will be added
   
    -`"exactly"`        cards must have exactly the given stat
   
    -`"greater"`        cards must have greater than the given stat
    
    -`"less"`           cards must have less than the given stat
    
    -`"greaterEqual"`   cards must have greater than or equal to the given stat
    
    -`"lessEqual"`      cards must have less than or equal to the given stat
- Integer `stat` This is an integer that is the actual stat value
- String `statType`
  - this will have the type of stat the user is searching for. it should have one of the following values
    
    -`"power"`
    
    -`"toughness"`
    
    -`"loyalty"`
    
    -`"cmc"`
- String[] `rarity`
  -This currently only supports a single rarity being chosen but will soon allow any rarity
    
    -`"common"`
    
    -`"uncommon"`
    
    -`"rare"`
    
    -`"mythic"`
