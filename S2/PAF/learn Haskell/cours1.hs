import Data.Data (typeOf)

et :: Bool -> Bool -> Bool
et True True = True
et _ _ = False

si :: Bool -> a -> a -> a
si True sithen _ = sithen
si False _ sielse = sielse

-- count number of repetition of an element in a list using "Foldr"
cc e [a] = foldr (\x acc -> if x==e then acc+1 else acc) 0 [a]

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
main :: IO()
main = do
    -- print (printingMoyPaiement $ Carte "Hichem" "Bouzourine")
    -- print (setNewLogin hichem "hi")
    print (getNameAge hichem)