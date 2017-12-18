//! # Simple run-time wrapper for the romannumber module 
//!
//! ## Details of the implementation of Kata: Roman Numerals
//!
//! The rust solution is provided in the _romannumerals_ module. Main characteristics of this implementation are:
//!
//! - Central to the implementation is the NUMERALS array which is used as a lookup buffer for both the 
//!  _number_value_ function ("Roman Numerals to integer") and the _number_presentation_ function ("integer to Roman Numeral").
//!
//! - Both functions come with basic error handling. The functions "_number_presentation_" and
//!  "_number_value_" return Option type data. They return None in case of invalid data. Parsing of Roman Numbers is strict.
//! 
//! - Number range of supported Roman Numerals is [1 .. 3999].
//! 
//! - RomanNumberValue and RomanNumberPresentation Traits showcase how existing types can be extended with the 
//!  functionality implemented by "_number_presentation_" and "_number_value_" respectively. String types gain a 
//!  "_roman_number_value_" method and u32 integers an "_as_roman_number_" method.
//!
//! - Shown in the tests but not used in the Traits, the modules contains the function "_number_value2_", an 
//!  alternative recursive, immutable implementation. This to compare with the compact but mutable iterative 
//!  default function "_number_value_".

/// Provides a type with the capability to generate a String representation 
/// of the number in Roman Numerals
pub trait RomanNumberPresentation  {
    fn as_roman_number(&self) -> Option<String>;
}

/// Provides a type with the capability to obtain an integer value
/// represented by a String representation of a Roman Numeral
pub trait RomanNumberValue {
    fn roman_number_value(&self) -> Option<u32>;
}

impl RomanNumberPresentation for u32 {

    fn as_roman_number(&self) -> Option<String> {
        
        number_presentation(*self)
    }
}

impl RomanNumberValue for str {
    fn roman_number_value(&self) -> Option<u32> {
        number_value(self)
    }
} 

/// Node in lookup buffer containing all possible Roman Numerals with 
/// their corresponding numeric value
struct RomanNumeral {
    symbol: &'static str,
    value: u32
}

/// Lookup buffer to search for (scan forward) Roman Numerals with their
/// corresponding value. Note that the order in the buffer must accoint for 
/// search order: i.e. 'CM' must be before 'C' in order to parse the correct
/// numeral
const NUMERALS: [RomanNumeral; 13] = [
    //latin uppercase characters
    RomanNumeral {symbol: "M",  value: 1000},
    RomanNumeral {symbol: "CM", value: 900},
    RomanNumeral {symbol: "D",  value: 500},
    RomanNumeral {symbol: "CD", value: 400},
    RomanNumeral {symbol: "C",  value: 100},
    RomanNumeral {symbol: "XC", value: 90},
    RomanNumeral {symbol: "L",  value: 50},
    RomanNumeral {symbol: "XL", value: 40},
    RomanNumeral {symbol: "X",  value: 10},
    RomanNumeral {symbol: "IX", value: 9},
    RomanNumeral {symbol: "V",  value: 5},
    RomanNumeral {symbol: "IV", value: 4},
    RomanNumeral {symbol: "I",  value: 1}];

/// Convert a number from [1..3999] to its string representation
/// in Roman Numerals
pub fn number_presentation(mut number: u32) -> Option<String> {
    if number == 0 || number > 3999 {
        return None
    }
    let mut min_numeral = String::new();
    for numeral in NUMERALS.iter() {
        while numeral.value <= number {
            min_numeral = min_numeral + numeral.symbol;
            number -= numeral.value;
        }
    }
    Some(min_numeral)
}

/// Give the integer value of a string representation of 
/// a number in Roman Numerals
pub fn number_value(roman: &str) -> Option<u32> {
    
    let mut result = 0;
    let mut data = roman;
    
    while data.len() > 0  {
        result += match NUMERALS.iter().find(|num| data.starts_with(num.symbol)) {
            Some(num) => {
                            data = &data[num.symbol.len()..];
                            num.value
            } 
            None => return None
        };
    }
    
    verify_number(roman, result)
}

/// verify if the reported integer value
/// of a roman number is correct. 
fn verify_number(roman: &str, val: u32) -> Option<u32>{
    match number_presentation(val){
        Some(s) => if *s == *roman {
            Some(val)
        } else {
            None
        },
        _ => None
    }
}

//////////////////////////////////////////////////////////////////////////////////////
#[allow(dead_code)]
/// Give the integer value of a string representation of 
/// a number in Roman Numerals - alternative recursive implemenation 
pub fn number_value2(roman: &str) -> Option<u32> {
    number_value_intern(roman, 0, roman)
}

fn number_value_intern(roman: &str, acc: u32, original: &str) -> Option<u32> {
    if roman.len() > 0 {
        match NUMERALS.iter().find(|num| roman.starts_with(num.symbol)) {
            Some(num) => number_value_intern(&roman[num.symbol.len()..], num.value + acc, original),
            None => None
        }
    } else {
       
        verify_number(original, acc)
    }
}

#[cfg(test)]
mod test;
