export class Item {
    a: number;
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
    a: string;
    b?: Item;
    c?: number;
    d?: ItemDescription;
    e?: ItemStatus;
    f?: Array<number>;
}

export class TodoListService {
    
    private l : Array<Item> = [];

    public put(a:Array<Action>) {

        for (let i = 0; i < a.length; i++) {   

            if (a[i].a == 'a' && a[i].b) {
                for (let j = 0; j < this.l.length; j++) {
                    if (this.l[j].a == a[i].b.a) {
                        return;
                    }
                }
                this.l.push(a[i].b);
            }
            else {
                if (a[i].a == 'd' && a[i].c) {
                    for (let j = 0; j < this.l.length; j++) {
                        if (this.l[j].a == a[i].c) {
                            this.l.splice(j, 1);
                        }
                    }
                } 
                else {
                    if (a[i].a == 'u' && a[i].d) {
                        for (let j = 0; j < this.l.length; j++) {
                            if (this.l[j].a == a[i].d.a) {
                                this.l[j].b = a[i].d.b;
                            }
                        }
                    }     
                    else {
                        if (a[i].a == 's' && a[i].e) {
                            for (let j = 0; j < this.l.length; j++) {
                                if (this.l[j].a == a[i].e.a) {
                                    if (a[i].e.b == 'DONE') {
                                        for (let k = 0; k < this.l.length; k++) {
                                            if (this.l[k].a == a[i].e.a) {
                                                this.l.splice(k, 1);
                                            }
                                        }
                                    }
                                    else if (a[i].e.b != 'DONE') {
                                        this.l[j].c = a[i].e.b;
                                    }
                                }
                            }
                        }
                        else {
                            if (a[i].a == 'o' && a[i].f) {
                                let l : Array<Item> = [];
                                for (let j = 0; j < a[i].f.length; j++) {
                                    let order = a[i].f[j];
                                    for (let k = 0; k < this.l.length; k++) {
                                        if (this.l[k].a == a[i].f[j]) {
                                            l.push(this.l[k]);
                                        }
                                    }
                                }
                                this.l = l;
                            }
                        }
                    }
                }
            }
        }
    }

    public get(): Array<any> {
        return this.l;
    }
};
