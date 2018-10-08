maxFromList :: Ord a => [a] -> a
maxFromList [] = error "List is empty !"
maxFromList [x] = x
maxFromList (x:xs) = max x $ maxFromList xs

main :: IO()
main = print "Hello"