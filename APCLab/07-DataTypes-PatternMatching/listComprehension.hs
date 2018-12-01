areaOfTriangle :: Fractional a => (a, a) -> a
areaOfTriangle (b, h) = 0.5 * b * h

filterCapital :: String -> String
filterCapital s = [c | c <- s, c `elem` ['A'..'Z']]

main = undefined