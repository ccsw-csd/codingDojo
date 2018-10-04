import { TodoListService } from './../src/TodoListService'; 
import { DeleteItemAction } from "../src/actions/DeleteItemAction";
import { AddItemAction } from "../src/actions/AddItemAction";
import { Item } from "./../src/Item";
import { Action } from "../src/actions/Action";
import { ChangeItemStatusAction } from '../src/actions/ChangeItemStatusAction';
import { ReorderItemAction } from '../src/actions/ReorderItemAction';
import { UpdateItemAction } from '../src/actions/UpdateItemAction';

describe('Esta kata prueba una lista de ToDo', () => {

    it('No hacer nada -> Vacio', () => {
        // Arrange
        let actions: Array<Action> = [];
        let todoList= new TodoListService();
        
        // Act
        todoList.put(actions);
        let items: Array<Item> = todoList.get();

        // Assert
        expect(items).toEqual([]);
    });

    it('Añadir 1 elemento -> Ese elemento', () => {
        // Arrange
        let actions: Array<Action> = [new AddItemAction({id:1,description:'Item 1',status:'TODO'})]
        let todoList= new TodoListService();
        
        // Act
        todoList.put(actions);
        let items: Array<Item> = todoList.get();

        // Assert
        expect(items).toEqual([{id:1, description:'Item 1',status:'TODO'}]);
    });

    it('Añadir 1 elemento dos veces -> Ese elemento (una vez)', () => {
        // Arrange
        let actions: Array<Action> = [new AddItemAction({id:1,description:'Item 1',status:'TODO'}), 
            new AddItemAction({id:1,description:'Item 1',status:'TODO'})];
        let todoList= new TodoListService();
        
        // Act
        todoList.put(actions);
        let items: Array<Item> = todoList.get();

        // Assert
        expect(items).toEqual([{id:1, description:'Item 1',status:'TODO'}]);
    });

    it('Añadir 2 elementos -> Esos elementos', () => {
        // Arrange
        let actions: Array<Action> = [new AddItemAction({id:1,description:'Item 1',status:'TODO'}), 
            new AddItemAction({id:2,description:'Item 2',status:'TODO'})];
        let todoList= new TodoListService();
        
        // Act
        todoList.put(actions);
        let items: Array<Item> = todoList.get();

        // Assert
        expect(items).toEqual([{id:1, description:'Item 1',status:'TODO'}, {id:2, description:'Item 2',status:'TODO'}]);
    });

    it('Añadir 1 elemento, borrar ese elemento -> Vacio', () => {
        // Arrange
        let actions: Array<Action> = [new AddItemAction({id:1,description:'Item 1',status:'TODO'}), 
            new DeleteItemAction(1)];
        let todoList= new TodoListService();
        
        // Act
        todoList.put(actions);
        let items: Array<Item> = todoList.get();

        // Assert
        expect(items).toEqual([]);
    });

    it('Añadir 1 elemento, borrar ese elemento dos veces -> Vacio', () => {
        // Arrange
        let actions: Array<Action> = [new AddItemAction({id:1,description:'Item 1',status:'TODO'}), 
            new DeleteItemAction(1), 
            new DeleteItemAction(1)];
        let todoList= new TodoListService();
        
        // Act
        todoList.put(actions);
        let items: Array<Item> = todoList.get();

        // Assert
        expect(items).toEqual([]);
    });

    it('Añadir 1 elemento, cambiar estado a DONE -> Vacio', () => {
        // Arrange
        let actions: Array<Action> = [new AddItemAction({id:1,description:'Item 1',status:'TODO'}), 
            new ChangeItemStatusAction({id:1,status:'DONE'})];
        let todoList= new TodoListService();
        
        // Act
        todoList.put(actions);
        let items: Array<Item> = todoList.get();

        // Assert
        expect(items).toEqual([]);
    });    

    it('Añadir 1 elemento, cambiar estado a cualquiera no DONE -> Ese elemento modificado', () => {
        // Arrange
        let actions: Array<Action> = [new AddItemAction({id:1,description:'Item 1',status:'TODO'}), 
            new ChangeItemStatusAction({id:1,status:'WIP'})];
        let todoList= new TodoListService();
        
        // Act
        todoList.put(actions);
        let items: Array<Item> = todoList.get();

        // Assert
        expect(items).toEqual([{id:1, description:'Item 1', status:'WIP'}]);
    });        

    it('Añadir 2 elementos y reordenarlos -> Esos elementos reordenados', () => {
        // Arrange
        let actions: Array<Action> = [new AddItemAction({id:1,description:'Item 1',status:'TODO'}), 
            new AddItemAction({id:2,description:'Item 2',status:'TODO'}), 
            new ReorderItemAction([2,1])];

        let todoList= new TodoListService();
        
        // Act
        todoList.put(actions);
        let items: Array<Item> = todoList.get();

        // Assert
        expect(items).toEqual([{id:2, description:'Item 2',status:'TODO'}, {id:1, description:'Item 1',status:'TODO'}]);
    });    

    it('Añadir 1 elemento, modificar ese elemento -> Ese elemento modificado', () => {
        // Arrange
        let actions: Array<Action> = [new AddItemAction({id:1,description:'Item 1',status:'TODO'}), 
            new UpdateItemAction({id:1,description:'Item 1b'})]
        let todoList= new TodoListService();
        
        // Act
        todoList.put(actions);
        let items: Array<Item> = todoList.get();

        // Assert
        expect(items).toEqual([{id:1,description:'Item 1b',status:'TODO'}]);
    });
    
    it('Añadir 3 elementos, ordenarlos (2,3,1), modificar 3, cambiar estado 1, eliminar 2, cambiar estado 3 -> {3 modificado y cambio estado}, {1 cambio estado}', () => {
        // Arrange
        let actions: Array<Action> = [new AddItemAction({id:1,description:'Item 1',status:'TODO'}), 
            new AddItemAction({id:2,description:'Item 2',status:'TODO'}), 
            new AddItemAction({id:3,description:'Item 3 ',status:'TODO'}),
            new ReorderItemAction([2,3,1]), 
            new UpdateItemAction({id:3, description:'Item 3b'}), 
            new ChangeItemStatusAction({id:1,status:'WIP'}), 
            new DeleteItemAction(2), 
            new ChangeItemStatusAction({id:3,status:'WIP'})];
        let todoList= new TodoListService();
        
        // Act
        todoList.put(actions);
        let items: Array<Item> = todoList.get();

        // Assert
        expect(items).toEqual([{id:3, description:'Item 3b',status:'WIP'}, {id:1, description:'Item 1',status:'WIP'}]);
    });  
      
});
