import { Item } from "../Item";
import { ItemStatus } from "../ItemStatus";
import { ItemDescription } from "../ItemDescription";

export class Action {
    public execute(itemList: Array<Item>): Array<Item> {return itemList;};

    protected findItem(id: number, itemList: Array<Item>): Item {
        let exists = itemList.filter(item => item.id == id);
        if (exists.length > 0)
            return exists[0];

        return null;
    }
}