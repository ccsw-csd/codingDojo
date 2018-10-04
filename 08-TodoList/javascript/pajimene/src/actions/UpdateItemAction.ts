import { Action } from "./Action";
import { Item } from "../Item";
import { ItemDescription } from "../ItemDescription";

export class UpdateItemAction extends Action {
    item: ItemDescription;

    constructor(item: ItemDescription) {
        super();
        this.item = item;
    }
    public execute(itemList: Array<Item>): Array<Item> {
        let itemFound = this.findItem(this.item.id, itemList);

        if (itemFound) {
            itemFound.description = this.item.description;
        }

        return itemList;            
    }
}