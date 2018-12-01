power x n | n == 0 = 1
          | otherwise = x * power x (n-1)

parse :: String -> [Double]
parse = map read . words

main :: IO()
main = do
    putStrLn "Enter a b m n"
    input <- getLine
    let [a,b,m,n] = parse input
    putStrLn $ "a^b.b^m = " ++ show (power a b * power b m)
    putStrLn $ "(a/b)+(b/a) = " ++ show ((a/b) + (b/a))
    putStrLn "Enter x y"
    input <- getLine
    let [x,y] = parse input
    putStrLn $ "x^2/(1+y^2) + (x+y^2) = " ++ show ((x^^2/(1+y^^2))+(x+y^^2))