import { TodoListService, Action, Item } from './../src/TodoListService';

describe('Esta kata prueba una lista de ToDo', () => {
    it('No hacer nada -> Vacio', () => {
        // Arrange
        let a: Array<Action> = [];
        let b = new TodoListService();
        
        // Act
        b.put(a);
        let c: Array<Item> = b.get();

        // Assert
        expect(c).toEqual([]);
    });
    it('Añadir 1 elemento -> Ese elemento', () => {
        // Arrange
        let a: Array<Action> = [{a:'a',b:{a:1,b:'Item 1',c:'TODO'}}]
        let b = new TodoListService();
        
        // Act
        b.put(a);
        let c: Array<Item> = b.get();

        // Assert
        expect(c).toEqual([{a:1, b:'Item 1',c:'TODO'}]);
    });
    it('Añadir 1 elemento dos veces -> Ese elemento (una vez)', () => {
        // Arrange
        let a: Array<Action> = [{a:'a',b:{a:1,b:'Item 1',c:'TODO'}}, {a:'a',b:{a:1,b:'Item 1',c:'TODO'}}]
        let b = new TodoListService();
        
        // Act
        b.put(a);
        let c: Array<Item> = b.get();

        // Assert
        expect(c).toEqual([{a:1, b:'Item 1',c:'TODO'}]);
    });
    it('Añadir 2 elementos -> Esos elementos', () => {
        // Arrange
        let a: Array<Action> = [{a:'a',b:{a:1,b:'Item 1',c:'TODO'}}, {a:'a',b:{a:2,b:'Item 2',c:'TODO'}}]
        let b = new TodoListService();
        
        // Act
        b.put(a);
        let c: Array<Item> = b.get();

        // Assert
        expect(c).toEqual([{a:1, b:'Item 1',c:'TODO'}, {a:2, b:'Item 2',c:'TODO'}]);
    });
    it('Añadir 1 elemento, borrar ese elemento -> Vacio', () => {
        // Arrange
        let a: Array<Action> = [{a:'a',b:{a:1,b:'Item 1',c:'TODO'}}, {a:'d',c:1}]
        let b = new TodoListService();
        
        // Act
        b.put(a);
        let c: Array<Item> = b.get();

        // Assert
        expect(c).toEqual([]);
    });
    it('Añadir 1 elemento, borrar ese elemento dos veces -> Vacio', () => {
        // Arrange
        let a: Array<Action> = [{a:'a',b:{a:1,b:'Item 1',c:'TODO'}}, {a:'d',c:1}, {a:'d',c:1}]
        let b = new TodoListService();
        
        // Act
        b.put(a);
        let c: Array<Item> = b.get();

        // Assert
        expect(c).toEqual([]);
    });
    it('Añadir 1 elemento, modificar ese elemento -> Ese elemento modificado', () => {
        // Arrange
        let a: Array<Action> = [{a:'a',b:{a:1,b:'Item 1',c:'TODO'}}, {a:'u',d:{a:1,b:'Item 1b'}}]
        let b = new TodoListService();
        
        // Act
        b.put(a);
        let c: Array<Item> = b.get();

        // Assert
        expect(c).toEqual([{a:1, b:'Item 1b',c:'TODO'}]);
    });
    it('Añadir 1 elemento, cambiar estado a DONE -> Vacio', () => {
        // Arrange
        let a: Array<Action> = [{a:'a',b:{a:1,b:'Item 1',c:'TODO'}}, {a:'s',e:{a:1,b:'DONE'}}]
        let b = new TodoListService();
        
        // Act
        b.put(a);
        let c: Array<Item> = b.get();

        // Assert
        expect(c).toEqual([]);
    });    
    it('Añadir 1 elemento, cambiar estado a cualquiera no DONE -> Ese elemento modificado', () => {
        // Arrange
        let a: Array<Action> = [{a:'a',b:{a:1,b:'Item 1',c:'TODO'}}, {a:'s',e:{a:1,b:'WIP'}}]
        let b = new TodoListService();
        
        // Act
        b.put(a);
        let c: Array<Item> = b.get();

        // Assert
        expect(c).toEqual([{a:1, b:'Item 1', c:'WIP'}]);
    });        
    it('Añadir 2 elementos y reordenarlos -> Esos elementos reordenados', () => {
        // Arrange
        let a: Array<Action> = [{a:'a',b:{a:1,b:'Item 1',c:'TODO'}}, {a:'a',b:{a:2,b:'Item 2',c:'TODO'}}, {a:'o',f:[2,1]}]
        let b = new TodoListService();
        
        // Act
        b.put(a);
        let c: Array<Item> = b.get();

        // Assert
        expect(c).toEqual([{a:2, b:'Item 2',c:'TODO'}, {a:1, b:'Item 1',c:'TODO'}]);
    });    
    it('Añadir 3 elementos, ordenarlos (2,3,1), modificar 3, cambiar estado 1, eliminar 2, cambiar estado 3 -> {3 modificado y cambio estado}, {1 cambio estado}', () => {
        // Arrange
        let a: Array<Action> = [{a:'a',b:{a:1,b:'Item 1',c:'TODO'}}, {a:'a',b:{a:2,b:'Item 2',c:'TODO'}}, {a:'a',b:{a:3,b:'Item 3 ',c:'TODO'}},
            {a:'o',f:[2,3,1]}, {a:'u', d:{a:3, b:'Item 3b'}}, {a:'s',e:{a:1,b:'WIP'}}, {a:'d', c:2}, {a:'s',e:{a:3,b:'WIP'}}];
        let b = new TodoListService();
        
        // Act
        b.put(a);
        let c: Array<Item> = b.get();

        // Assert
        expect(c).toEqual([{a:3, b:'Item 3b',c:'WIP'}, {a:1, b:'Item 1',c:'WIP'}]);
    });    
});
