import Data.Data (typeOf)
import Data.Map (Map)
import qualified Data.Map as Map

et :: Bool -> Bool -> Bool
et True True = True
et _ _ = False

si :: Bool -> a -> a -> a
si True sithen _ = sithen
si False _ sielse = sielse

-- count number of repetition of an element in a list using "Foldr"
-- cc e [a] = foldr (\x acc -> if x==e then acc+1 else acc) 0 [a]

data MoyenPaiement =
     Cheque Integer
    | Carte String String
    | Espece
    deriving(Eq, Show)

printingMoyPaiement :: MoyenPaiement -> Either String Integer
printingMoyPaiement mp =  case mp of 
    (Cheque x) -> Right x
    (Carte nom prenom) -> Left $ "carte de " <> nom <> " " <> prenom
    Espece -> Left "Espece"

type Name = String 
type Age = Integer

data PersonalInfo = PersonalInfo {
    firstName, middleName, lastName :: Name,
    age :: Age,
    login :: String, 
    birthYear :: Integer
} deriving (Show)

hichem = PersonalInfo "Hichem" "" "BOUZOURINE" 21 "Hichem" 2002
-- !Getter
getLastName :: PersonalInfo -> Name
getLastName (PersonalInfo _ _ ln _ _ _ ) = ln
-- or using (lastName hichem)

-- ! Setter
setNewLogin :: PersonalInfo -> String -> PersonalInfo
setNewLogin pers newLogin = pers {login=newLogin}
    -- print (setNewLogin hichem "hi")

getNameAge :: PersonalInfo -> (Name, Age)
getNameAge PersonalInfo {lastName=n, age=a} = (n,a)

data Coord  = C Integer Integer deriving(Show, Eq)
data Case = CaseVide | Metal | Terre | Entree | Sortie

data Niveau = Niveau { 
    hNiveau :: Int ,
    lNiveau :: Int ,
    casesNiveau :: Map (Int, Int) Case
} 

niveau = Niveau {
    hNiveau = 2,
    lNiveau = 4,
    casesNiveau = Map.fromList [((2,0), Metal), ((2,1), Entree), ((2,3), Terre), ((2,4), Metal)]
}


main :: IO()
main = do
    -- print (printingMoyPaiement $ Carte "Hichem" "Bouzourine")
    -- print (setNewLogin hichem "hi")
    -- print (getNameAge hichem)
    print (Map.keys (casesNiveau niveau) !! 0)