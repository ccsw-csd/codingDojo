import { Action } from "./Action";
import { Item } from "../Item";
 
export class ReorderItemAction extends Action {
    itemsOrder: Array<number>;

    constructor(itemsOrder: Array<number>) {
        super();
        this.itemsOrder = itemsOrder;
    }

    public execute(itemList: Array<Item>) {
        let newItemList : Array<Item> = [];

        for (let j = 0; j < this.itemsOrder.length; j++) {
            let order = this.itemsOrder[j];

            let itemFound = this.findItem(order, itemList);
            if (itemFound) {
                newItemList.push(itemFound);
            }
        }

        return newItemList; 
    }
}