import { Action } from "./Action";
import { Item } from "../Item";
import { ItemDescription } from "../ItemDescription";
import { ItemStatus } from "../ItemStatus";

export class ChangeItemStatusAction extends Action {
    item: ItemStatus;

    constructor(item: ItemStatus) {
        super();
        this.item = item;
    }
    public execute(itemList: Array<Item>): Array<Item> {
        if (this.item.status == 'DONE') {
            itemList = itemList.filter(item => item.id != this.item.id);
            return itemList;
        }
        
        let itemFound = this.findItem(this.item.id, itemList);
        if (itemFound) {
                itemFound.status = this.item.status;
        }
        return itemList;
    }
}