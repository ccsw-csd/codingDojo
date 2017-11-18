use std::string;
use std::vec;

const AGED_BRIE: &'static str = "Aged Brie";
const MAGIC_HAND: &'static str = "Sulfuras, Hand of Ragnaros";
const BACKSTAGE_PASSES: &'static str = "Backstage passes to a TAFKAL80ETC concert";
const CONJURED: &'static str = "Conjured";

const  QUALITY_UNIT: i32 = 1;
const  MAX_QUALITY: i32 = 50;
const  MIN_QUALITY: i32 = 0;
const  MIN_SELL_IN: i32 = 0;

pub struct Item {
    pub name: string::String,
    pub sell_in: i32,
    pub quality: i32
}

impl Item {
    pub fn new(name: String, sell_in: i32, quality: i32) -> Item {
        Item {name: name, sell_in: sell_in, quality: quality}
    }
}

pub struct GildedRose {
    pub items: vec::Vec<Item>
}

fn dec_sell_in(item: &mut Item){
    item.sell_in =  item.sell_in - 1; 
}

fn update_quality(quality: i32, item: &mut Item){

    if quality < MIN_QUALITY {
        item.quality = MIN_QUALITY;
    }  else if quality > MAX_QUALITY {
        item.quality = MAX_QUALITY;
    }
   else {
        item.quality = quality;
    } 
}

fn backstage_passes_handler(item : &mut Item) -> i32 {
    
    if item.sell_in < MIN_SELL_IN  {
        0
    } else if item.sell_in <= 5 { 
        item.quality + (QUALITY_UNIT * 3) 
    } else if item.sell_in <= 10 {
        item.quality + (QUALITY_UNIT * 2) 
    } else {
         item.quality + QUALITY_UNIT 
    }
}

fn aged_brie_handler(item : &mut Item) -> i32{
    
    if item.sell_in < MIN_SELL_IN  {
        item.quality + (QUALITY_UNIT * 2) 
    } else {
        item.quality + QUALITY_UNIT 
    }
}

fn no_op_handler(_ : &mut Item) {}

fn generic_handler(item : &mut Item) -> i32 {
    
    if item.sell_in < MIN_SELL_IN  {
        item.quality - (QUALITY_UNIT * 2)
    } else {
        item.quality - QUALITY_UNIT 
    }
}

fn conjured_handler(item : &mut Item) -> i32{
    
    if item.sell_in < MIN_SELL_IN  {
        item.quality - (QUALITY_UNIT * 4)
    } else {
        item.quality - (QUALITY_UNIT * 2)
    }
}

fn wrap_handler(f: Box<Fn(&mut Item) -> i32>) ->  Box<Fn(&mut Item) -> ()> {
    Box::new(move | item | {
        dec_sell_in(item);
        let quality = f(item);
        update_quality(quality, item);
    }) 
}

fn get_handler(name: &String) -> Box<Fn(&mut Item) -> ()>  {

    match name.as_ref() {
        AGED_BRIE => wrap_handler(Box::new(aged_brie_handler)), 
        MAGIC_HAND =>  Box::new(no_op_handler),
        BACKSTAGE_PASSES => wrap_handler(Box::new(backstage_passes_handler)), 
        _ =>  if name.contains(CONJURED) {
                wrap_handler(Box::new(conjured_handler)) 
            } else {  
                wrap_handler(Box::new(generic_handler))
            }
    }
/*
    if name == AGED_BRIE {
        wrap_handler(Box::new(aged_brie_handler))
    } else if name == MAGIC_HAND  {
        Box::new(no_op_handler)
    } else if name == BACKSTAGE_PASSES  {
        wrap_handler(Box::new(backstage_passes_handler))
    } else if name.contains(CONJURED) {
        wrap_handler(Box::new(conjured_handler))        
    } else {
        wrap_handler(Box::new(generic_handler))
    }*/
}

impl GildedRose {
    pub fn new(items: vec::Vec<Item>) -> GildedRose {
        GildedRose {items: items}
    }

    pub fn update_quality(&mut self){

        for item in &mut self.items{
           
            let handler = get_handler(&item.name);
            handler(item);
        }
    }
}

#[cfg(test)]
mod test;
