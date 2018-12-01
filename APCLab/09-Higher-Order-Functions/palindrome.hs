reverse' :: [a] -> [a]
-- reverse' = foldl (flip (:)) []
reverse' = foldl (\rest last -> last : rest) []

isPalindrome :: Eq a => [a] -> Bool
isPalindrome x = reverse' x == x

main = undefined