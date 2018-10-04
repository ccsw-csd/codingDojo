import { TodoListService, Action, Item } from './../src/TodoListService';

describe('Esta kata prueba una lista de ToDo', () => {

    it('No hacer nada -> Vacio', () => {
        // Arrange
        let actions: Array<Action> = [];
        let todoListService = new TodoListService();
        
        // Act
        todoListService.put(actions);
        let items: Array<Item> = todoListService.get();

        // Assert
        expect(items).toEqual([]);
    });

    it('Añadir 1 elemento -> Ese elemento', () => {
        // Arrange
        let actions: Array<Action> = [{code:'a',item:{id:1,b:'Item 1',c:'TODO'}}]
        let todoListService = new TodoListService();
        
        // Act
        todoListService.put(actions);
        let items: Array<Item> = todoListService.get();

        // Assert
        expect(items).toEqual([{id:1, b:'Item 1',c:'TODO'}]);
    });

    it('Añadir 1 elemento dos veces -> Ese elemento (una vez)', () => {
        // Arrange
        let actions: Array<Action> = [
            {code:'a',item:{id:1,b:'Item 1',c:'TODO'}},
            {code:'a',item:{id:1,b:'Item 1',c:'TODO'}}
        ];
        let todoListService = new TodoListService();
        
        // Act
        todoListService.put(actions);
        let items: Array<Item> = todoListService.get();

        // Assert
        expect(items).toEqual([{id:1, b:'Item 1',c:'TODO'}]);
    });

    it('Añadir 2 elementos -> Esos elementos', () => {
        // Arrange
        let actions: Array<Action> = [
            {code:'a',item:{id:1,b:'Item 1',c:'TODO'}},
            {code:'a',item:{id:2,b:'Item 2',c:'TODO'}}
        ];
        let todoListService = new TodoListService();
        
        // Act
        todoListService.put(actions);
        let items: Array<Item> = todoListService.get();

        // Assert
        expect(items).toEqual([
            {id:1, b:'Item 1',c:'TODO'},
            {id:2, b:'Item 2',c:'TODO'}
        ]);
    });

    it('Añadir 1 elemento, borrar ese elemento -> Vacio', () => {
        // Arrange
        let actions: Array<Action> = [{code:'a',item:{id:1,b:'Item 1',c:'TODO'}}, {code:'d',c:1}]
        let todoListService = new TodoListService();
        
        // Act
        todoListService.put(actions);
        let items: Array<Item> = todoListService.get();

        // Assert
        expect(items).toEqual([]);
    });

    it('Añadir 1 elemento, borrar ese elemento dos veces -> Vacio', () => {
        // Arrange
        let actions: Array<Action> = [{code:'a',item:{id:1,b:'Item 1',c:'TODO'}}, {code:'d',c:1}, {code:'d',c:1}]
        let todoListService = new TodoListService();
        
        // Act
        todoListService.put(actions);
        let items: Array<Item> = todoListService.get();

        // Assert
        expect(items).toEqual([]);
    });

    it('Añadir 1 elemento, cambiar estado a DONE -> Vacio', () => {
        // Arrange
        let actions: Array<Action> = [{code:'a',item:{id:1,b:'Item 1',c:'TODO'}}, {code:'s',e:{a:1,b:'DONE'}}]
        let todoListService = new TodoListService();
        
        // Act
        todoListService.put(actions);
        let items: Array<Item> = todoListService.get();

        // Assert
        expect(items).toEqual([]);
    });    

    it('Añadir 1 elemento, cambiar estado a cualquiera no DONE -> Ese elemento modificado', () => {
        // Arrange
        let actions: Array<Action> = [{code:'a',item:{id:1,b:'Item 1',c:'TODO'}}, {code:'s',e:{a:1,b:'WIP'}}]
        let todoListService = new TodoListService();
        
        // Act
        todoListService.put(actions);
        let items: Array<Item> = todoListService.get();

        // Assert
        expect(items).toEqual([{id:1, b:'Item 1', c:'WIP'}]);
    });        

    it('Añadir 2 elementos y reordenarlos -> Esos elementos reordenados', () => {
        // Arrange
        let actions: Array<Action> = [{code:'a',item:{id:1,b:'Item 1',c:'TODO'}}, {code:'a',item:{id:2,b:'Item 2',c:'TODO'}}, {code:'o',f:[2,1]}]
        let todoListService = new TodoListService();
        
        // Act
        todoListService.put(actions);
        let items: Array<Item> = todoListService.get();

        // Assert
        expect(items).toEqual([{id:2, b:'Item 2',c:'TODO'}, {id:1, b:'Item 1',c:'TODO'}]);
    });    

    // it('Añadir 1 elemento, modificar ese elemento -> Ese elemento modificado', () => {
    //     // Arrange
    //     let actions: Array<Action> = [{code:'a',b:{a:1,b:'Item 1',c:'TODO'}}, {code:'u',d:{a:1,b:'Item 1b'}}]
    //     let todoListService = new TodoListService();
        
    //     // Act
    //     todoListService.put(actions);
    //     let items: Array<Item> = todoListService.get();

    //     // Assert
    //     expect(items).toEqual([{a:1, b:'Item 1b',c:'TODO'}]);
    // });
    
    // it('Añadir 3 elementos, ordenarlos (2,3,1), modificar 3, cambiar estado 1, eliminar 2, cambiar estado 3 -> {3 modificado y cambio estado}, {1 cambio estado}', () => {
    //     // Arrange
    //     let actions: Array<Action> = [{code:'a',b:{a:1,b:'Item 1',c:'TODO'}}, {code:'a',b:{a:2,b:'Item 2',c:'TODO'}}, {code:'a',b:{a:3,b:'Item 3 ',c:'TODO'}},
    //         {code:'o',f:[2,3,1]}, {code:'u', d:{a:3, b:'Item 3b'}}, {code:'s',e:{a:1,b:'WIP'}}, {code:'d', c:2}, {code:'s',e:{a:3,b:'WIP'}}];
    //     let todoListService = new TodoListService();
        
    //     // Act
    //     todoListService.put(actions);
    //     let items: Array<Item> = todoListService.get();

    //     // Assert
    //     expect(items).toEqual([{a:3, b:'Item 3b',c:'WIP'}, {a:1, b:'Item 1',c:'WIP'}]);
    // });    
});
