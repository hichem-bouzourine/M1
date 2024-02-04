import Data.List
import System.IO
import GHC.Base (maxInt, minInt)
import Text.XHtml.Transitional (primHtmlChar)
import Data.Void (Void)

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

multTable = [x*y | x <-[1..2], y<-[3..4]]

-- ! Tuples
randTuple = (1, "first tuble")

-- Tuple pairs
bobSmith = ("bob smith", 22)

bobName = fst bobSmith
bobAge = snd bobSmith

-- ! Zip --> combine two arrays by creating pair tuples
cities = ["Paris", "Champs-sur-Marne", "Versailles", "Saint-Denis"]
postalCodes = [75, 77, 78, 93]

citiesAndCodes = zip cities postalCodes

-- ! Functions =====> `do` (to create a bloc of code) 
greetingByName :: IO()
greetingByName = do 
    putStrLn "What's your name ?"
    name <- getLine
    putStrLn ("Hello " ++ name)

addMe :: Integer -> Integer -> Integer
addMe x y = x + y

-- combineTuples :: (String , Int) -> (String , Int) -> (String , Int)
-- combineTuples tuple1 tuple2
--     | not (checkTupleType tuple1) = error "Error"
--     | not (checkTupleType tuple2) = error "Error"
--     | otherwise = (fst tuple1 ++ fst tuple2, snd tuple1, snd tuple2)

-- checkTupleType :: (String, Int) -> Bool
-- checkTupleType (x, y)
--     | typeOf x != String = False
--     | typeOf y != Int = False
--     | otherwise = True
         
addTuple :: (Int, Int) -> (Int, Int) -> (Int, Int)
addTuple (x1,y1) (x2, y2) = (x1+x2, y1+y2)

whatAge :: Int -> String 
whatAge 16 = "You can drive"
whatAge 18 = "You can vote"
whatAge 21 = "You're an adult, pay taxes"
whatAge _ = "Nothing important"

-- ! Recursive functions
factorialFun :: Integer -> Integer
factorialFun 0 = 1
factorialFun x = x * factorialFun (x-1)

-- ! Guard to replace `if`
isOdd :: Integer -> Bool
isOdd x 
    | x`mod`2==1 = True
    | otherwise = False

-- ! using `where`
batAvgRating :: Double -> Double -> String
batAvgRating hits atBats
    | avg <= 0.200 = "Terrible score"
    | avg <= 0.250 = "Average player"
    | otherwise = "jsp"
    where avg = hits / atBats

getListItems :: [Integer] -> String
getListItems [] = "Empty list"
getListItems (x:xs) = "1st element is " ++ show x ++ " rest is " ++ show xs

-- 

getFirstItem :: String -> String
getFirstItem [] = "Empty list"
getFirstItem all@(x:xs) = "First letter of " ++ all ++ " is " ++ show x

-- ! High order functions

times4 :: Integer -> Integer
times4 x = x*4

-- map is used to apply a function on each element of a list
listTimes4 = map times4 [1..5] 

multBy4 :: [Integer] -> [Integer]
multBy4 [] = []
multBy4 (x:xs) = times4 x : multBy4 xs 


areStringsEq :: [Char] -> [Char] -> Bool
areStringsEq [] [] = True
areStringsEq (x:xs) (y:ys) = x==y && areStringsEq xs ys
areStringsEq _ _ = False

-- ! Pass a function to another function

doMult :: (Integer -> Integer) -> Integer
doMult func = func 3

-- ! Lambda function
-- prefix it with `\`
dbl1To10 a = map (\x ->x*10) a   -- ! receive `x` return `x*10`

-- if operator
doubleEvenNumber :: Integer -> Integer
doubleEvenNumber y = 
    if y`mod`2 == 0 then 
        y*2
    else y

doubleEvenNumbers :: [Integer] -> [Integer]
doubleEvenNumbers [] = []
doubleEvenNumbers (x:xs) = do
    doubleEvenNumber x : doubleEvenNumbers xs

-- ! Case

getClass ::Integer -> String
getClass n = case n of
    5 -> "Go to Kingergarten"
    6 -> "Go to elementary school"
    _ -> "Go away"

main :: IO ()
main = do
    -- iterateOverList (doubleEvenNumbers [1..10])
    -- print(head citiesAndCodes)
    -- greetingByName
    print (getClass 8)
    