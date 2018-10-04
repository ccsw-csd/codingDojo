import { Action } from "./Action";
import { Item } from "../Item";

export class AddItemAction extends Action {
    item: Item;

    constructor(item: Item) {
        super();
        this.item = item;
    }

    public execute(itemList: Array<Item>) {
        let itemFound = this.findItem(this.item.id, itemList);
        if (itemFound) return itemList;
        
        itemList.push(this.item);
        return itemList;
    }
}