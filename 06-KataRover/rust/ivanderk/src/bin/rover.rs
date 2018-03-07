extern crate rover;
use std::io;
use std::io::prelude::*;
use std::process;

pub fn main(){

    let mut _rover = rover::Rover::new();
    let stdin = io::stdin();

    println!(r#"Kata rover. Send the following commands by typing characters and then <RETURN>: 
    
  'F' - move forward
  'B' - move backward
  'R' - turn right
  'L' - turn left
  'U' - undo last command (apart from 'undo' itself)
  'Q' - quit

Starting: {}"#, _rover);

    for res in stdin.lock().lines() {
        match res {
            Ok(line) => {
                for char in line.chars() {
                    if char == 'q' || char == 'Q' {
                        print!("Exit!");                
                        process::exit(0);
                    }
                    _rover.send_command(char);
                }
            },
            _ => {}
        }
        println!("Current: {}", _rover);    
        print!("More commands: ")
    }
}
