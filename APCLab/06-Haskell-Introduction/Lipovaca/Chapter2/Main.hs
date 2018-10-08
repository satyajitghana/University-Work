bounds :: String
bounds = show ("Int Bound "++show ((minBound, maxBound) :: (Int, Int)))

main :: IO()
main = print bounds