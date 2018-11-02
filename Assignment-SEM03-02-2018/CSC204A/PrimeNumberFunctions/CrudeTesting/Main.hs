{-# LANGUAGE FlexibleContexts #-}
{-# LANGUAGE OverloadedStrings #-}

import qualified Data.List as List
import Data.Bits
import Data.List
import Data.Array.Base
import Control.Monad.ST
import Data.Array.ST (runSTUArray, STUArray(..))
import Data.Int
import Data.Word
import Control.Exception
import System.CPUTime
import Text.Printf
import Control.Exception
import System.TimeIt

import Control.Exception
import Data.Typeable


-- gives the 10000th prime in 1.96 secs and takes 4,384,198,984 bytes
primes :: [Int]
primes = 2:[ x | x <- [3..], isPrime x]

isPrime :: Int -> Bool
isPrime x = all (\p -> x `mod` p > 0) (takeWhile (\p -> p <= floor (sqrt( read (show x) :: Float ))) primes)

-- gives the 10000th prime in 30.39 secs and takes 17,743,197,760 bytes
primes' :: [Int]
primes' = filterPrime [2..] 
  where filterPrime (p:xs) = 
          p : filterPrime [x | x <- xs, x `mod` p /= 0]


-- primes pages, gives the 10000th prime in 0.04 secs and takes 14,692,768 bytes
type PrimeType = Word64
szPGBTS = (2^15) * 8 :: PrimeType -- CPU L1 cache in bits
 
primes'' :: [PrimeType]
primes'' = 2 : _Y (listPagePrms . pagesFrom 0) where
  _Y g = g (_Y g)        -- non-sharing multi-stage fixpoint combinator
  listPagePrms (hdpg @ (UArray lowi _ rng _) : tlpgs) =
    let loop i = if i >= rng then listPagePrms tlpgs
                 else if unsafeAt hdpg i then loop (i + 1)
                      else let ii = lowi + fromIntegral i in
                           case 3 + ii + ii of
                             p -> p `seq` p : loop (i + 1) in loop 0
  makePg lowi bps = runSTUArray $ do
    let limi = lowi + szPGBTS - 1
    let nxt = 3 + limi + limi -- last candidate in range
    cmpsts <- newArray (lowi, limi) False
    let pbts = fromIntegral szPGBTS    
    let cull (p:ps) =
          let sqr = p * p in
          if sqr > nxt then return cmpsts
          else let pi = fromIntegral p in
               let cullp c = if c > pbts then return ()
                             else do
                               unsafeWrite cmpsts c True
                               cullp (c + pi) in
               let a = (sqr - 3) `shiftR` 1 in
               let s = if a >= lowi then fromIntegral (a - lowi)
                       else let r = fromIntegral ((lowi - a) `rem` p) in
                            if r == 0 then 0 else pi - r in
               do { cullp s; cull ps}
    if lowi == 0 then do
      pg0 <- unsafeFreezeSTUArray cmpsts
      cull $ listPagePrms [pg0]
    else cull bps
  pagesFrom lowi bps =
    let cf lwi = case makePg lwi bps of
          pg -> pg `seq` pg : cf (lwi + szPGBTS) in cf lowi

primes''' :: [Int]
primes''' = sieve (2:[3, 5..])
  where sieve (p:xs) = p : sieve [ x | x <- xs, x `mod` p > 0]

main :: IO()
main = do
  putStrLn "Computing the 1,000,000,000th Prime"
  print $ primes'' !! 999999999

-- *Main> primes' !! 9999
-- 104729
-- (29.07 secs, 18,550,074,512 bytes)
-- *Main> primes !! 9999
-- 104729
-- (2.07 secs, 4,568,180,832 bytes)
-- *Main> primes'' !! 9999
-- 104729
-- (0.34 secs, 146,886,720 bytes)
-- *Main> primes'' !! 99999
-- 1299709
-- (1.18 secs, 571,025,904 bytes)
-- *Main> primes'' !! 999999
-- 15485863
-- (12.43 secs, 5,884,667,608 bytes)
-- *Main> primes'' !! 9999999
-- 179424673
-- (153.90 secs, 71,401,332,800 bytes)

-- PS D:\Assignment-SEM03-02-2018\CSC204A\PrimeNumberFunctions\CrudeTesting> ghc -O2 -threaded --make Main.hs
-- [1 of 1] Compiling Main             ( Main.hs, Main.o )
-- Linking Main.exe ...
-- PS D:\Assignment-SEM03-02-2018\CSC204A\PrimeNumberFunctions\CrudeTesting> .\Main.exe +RTS -N6
coprime :: Integral a => a -> a -> Bool
coprime x y = gcd' x y == 1

gcd' :: (Integral a) => a -> a -> a
gcd' a 0 = a
gcd' a b = gcd' b (a `mod` b)

kprimes  = 2: 3: sieve 0 primes' 5  where
  primes' = tail kprimes
  sieve k (p:ps) x
           = noDivs k h ++ sieve (k+1) ps (t+2)
             where (h,t)=([x,x+2..t-2], p*p)
  noDivs k = filter (\x-> all ((/=0).(x`rem`)) (take k primes'))

primes1   = 2: 3: sieve 0 primes1' 5
primes1'  = tail primes1
sieve k (p:ps) x
         = [x | x<-[x,x+2..p*p-2], and [(x`rem`p)/=0 | p<-take k primes1']]
           ++ sieve (k+1) ps (p*p+2)

split :: String -> [String]
split [] = [""]
split (c:cs) | c == ','  = "" : "," : rest
             | otherwise = (c : head rest) : tail rest
    where rest = split cs

cmdHelp = do
  file <- readFile "./HELP.txt"
  -- print $ (map (\line -> read line :: (String, String)) (lines file))
  print $ cmdHelp' file

cmdHelp' file = map (\line -> read line :: (String, String)) (lines file)

isPrime'' :: Integral a => a -> Bool
isPrime'' x
  | x < 0 = error "Negative number found !"
  | otherwise = all (\p -> x `mod` p > 0 ) [2.. (x-1)]

-- data PrimeError = NegativeNumber | MiscError String
data PrimeError = NegativeNumber | MiscError String

instance Show PrimeError where
    show NegativeNumber = "Prime Numbers is not defined for Negative Numbers"
    show (MiscError str) = str

instance Exception PrimeError

data MyException = ThisException | ThatException
    deriving Show

instance Exception MyException