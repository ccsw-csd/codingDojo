export class Item {
    id: number;
    b: string;
    c: string;
}

export class ItemStatus {
    a: number;
    b: string;
}

export class ItemDescription {
    a: number;
    b: string;
}

export class Action {
    code: string;
    item?: Item;
    c?: number;
    d?: ItemDescription;
    e?: ItemStatus;
    f?: Array<number>;
}

export class TodoListService {
    
    private items : Array<Item> = [];

    public put(actions:Array<Action>) {

        for (const action of actions) {

            if (this.actionIsAdd(action)) {
                this.addItems(action);
            }
            if (this.actionIsDelete(action)) {
                this.deleteItem(action);               
            }
            if (this.actionIsUpdate(action)) {
                this.updateItem(action);
            }
            if (this.actionIsChangeStatus(action)) {
                this.changeStatus(action);
            }
            if (this.actionIsSort(action)) {
                this.sort(action);
            }
        }
    }

    private actionIsChangeStatus(action: Action) {
        return action.code == 's' && action.e;
    }

    private actionIsSort(action: Action) {
        return action.code == 'o' && action.f;
    }

    private actionIsUpdate(action: Action) {
        return action.code == 'u' && action.d;
    }

    private actionIsDelete(action: Action) {
        return action.code == 'd' && action.c;
    }

    private actionIsAdd(action: Action) {
        return action.code == 'a' && action.item;
    }

    public get(): Array<any> {
        return this.items;
    }

    private addItems(action: Action) {
        let item: Item = this.findItem(action.item.id);
        if (item) {
            return;
        }
        this.items.push(action.item);
    }

    private findItem(id: number): Item {
        let filteredItems: Array<Item> = this.items.filter(it => it.id === id);

        return filteredItems.length > 0 ? filteredItems[0] : null;
    }
    
    private deleteItem(action: Action): void {
        for (let j = 0; j < this.items.length; j++) {
            if (this.items[j].id == action.c) {
                this.items.splice(j, 1);
            }
        }
    }

    private updateItem(action: Action): void {
        for (let j = 0; j < this.items.length; j++) {
            if (this.items[j].id == action.d.a) {
                this.items[j].c = action.d.b;
            }
        }
    }

    private changeStatus(action: Action) {
        for (let j = 0; j < this.items.length; j++) {
            if (this.items[j].id == action.e.a) {
                if (action.e.b == 'DONE') {
                    for (let k = 0; k < this.items.length; k++) {
                        if (this.items[k].id == action.e.a) {
                            this.items.splice(k, 1);
                        }
                    }
                }
                else if (action.e.b != 'DONE') {
                    this.items[j].c = action.e.b;
                }
            }
        }
    }

    private sort(action: Action) {
        let l : Array<Item> = [];
        for (let j = 0; j < action.f.length; j++) {
            let order = action.f[j];
            for (let k = 0; k < this.items.length; k++) {
                if (this.items[k].id == action.f[j]) {
                    l.push(this.items[k]);
                }
            }
        }
        this.items = l;
    }
};
