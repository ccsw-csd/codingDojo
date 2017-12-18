use super::{RomanNumberPresentation, RomanNumberValue, number_presentation, number_value, number_value2};

#[test]
pub fn test_number_presentation(){

    assert_eq!(number_presentation(1).unwrap(), "I");
    assert_eq!(number_presentation(2).unwrap(), "II");
   
    assert_eq!(number_presentation(4).unwrap(), "IV");
    assert_eq!(number_presentation(5).unwrap(), "V");
    assert_eq!(number_presentation(6).unwrap(), "VI");
   
    assert_eq!(number_presentation(100).unwrap(), "C");
    assert_eq!(number_presentation(900).unwrap(), "CM");

    assert_eq!(number_presentation(1990).unwrap(), "MCMXC");
    assert_eq!(number_presentation(2018).unwrap(), "MMXVIII");

}

#[test]
pub fn test_to_value_from_latin(){
    assert_eq!(number_value("I").unwrap(), 1);
    assert_eq!(number_value("II").unwrap(), 2);

    assert_eq!(number_value("IV").unwrap(), 4);
    assert_eq!(number_value("V").unwrap(), 5);
    assert_eq!(number_value("VI").unwrap(), 6);
    
    assert_eq!(number_value("C").unwrap(), 100);
    assert_eq!(number_value("CM").unwrap(), 900);
    
    assert_eq!(number_value("MCMXC").unwrap(), 1990);
    assert_eq!(number_value("MMXVIII").unwrap(), 2018);
    
    //conventional max value to be able to  express in Roman Numerals
    //using the strict rules
    assert_eq!(number_value("MMMCMXCIX").unwrap(),3999);
}

#[test]
pub fn test_to_value_from_unicode(){
    assert_eq!(number_value("Ⅰ").unwrap(), 1);
    assert_eq!(number_value("Ⅱ").unwrap(), 2);

    assert_eq!(number_value("Ⅳ").unwrap(), 4);
    assert_eq!(number_value("Ⅴ").unwrap(), 5);
    assert_eq!(number_value("Ⅵ").unwrap(), 6);
    
    assert_eq!(number_value("Ⅽ").unwrap(), 100);
    assert_eq!(number_value("ⅭⅯ").unwrap(), 900);
    
    assert_eq!(number_value("ⅯⅭⅯⅩⅭ").unwrap(), 1990);
    assert_eq!(number_value("ⅯⅯⅩⅧ").unwrap(), 2018);

    //conventional max value to be able to  express in Roman Numerals
    //using the strict rules
    assert_eq!(number_value("ⅯⅯⅯⅭⅯⅩⅭⅨ").unwrap(),3999);
}

#[test]
pub fn test_to_value_recursive_vs_iterative(){
    
    assert_eq!(number_value("X").unwrap(), number_value2("X").unwrap());
    assert_eq!(number_value("MMXVIII").unwrap(), number_value2("MMXVIII").unwrap());
}

#[test]
pub fn test_trait(){
    assert_eq!(2018.as_roman_number().unwrap(),"MMXVIII");
    assert_eq!("MMXVIII".roman_number_value().unwrap(),2018);
 }

#[test]
pub fn test_illegal_values(){

    // "0" cannot be expressed as a Roman Numeral
    assert_eq!(number_presentation(0), None);
    // 3999 is the max value to be able to  express in Roman Numerals
    //using the strict rules
    assert_eq!(number_presentation(4000), None);
    assert_eq!(number_value("IV-rotten-IV"), None);

    //The composition rules for Roman Numerals are strict are can easily
    // be written wrong 
    assert_eq!(number_value("XXXXIX"), None);
    assert_eq!(number_value("IIIIIL"), None);
}