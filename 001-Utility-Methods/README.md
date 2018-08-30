# Utility Methods

This contains the utility and helper methods that i use

# Input-Helper

Don't you just really hate ``scanf`` ? when dealing with strings and numbers ? that freaking newline character will mess up your day, and you will wander about thinking what the hell did i do wrong, and that address operator ? i know its silly, lekin shubham saale uske wajah se pura time waste kar diya tune.
So why not concentrate on the bigger picture and just use my input\_helper ?

# Methods Available

``next_int`` - very simple, to read integers
Params: None
Returns: int

``get_word`` - to read a word
Params: address to the pointer to the char
Example:
```c
    char *word;
    get_word(&word); // don't worry i'll do your memory allocation for you, chill
    printf("%s", word);
```

``get_line`` - to read a complete line
Params: address to the pointer to the char
Returns: length of the sentence, so you can keep going if you want to paragraph
something like
```c
    char *line;
    while (get_line(&line) > 0) {
        // Do stuff
        // this loop will go on until the user gives a empty line or EOF is encountered
    }
``` 
