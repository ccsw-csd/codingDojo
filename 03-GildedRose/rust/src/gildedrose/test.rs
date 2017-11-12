use super::{Item, GildedRose, AGED_BRIE, MAGIC_HAND, BACKSTAGE_PASSES};

static DEXTERITY_VEST: &'static str = "+5 Dexterity Vest";

fn test_item(item_name: String, initial_sell_in: i32, initial_quality: i32, new_sell_in: i32, new_quality: i32) {
 
    let items = vec![Item::new(item_name, initial_sell_in, initial_quality)];
    let mut rose = GildedRose::new(items);
    
    rose.update_quality();
  
    println!("new_sell_in: {} rose.items[0].sell_in: {}", new_sell_in, rose.items[0].sell_in );
    assert_eq!(new_sell_in, rose.items[0].sell_in);

    println!("new_quality: {} rose.items[0].quality: {}",new_quality, rose.items[0].quality );
    assert_eq!(new_quality, rose.items[0].quality);
  }

#[test]
pub fn test_generic_items() {
    
    //At the end of the day both sell_in and quality decrement
    test_item(String::from(DEXTERITY_VEST), 10, 20, 9,19);

    //if sell_in < 0, quality degrades with double the velocity
    test_item(String::from(DEXTERITY_VEST), 0, 4, -1, 2);
    
    //the quality of an item can never be < 0 nor > 50
    test_item(String::from(DEXTERITY_VEST), 0, 1, -1, 0);
    //TODO check > 50 ILLEGAL state

}

#[test]
pub fn test_brie() {
    
    //At the end of the day Brie increcements quality
    test_item(String::from(AGED_BRIE), 2, 1, 1, 2);
    //Once sell_in < 0; cuality increment 2 units
    test_item(String::from(AGED_BRIE), 0, 4, -1, 6);
    //the quality of an item can never be > 50
    test_item(String::from(AGED_BRIE), 0, 50, -1, 50);
 
}

#[test]
pub fn test_magic_hand() {
    
    //being a magic article, neither sell_in nor quality changes
    test_item(String::from(MAGIC_HAND), 10, 40, 10, 40);
  
}

#[test]
pub fn test_backstage_passes() {
    
     //At the end of the day Backstage passes increcements quality for the general case
    test_item(String::from(BACKSTAGE_PASSES), 40, 10, 39, 11);
    //the quality of an item can never be > 50
    test_item(String::from(BACKSTAGE_PASSES), 40, 50, 39, 50);
    //if there are 10 days or less left, the quality increases by 2 units
    test_item(String::from(BACKSTAGE_PASSES), 10, 10, 9, 12);
    //and if there are 5 days or less left, the quality increases by 3 units
    test_item(String::from(BACKSTAGE_PASSES), 5, 10, 4, 13);
    //and if there are no day less, the quality drops to 0
    test_item(String::from(BACKSTAGE_PASSES), 0, 10, -1, 0);
    
}


