module PrimesLib ( primes, isPrime, kprimes, coprime, gcd , PrimeError) where

import Control.Exception
import Data.Typeable

data PrimeError = NegativeNumberException | MiscError String

instance Show PrimeError where
    show NegativeNumberException = "Prime Numbers is not defined for Negative Numbers"
    show (MiscError str) = "Unexpected " ++ str

instance Exception PrimeError

-- generates a list of prime numbers
primes :: [Integer]
primes = 2 : [ x | x <- [3, 5..], isPrime primes x]

-- checks if a given number is prime, takes the list of primes and the number to be checked for
-- prime as input, returns Bool
isPrime :: [Integer] -> Integer -> Bool
isPrime _ 0 = False
isPrime _ 1 = False
isPrime primesList x
    | x < 0 = throw NegativeNumberException
    | otherwise = all (\p -> x `mod` p > 0) (trialFactors x)
        where
            trialFactors x = takeWhile (\p -> p * p <= x) primesList

-- A relatively simple but still quite fast implementation of list of primes. By Will Ness
-- http://www.haskell.org/pipermail/haskell-cafe/2009-November/068441.html
-- generates a list of primes numbers using an optimized sieves method
kprimes :: [Integer]
kprimes  = 2: 3: sieve 0 primes' 5  where
    primes' = tail kprimes
    sieve k (p:ps) x
        = noDivs k h ++ sieve (k+1) ps (t+2)
        where (h,t) = ([x,x+2..t-2], p*p)
    noDivs k = filter (\x-> all ((/=0).(x`rem`)) (take k primes'))

-- checks if two given numbers are co-prime or not
coprime :: Integral a => a -> a -> Bool
coprime x y = gcd' x y == 1

-- computes the gcd of two given numbers
gcd' :: (Integral a) => a -> a -> a
-- gcd' a 0 = a
-- gcd' a b = gcd' b (a `mod` b)
gcd' x y
    | y == 0 = x
    | otherwise = gcd' y (x `mod` y)