import { Action } from "./actions/Action";
import { ItemDescription } from "./ItemDescription";
import { ItemStatus } from "./ItemStatus";
import { Item } from "./Item";

export class TodoListService {
    
    private itemList : Array<Item> = [];

    public put(actionList:Array<Action>) {

        for (let i = 0; i < actionList.length; i++) {   
            let action = actionList[i];
            this.itemList = action.execute(this.itemList);
        }
    }

    public get(): Array<any> {
        return this.itemList;
    }
};
