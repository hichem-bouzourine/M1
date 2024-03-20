module GFunSpec where
import GFun

import Test.Hspec
import Control.Exception (evaluate)

uns = Z 1 uns
deux = Z 2 deux
trois = Z 3 trois
quatre = Z 4 quatre
cinq = Z 5 cinq
moinsUn = Z (-1) moinsUn


-- check take function
prendSpec = do
    describe "Checking take func -->" $ do
        it "returns a list of elements in a serie" $ do
            prend 8 deux `shouldBe` (take 8 (repeat 2))
            
        it "returns an empty list if the number is 0" $ do
            prend 0 deux `shouldBe` []

        it "returns an error if the number is negative" $ do
            evaluate (prend (-1) deux) `shouldThrow` errorCall "on ne peut pas prendre un nombre négatif d'éléments de la série"

fmapSpec = do
    describe "fmapSpec" $ do

        it "applies a function onto the element in a serie" $ do
            fmap (*2) deux `shouldBe` quatre

instanceNumSpec = do
    describe "instanceNumSpec" $ do

        it "supports addition of 2 series" $ do
            deux + deux `shouldBe` quatre

        it "supports substraction of 2 series" $ do
            quatre - deux `shouldBe` deux

        it "supports multiplication of 2 series" $ do
            prend 10 (deux * deux) `shouldBe` (take 10 (iterate (+4) 4))

        it "supports giving the absolute values of serie" $ do
            abs (deux - quatre) `shouldBe` deux

        it "supports giving signum of values of series" $ do
            signum (negate deux) `shouldBe` moinsUn

        it "supports generate a serie from an integer" $ do
            (fromInteger 4 :: Serie Int) `shouldBe` quatre

engineSpec = do
    prendSpec
    fmapSpec
    instanceNumSpec
        

        