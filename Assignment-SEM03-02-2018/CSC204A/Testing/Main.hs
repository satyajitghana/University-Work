nthprime :: Int -> Integer
nthprime x = primes !! (x-1)

primes :: [Integer]
primes = [x | x <- [2..], isPrime x]

isPrime :: Integer -> Bool
isPrime x = all (\p -> x `mod` p > 0) [2..(floor $ sqrt(fromIntegral x))]

-- primes :: [Integer]
-- primes = 2:[x | x <- [3,5..], isPrime x]

-- isPrime :: Integer -> Bool
-- isPrime x = all (\p -> x `mod` p > 0) (takeWhile (\q -> q*q < x) primes)

coprime :: Integer -> Integer -> Bool
coprime x y = gcd x y == 1

menu' :: Integer -> IO()
menu' choice = case choice of
    1 -> do
        putStr "Enter the value of n : "
        input <- getLine
        print (nthprime (read input :: Int))
    _ -> putStrLn "Wrong Choice"

menu :: IO()
menu = do
    putStrLn "1.\tGenerate the nth prime\n2.\tIs given number prime\n3.\tAre numbers coprime"
    input <- getLine
    menu' (read input :: Integer)

main :: IO()
main = menu