header :: IO ()
header = putStrLn $ take 50 $ cycle "-"

numericOperations :: IO ()
numericOperations = do
    putStr "2+15 = "
    print $ 2+15
    putStr "49*100 = "
    print $ 49*100
    putStr "5/2 = "
    print $ 5/2
    putStr "50*(100-4999) = "
    print $ 50 * (100 - 4999)

logicalOperations :: IO ()
logicalOperations = do
    putStr "True && False = "
    print $ True && False
    putStr "True && True = "
    print $ True && True
    putStr "False || True = "
    print $ False || True
    putStr "not False = "
    print $ not False
    putStr "not (True && True) = "
    print $ not (True && True)

comparisonOperations :: IO ()
comparisonOperations = do
    putStr "5 == 5 = "
    print $ 5 == 5
    putStr "1 == 0 = "
    print $ 1 == 0
    putStr "5 /= 0 = "
    print $ 5 /= 4
    putStr "hello == hello = "
    print $ "hello" == "hello"

callingFunctions :: IO ()
callingFunctions = do
    putStr "succ 8 = "
    print $ succ 8
    putStr "min 9 10 = "
    print $ min 9 10
    putStr "min 3.4 3.2 = "
    print $ min 3.4 3.2
    putStr "max 100 101 = "
    print $ max 100 101
    putStr "succ 9 + max 5 4 + 1 = "
    print $ succ 9 + max 5 4 + 1
    putStr "92 div 10 = "
    print $ 92 `div` 10

doubleMe :: Num a => a -> a    
doubleMe x = x + x

doubleUs :: Num a => a -> a -> a
doubleUs x y = doubleMe x + doubleMe y

doubleSmallNumber :: (Num a, Ord a) => a -> a
doubleSmallNumber x = if x > 100 then x else x + 2

mathTest :: IO ()
mathTest = do
    header
    putStrLn "Welcome to a Quick Math Test"
    putStrLn "What is 2 + 2?"
    x <- readLn :: IO Integer
    if x == 4
        then putStrLn "You're right!"
        else putStrLn "You're wrong!"

listOperations :: IO ()
listOperations = do
    header
    let myList = [x | x <- [1..100], x `mod` 7 == 0]
    putStr "myList = "
    print myList
    putStrLn "Concatenate a element at the BEGINNING of List using (:)"
    print . show $ 10:myList
    putStrLn "Concatenate two Lists using (++)"
    print . show $ myList++[3, 5..15]
    putStrLn "Accessing List Elements"
    print . show $ myList
    putStrLn $ "4th Element in List is "++ show (myList!!4)
    putStrLn $ "head myList = " ++ show (head myList)
    putStrLn $ "tail myList = " ++ show (tail myList)
    putStrLn $ "last myList = " ++ show (last myList)
    putStrLn $ "init myList = " ++ show (init myList)
    putStrLn $ "length myList = " ++ show (length myList)
    putStrLn $ "reverse myList = " ++ show (reverse myList)
    putStrLn "Comparing Lists"
    putStr "[3, 2, 1] > [2, 1, 0] = "
    print $ [3, 2, 1] > [2, 1, 0]
    putStr "[3, 4, 2] < [3, 4, 3] = "
    print $ [3, 4, 2] < [3, 4, 3]
    putStr "[3, 4, 2] == [3, 4, 2] = "
    print $ [3, 4, 2] == [3, 4, 2]

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
    listOperations

    print $ "Zippping two lists into Tuples : " ++ show zipping
    header
    print $ "Find Right Triangles : " ++ show findRightTriangle
    header
    print $ "The Fibonacci Sequence : " ++ show (take 15 fibonacci)
    header
    nestedLists
    header
    print $ "Removing lower case letters from IdontLIKEFROGS : " ++ removeNonUpperCase "IdontLIKEFROGS"
    header
    print $ "Length of list [1..10] is : "++ show (length' [1..10])
    header
    -- putStr "FizzBuzz : \b "
    -- print ( map fizzBuzz [1..100])
    -- header
