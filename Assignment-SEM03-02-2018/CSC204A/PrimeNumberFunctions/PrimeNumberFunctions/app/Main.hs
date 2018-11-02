{-# LANGUAGE ScopedTypeVariables #-}
module Main where

import System.Environment
import Control.Exception
import Data.Maybe
import PrimesLib
import PrintUtilLib

-- reads a String as an Integer
readNum :: String -> Integer
readNum p = read p :: Integer

-- isprime : takes in the numbers which are to be checked for prime
isprime :: [Integer] -> [String] -> IO ()
isprime primesList nums
    | length nums <= 0 = error "Enter at least one number"
    | otherwise = print (pprint numbers numbers (isPrime primesList))
        where numbers = map readNum nums

-- nthprime : prints the nth prime from the list of primes
nthprime :: [Integer] -> [String] -> IO ()
nthprime primesList nums 
    | length nums <= 0 = error "Enter at least one number"
    -- gives just the list of the nth primes
    -- | otherwise = print ( map ((\ q -> primes !! (q - 1)) . (\p -> (fromIntegral p) :: Int ) . readNum) nums )
    -- zips the input and the output for prettier and understandable output
    | otherwise = print (pprint nums numbers nprime)
        where   numbers = map ( (\p -> (fromIntegral p) :: Int) . readNum) nums
                nprime = (\q -> primesList !! (q - 1))

-- arecoprime : checks if two given numbers are coprime
arecoprime :: [String] -> IO ()
arecoprime nums = do
    let mynums = ((map (\p -> read p :: Integer)  nums))
    print (coprime (mynums!!0) (mynums !!1))


dispatch :: [(String, [String] -> IO ())]  
dispatch =  [("-isPrime", (isprime primes))
            ,("-p", (isprime primes))
            ,("-kprime", (isprime kprimes))
            ,("-kp", (isprime kprimes))
            ,("-nthPrime", (nthprime primes))
            ,("-np", (nthprime primes))
            ,("-knthPrime", (nthprime kprimes))
            ,("-knp", (nthprime kprimes))
            ,("-areCoprime", arecoprime)
            ,("-cp", arecoprime)
            ,("-help", help)
            ,("-h", help)]

-- prints the help for different commands, if args is empty, prints the program USAGE
help :: [String] -> IO()
help x 
    | length x <= 0 = do
        file <- readFile "./USAGE.txt"
        putStrLn file
    | otherwise = do
        file <- readFile "./HELP.txt"
        print ( map (fromJust.(\p -> lookup p (cmdHelp' file))) x )

-- reads the HELP.txt and returns a list of tuple with the help content
cmdHelp' :: String -> [(String, String)]
cmdHelp' file = map (\line -> read line :: (String, String)) (lines file)

-- list of the handles and the repective exception
catchIt :: [Handler ()]
catchIt = [Handler (\(err :: PrimeError) -> putStrLn $ "PrimeError: " ++ show err),
           Handler (\(err :: PatternMatchFail) -> putStrLn $ "Parsing Error, option not found, try \"-help\""),
           Handler (\(err :: SomeException) -> putStrLn $ "Unexpected Error !, try \"-help\" for program USAGE\n")]

main :: IO ()
main = do
    (command:args) <- getArgs
    let (Just action) = lookup command dispatch
    (action args) `catches` catchIt
