module PrintUtilLib ( pprint ) where

-- a print utility for pretty printing the primes output
pprint :: [a1] -> [a2] -> (a2 -> b) -> [(a1, b)]
pprint first second func = zip first (map func second)