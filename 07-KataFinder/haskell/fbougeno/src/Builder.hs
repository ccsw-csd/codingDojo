module Builder (createCouples) where

import Data.Maybe (catMaybes)
import Data.Time.Calendar
import Types

createCouples :: [Person] -> [PersonCouple]
createCouples people = catMaybes $ map buildCoupleFromArray peopleCombination 
      where peopleCombination = [x| x <- mapM (const people) [1..2], head x < head (tail x) ]

buildCoupleFromArray :: [Person] -> Maybe PersonCouple
buildCoupleFromArray (x:y:[]) = Just $ buildCouple x y
buildCoupleFromArray _ = Nothing
          
buildCouple :: Person -> Person -> PersonCouple
buildCouple p1 p2 = case (p2 `compare` p1) of
                        LT -> PersonCouple p1 p2 (birthDateDiff p1 p2)
                        EQ -> PersonCouple p1 p2 0
                        GT -> PersonCouple p2 p1 (birthDateDiff p2 p1)
    where birthDateDiff :: Person -> Person -> Integer
          birthDateDiff x y = diffDays (birthDate x) (birthDate y)