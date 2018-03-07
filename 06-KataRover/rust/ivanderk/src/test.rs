use super::{Crawler, Orientation, Rover};

#[test]
pub fn test_rover_movements(){

    let world = (100,100);
    let crawler_1 = (Orientation::North, (0,0));
    let crawler_2 = crawler_1.turn_right(world);
    assert_eq!(crawler_2, (Orientation::East, (0,0)));

    let crawler_3 = crawler_2.move_forward(world);
    assert_eq!(crawler_3, (Orientation::East, (1,0)));

    let crawler_4 = crawler_3.turn_right(world)
                             .move_forward(world)
                             .move_forward(world);
    assert_eq!(crawler_4, (Orientation::South, (1,2)));

    let crawler_5 = crawler_4.turn_left(world)
                             .move_forward(world)
                             .move_forward(world) 
                             .move_forward(world);
    assert_eq!(crawler_5, (Orientation::East, (4,2)));

    let crawler_6 = crawler_5.turn_left(world)
                             .move_backward(world)
                             .move_backward(world);
    assert_eq!(crawler_6, (Orientation::North, (4,4)));
}

#[test]
pub fn test_world_bounds(){
    let world = (100,100);
    
    let crawler_1 = (Orientation::North, (1,0)).move_forward(world);
    assert_eq!(crawler_1, (Orientation::North, (1,99)));
    
    let crawler_2 = (Orientation::East, (99,3)).move_forward(world);
    assert_eq!(crawler_2, (Orientation::East, (0,3)));
    
    let crawler_3 = (Orientation::South, (1,99)).move_forward(world);
    assert_eq!(crawler_3, (Orientation::South, (1,0)));
    
    let crawler_4 = (Orientation::West, (0,3)).move_forward(world);
    assert_eq!(crawler_4, (Orientation::West, (99,3)));

}

#[test]
pub fn test_rover(){
    let mut rover = Rover::new();

    rover.send_command('R')
        .send_command('F');
    assert_eq!(rover.get_state(), &(Orientation::East, (1,0)));

    rover.send_command('L')
        .send_command('F');
    assert_eq!(rover.get_state(), &(Orientation::North, (1,99)));
    
    rover.send_command('U')
        .send_command('U');

    assert_eq!(rover.get_state(), &(Orientation::East, (1,0)));

    rover.send_command('U')
        .send_command('U')
        .send_command('U');

    assert_eq!(rover.get_state(), &(Orientation::North, (0,0)));
}

#[test]
pub fn test_rover_limited_history(){
    let world = (0,0);
    let mut rover = Rover::new_with((Orientation::North, (0,0)), world, 2);
    rover.send_command('R')
        .send_command('F')
        .send_command('F')
        .send_command('F')
        .send_command('F')
        .send_command('F')
        .send_command('U')
        .send_command('U')
        .send_command('U')
        .send_command('U');

    assert_eq!(rover.get_state(), &(Orientation::East, (3,0)));
}
