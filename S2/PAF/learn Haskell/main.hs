import Data.List
import System.IO
import GHC.Base (maxInt, minInt)
import Text.XHtml.Transitional (primHtmlChar)

-- Your other functions or definitions go here

bigFloat = 3.999999999+0.000005
-- Bool: True False
-- Char '
-- Tuple

always5 :: Int
always5 = 5

num9 = 9 :: Int

sumOfNums = sum [1..3]

addExample = 5 + 8
modExample =  8`mod`3

modFun :: Int -> Int -> Int
modFun n x = 
    n `mod` x

sqrtOf :: Float
sqrtOf = sqrt (fromIntegral 16)

calcMoy :: Float -> Float -> Float -> Float -> Float -> Float
calcMoy pscr algav dlp il ouv
    | pscr < 0 = error "Moy d'un module est < 0"
    | algav < 0 = error "Moy d'un module est < 0"
    | dlp < 0 = error "Moy d'un module est < 0"
    | il < 0 = error "Moy d'un module est < 0"
    | ouv < 0 = error "Moy d'un module est < 0"
    | otherwise = (pscr + algav + dlp + il + ouv)/5
    
--- lists 

primeNumbers = [3,5,7,11]

iterateOverList :: Show a => [a] -> IO ()
iterateOverList [] = return ()
iterateOverList (x:xs) = do
    putStrLn $ "Element: " ++ show x
    iterateOverList xs


-- concat lists 
morePrime = primeNumbers ++ [13, 17, 19, 23, 29]

-- multilist 
multilist = [[1,2,3], [4,5,6]]

newList = 100 : primeNumbers

isEmptyList :: [a] -> Bool
isEmptyList [] = True
isEmptyList _ = False

-- find a number in list
numberInList :: [Integer] -> Integer -> Bool
numberInList [] n = False
numberInList (x:xs) n 
    | x==n = True
    | otherwise = numberInList xs n

-- or using `elem`
is7InList = 7 `elem` primeNumbers

productOfListItems = product primeNumbers -- should give 1155

-- create side by side list
sideList = [1..5]
times2List = [x*2 | x <- sideList]

divideBy9Mod17 = [x | x <- [1..254], x `mod` 17 == 0]

sortedList = sort [5,2,8,3,1,2,8,1,2,68,1,489,4,12,4,2,3,54,462,34]

-- ! filters 
listBiggerThan5 = filter (>5) sortedList

-- ! foldl : apply an operation on each item of a list (from left to right)

multOfList = foldr (*) 11 [2, 3, 4, 5]

-- ! list comprehension
power3List = [3^n | n <- [1..10]]



main :: IO ()
main = do
    iterateOverList power3List
    -- print(multOfList)