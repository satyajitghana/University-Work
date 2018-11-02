quicksort :: Ord t => [t] -> [t]

quicksort [] = []
quicksort (x:xs) = 
    smallerthanx ++ [x] ++ largerthanx
        where smallerthanx = quicksort [a | a <- xs, a <=x]
              largerthanx = quicksort  [a | a <- xs, a > x]