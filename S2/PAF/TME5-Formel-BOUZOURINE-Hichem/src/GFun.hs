module GFun where

data Serie a = Z a (Serie a)

uns :: Serie Integer 
uns = Z 1 uns

prend :: Integer -> Serie a -> [a]
prend 0 _ = []
prend x (Z a reste) 
    | x > 0 = a : prend (x-1) reste
    | otherwise = error "on ne peut pas prendre un nombre négatif d'éléments de la série"


showSerie :: (Show a) => Serie a -> String
showSerie s = foldl (\str elem -> 
                        if fst elem < 10 then 
                            str ++ show (snd elem) ++ ".z^" ++ show (fst elem) ++ " + " 
                        else str ++ "...") 
                    "" 
                    (zip [0..8] (prend 8 s))


instance (Show a) => Show (Serie a) where
    show = showSerie

gmap :: (a -> b) -> Serie a -> Serie b
gmap f (Z a rest) = Z (f a) (gmap f rest)

instance Functor Serie where
    fmap = gmap

instance (Num a) => Num (Serie a) where -- le code de "Num" est inspiré d'un collègue
    (Z c1 s1) * (Z c2 s2) = Z (c1 * c2) (gmap (*c1) s2 + gmap (*c2) s1 + Z 0 (s1 * s2))
    abs (Z c1 s1) = Z (abs c1) (abs s1)
    fromInteger i = Z (fromInteger i) (fromInteger i)
    signum (Z c1 s1) = Z (signum c1) (signum s1)
    (Z c1 s1) - (Z c2 s2) = Z (c1 - c2) (s1 - s2)
    (Z c1 s1) + (Z c2 s2) = Z (c1 + c2) (s1 + s2)

instance (Eq a) => Eq (Serie a) where
  (Z c1 s1) == (Z c2 s2) = c1 == c2


derive :: Num a => Serie a -> Serie a
derive (Z a rest) = aux (Z a rest) 1 where
    aux (Z c s) counter = Z (c * counter) (aux s (counter + 1))
