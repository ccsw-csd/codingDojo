module LibSpec where

import Lib
import Builder
import Data.List
import Data.Maybe
import Data.Time.Calendar
import Test.Hspec
import Types

spec :: Spec
spec = do
  describe "createCouples" $ do
    
    it "Should create 0 couple when no person is given" $ do
      let couples = createCouples []
      length (couples) `shouldBe` 0

    it "Should create 0 couple when 1 person is given" $ do
      let couples = createCouples $ take 1 createMockPeople
      length (couples) `shouldBe` 0
      
    it "Should create 1 couple" $ do
      let couples = createCouples $ take 2 createMockPeople
      length (couples) `shouldBe` 1

    it "Should create 3 couples" $ do
      let couples = createCouples createMockPeople
      length (couples) `shouldBe` 3

  describe "finder" $ do

    it "Should return Nothing when empty list is given" $ do
      isNothing (Lib.find Furthest []) `shouldBe` True

    it "Should return Nothing when one element list is given" $ do
      isNothing (Lib.find Furthest $ take 1 createMockPeople) `shouldBe` True

    it "Should return Greg and Jack couple when Furthest is applied" $ do
      let couple = fromJust $ Lib.find Furthest createMockPeople
      (name (firstPerson couple)) `shouldBe` "Greg"
      (name (secondPerson couple)) `shouldBe` "Jack"
      (birthDateDiff couple) `shouldBe` 700

    it "Should return Greg and Sue couple when Nearest is applied" $ do
      let couple = fromJust $ Lib.find Nearest createMockPeople      
      (name (firstPerson couple)) `shouldBe` "Greg"
      (name (secondPerson couple)) `shouldBe` "Sue"
      (birthDateDiff couple) `shouldBe` 335



createMockPeople :: [Person]
createMockPeople = [Person "Greg" $ fromGregorian 2016 10 12, Person "Sue" $ fromGregorian 2015 11 12, Person "Jack" $ fromGregorian 2014 11 12]

