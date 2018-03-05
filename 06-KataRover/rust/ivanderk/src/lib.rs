//! # Kata; rover 
//! 
//! ## Implementation
//! The rust solution is provided in the _rover_ module. 
//! _Rover_ is a struct containing a stack of immutable states (CrawlerState)
//! in order to implement a history of commands. The stack  is fixed size 
//! through a VecDeque and controlled adding/removing of elements
//! 
//! ## License
//! 
//! Copyright (c) 2018 by Iwan van der Kleijn. All rights reserved.
//! 
//! This program is MIT licensed. See the file LICENSE.
use std::fmt;
use std::collections::VecDeque;

#[derive(Debug, PartialEq)]
pub enum Orientation {
    North, South, West, East
}
// In order to use the `{}` marker, the trait `fmt::Display` must be implemented
// manually for the type.
impl fmt::Display for Orientation {

    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        match *self {
            Orientation::North => write!(f, "{}", "North"),
            Orientation::East => write!(f, "{}", "East"),
            Orientation::South => write!(f, "{}", "South"),
            Orientation::West => write!(f, "{}", "West"),
        }
    }
}

#[derive(Debug)]
pub struct Rover {
    world: (i32, i32),
    state: VecDeque<CrawlerState>
} 

impl Rover {
    pub fn new() -> Rover {
        let mut vector: VecDeque<CrawlerState> = VecDeque::with_capacity(10);
        vector.push_back((Orientation::North, (0,0)));
        Rover {world: (100,100), state: vector}
    }

    pub fn new_with(state: CrawlerState, world: (i32,i32), capacity: usize) -> Rover {
        let mut vector: VecDeque<CrawlerState> = VecDeque::with_capacity(capacity);
        vector.push_back(state);
        Rover {world: world, state: vector}
    }
    /// Send the following commands to the Rover:
    ///     - 'F' - move forward
    ///     - 'B' - move backward
    ///     - 'R' - turn right
    ///     - 'L' - turn left
    ///     - 'U' - undo last command (apart from 'undo' itself)
    /// All other commands are ignored
    pub fn send_command(&mut self, cmd: char) -> &mut Self {
        match cmd {
            'F'|'f' => {
                // Cannot have immutable AND mutable borrow of self in the same block
                // so a seperate block is created. This trick will no longer be needed 
                // with non-lexical lifetimes 
                let new_state : CrawlerState = {
                    self.get_state().move_forward(self.world)
                };
                self.update_state(new_state); 
            },
            'B'|'b' => {
                let new_state = {
                    self.get_state().move_backward(self.world)
                };
                self.update_state(new_state); 
            },
            'L'|'l' => {
                let new_state = {
                    self.get_state().turn_left(self.world)
                };
                self.update_state(new_state);  
            },
            'R'|'r' => {
                let new_state = {
                    self.get_state().turn_right(self.world)
                };
                self.update_state(new_state);  
            },
            'U'|'u' => {
                
                if self.state.len() > 1 {
                    self.state.pop_back(); 
                }
            },
            _ => {}
        }
        self
    } 
    fn update_state(&mut self, state: CrawlerState){
        if self.state.len() == self.state.capacity() {
            self.state.pop_front();
        }
        self.state.push_back(state);
    }
    /// Get state of the Rover (position & orientation)
    fn get_state(& self) -> &CrawlerState {
        self.state.back().unwrap()
    }    
}

impl fmt::Display for Rover {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        let  (ref orientation, (x, y)) = *self.get_state();

        write!(f, "Rover orientation: {}, pos: ({}, {})", orientation, x, y)
    }
}

pub trait Crawler<W>  {
    fn turn_left(&self, world: W) -> Self;
    fn turn_right(&self, world: W) -> Self;
    fn move_backward(&self, world: W) -> Self;
    fn move_forward(&self, world: W) -> Self;
}

/// state as composition of x, y coordinates and orientation
pub type CrawlerState = (Orientation, (i32, i32));
/// 2 dimensional world without grid state
pub type UniPlain = (i32, i32);
impl Crawler<UniPlain> for CrawlerState {

    fn turn_left(&self, _world: UniPlain) -> CrawlerState{
        match *self {
            (Orientation::North, pos) => (Orientation::West, pos),
            (Orientation::West, pos) => (Orientation::South, pos),
            (Orientation::South, pos) => (Orientation::East, pos),
            (Orientation::East, pos) => (Orientation::North, pos)
        }
    }
    fn turn_right(&self, _world: UniPlain) -> CrawlerState{
        match *self {
            (Orientation::North, pos) => (Orientation::East, pos),
            (Orientation::East, pos) => (Orientation::South, pos),
            (Orientation::South, pos) => (Orientation::West, pos),
            (Orientation::West, pos) => (Orientation::North, pos)
        }
    }
    fn move_backward(&self, (width, height): UniPlain) -> CrawlerState{
       match *self {
            (Orientation::North, (x, y)) => (Orientation::North, adjust_pos(x, y + 1, width, height)),
            (Orientation::East, (x, y)) => (Orientation::East, adjust_pos(x - 1, y, width, height)),
            (Orientation::South, (x, y)) => (Orientation::South, adjust_pos(x, y - 1, width, height)),
            (Orientation::West, (x, y)) => (Orientation::West, adjust_pos(x + 1, y, width, height)),
        }
    }
    fn move_forward(&self, (width, height): UniPlain) -> CrawlerState{
        match *self {
            (Orientation::North, (x, y)) => (Orientation::North, adjust_pos(x, y - 1, width, height)),
            (Orientation::East, (x, y)) => (Orientation::East, adjust_pos(x + 1, y, width, height)),
            (Orientation::South, (x, y)) => (Orientation::South, adjust_pos(x, y + 1, width, height)),
            (Orientation::West, (x, y)) => (Orientation::West, adjust_pos(x - 1, y, width, height)),
        }
    }
}

fn adjust_pos(x:i32, y: i32, width: i32, height: i32 ) -> (i32, i32) {
    let new_x = if x >= width {
        x - width 
    } else if x < 0 {
        width + x
    } else {
        x
    };
    let new_y = if  y >= height {
        y - height 
    } else if y < 0 {
        height + y
    } else {
        y
    };
    (new_x, new_y)
}


#[cfg(test)]
mod test;
