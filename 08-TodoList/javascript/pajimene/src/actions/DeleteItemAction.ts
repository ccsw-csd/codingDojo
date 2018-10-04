import { Action } from "./Action";
import { Item } from "../Item";

export class DeleteItemAction extends Action {
    id: number;
    constructor(id: number) {
        super();
        this.id = id;
    }
    public execute(itemList: Array<Item>): Array<Item> {
        return itemList.filter(item => item.id != this.id);
    }
}