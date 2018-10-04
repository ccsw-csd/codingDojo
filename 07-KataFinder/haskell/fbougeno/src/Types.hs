module Types where

import Data.Time.Calendar

data FinderCriteria = Furthest | Nearest

data Person = Person { name :: String
                     , birthDate :: Day
                     } deriving (Eq, Show)

instance Ord Person where
    (Person _ b1) `compare` (Person _ b2) = b1 `compare` b2
    
data PersonCouple = PersonCouple { firstPerson :: Person
                                 , secondPerson :: Person
                                 , birthDateDiff :: Integer
                                 } deriving (Eq, Show)

instance Ord PersonCouple where
    (PersonCouple _ _ bd1) `compare` (PersonCouple _ _ bd2) = bd1 `compare` bd2