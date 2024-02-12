
-- adrliv numvoie, nomvoie, digicode
data AdresseLivraison = AdresseLivraison {
    numVoie :: Integer,
    nomVoie :: String,
    digicode :: Maybe String
} deriving (Show)

adresseLivraison1 = AdresseLivraison 21 "nomnomnom" (Just "0022")

safeDevision :: Integer -> Integer -> Either String Integer
safeDevision _ 0 = Left "Error, div sur 0"
safeDevision n m = Right (n`div`m)

longueurList :: [a] -> Integer
longueurList [] = error "liste vide"
longueurList (x:xs) = (longueurList xs) + 1

main :: IO()
main = do 
    print(longueurList [])