extern crate romannumerals;
use romannumerals::{RomanNumberPresentation, RomanNumberValue};
use std::env;
use std::vec::Vec;

fn main() {

    let args : Vec<String>= env::args_os().map(| a | 
        match a.into_string() {
            Ok(s) => s,
            _ => String::from("")
        }).collect();

    if args.len() == 3  {
        match args[1].as_str() { 
            "-r"  => print_value(args[2].as_str()),
            "-d"  => print_numerals(args[2].as_str()),
            _ => error("invalid parameter")
        }
    } else {
        print_usage();
    }
}

fn print_numerals(val: &str){
    match u32::from_str_radix(val, 10){
        Ok(n) => match n.as_roman_number(){
                    Some(s) => print!("{}", s),
                    _ => error("Not convertible to Roman number")
        },
        _ => error("Not a valid number")
    }
}

fn print_value(roman : & str){
    match roman.roman_number_value() {
        Some(v) => print!("{}", v),
        _ => error("Not convertible to integer")
    }
}

fn error(msg: &str){
    println!("{}\n", msg); 
}

fn print_usage(){

    copyright();
    println!(r##"
    -r(oman)    <roman numeral>   ->  prints decimal value");
    -d(decimal) <decimal number>  ->  prints roman representation");
"##);
}

fn copyright(){    
    println!("romannumerals\nCopyright (c) {} ({})", 2018.as_roman_number().unwrap(),  "MMXVIII".roman_number_value().unwrap());
}    
