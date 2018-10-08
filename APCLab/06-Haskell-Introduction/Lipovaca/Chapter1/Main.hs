import Data.List.Split

header :: IO()
header = putStrLn $ take 50 $ cycle "-"

mathTest :: IO()
mathTest = do
    header
    putStrLn "Welcome to a Quick Math Test"
    putStrLn "What is 2 + 2?"
    x <- readLn :: IO Integer
    if x == 4
        then putStrLn "You're right!"
        else putStrLn "You're wrong!"

concatenation :: IO()
concatenation = do
    header
    putStrLn "Concatenate a element at the BEGINNING of List using (:)"
    print . show $ 10:[1, 2, 3, 4]
    putStrLn "Concatenate two Lists using (++)"
    print . show $ [1,2..10]++[3, 5..15]
    putStrLn "Accessing List Elements"
    let myList = [x | x <- [1..100], x `mod` 7 == 0]
    print . show $ myList
    putStrLn $ "4th Element in List is "++ show (myList!!4)

zipping :: [(Integer, String)]
zipping = zip [1..] ["apple", "orange", "cherry", "mango"]

findRightTriangle :: [(Integer, Integer, Integer)]
findRightTriangle = [(a, b, c) 
    | a <- [1..10], b <- [1..10], c <- [1..10],
    c^2 == a^2 + b^2]

fibonacci :: [Integer]
fibonacci = 0 : 1 : [a+b | (a, b) <- zip fibonacci (tail fibonacci)]

nestedLists :: IO()
nestedLists = do
    let xxs = [[1,3,5,2,3,1,2,4,5], [1..9],[1,2]]
    print . show  $ xxs
    putStrLn "Only Evens from the nested List "
    print . show  $ [[x | x <- xs, even x] | xs <- xxs]

length' :: [a] -> Integer
length' xs = sum [1 | _ <- xs]

removeNonUpperCase :: String -> String
removeNonUpperCase st = [c | c <- st, c `elem` ['A'..'Z']]

fizzBuzz :: Integer -> String
fizzBuzz x
    | x `mod` 15 ==0 = "FizzBuzz"
    | x `mod` 5 == 0 = "Fizz"
    | x `mod` 3 == 0 = "Buzz"
    | otherwise = show x

numStrs :: [String]
numStrs = ["Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"]

--num2Str :: Integer -> String
--num2Str x = numStrs !! (x)

main :: IO ()
main = do
    --mathTest
    concatenation
    print $ "Zippping two lists into Tuples : " ++ show zipping
    header
    print $ "Find Right Triangles : " ++ show findRightTriangle
    header
    print $ "The Fibonacci Sequence : " ++ show (take 15 fibonacci)
    header
    nestedLists
    header
    print $ "Removing lower case letters from \"IdontLIKEFROGS\"" ++ removeNonUpperCase "IdontLIKEFROGS"
    header
    print $ "Length of list [1..10] is : "++ show (length' [1..10])
    header
    putStr "FizzBuzz : \b "
    print ( map fizzBuzz [1..100])
    header
