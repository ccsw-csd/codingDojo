module Lib where


import Types
import Builder

find :: FinderCriteria -> [Person] -> Maybe PersonCouple
find _ [] = Nothing
find _ [x] = Nothing
find criteria people = case criteria of
                        Furthest -> Just $ foldl1 max peopleCombination
                        Nearest -> Just $ foldl1 min peopleCombination
   where peopleCombination = createCouples people