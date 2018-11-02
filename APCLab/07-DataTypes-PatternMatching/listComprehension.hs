areaOfTriangle :: Fractional a => (a, a) -> a
areaOfTriangle (b, h) = 0.5 * b * h

filterCapital s = [c | c <- s, c `elem` ['A'..'Z']]