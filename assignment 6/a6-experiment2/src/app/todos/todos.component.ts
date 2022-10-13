import { Component, OnInit } from '@angular/core';
import {Todo} from "../Todo";
import {TodoServerService} from "../todo-server.service";

@Component({
  selector: 'app-todos',
  templateUrl: './todos.component.html',
  styleUrls: ['./todos.component.css']
})
export class TodosComponent implements OnInit {

   todoId: number;
   todoSummary: string;
   todoDescription: string;

   todoArray: Todo[];

  constructor(private todoServerService : TodoServerService) {
    this.todoId = 0;
    this.todoSummary = "";
    this.todoDescription = "";
    this.todoArray = [];

  }

  ngOnInit(): void {
  }

  addTodo() {
    let newTodo = {
      id: this.todoId,
      summary: this.todoSummary,
      description: this.todoDescription
    };
    this.todoServerService.addTodo(newTodo).subscribe(res => {}, error => {
      alert(error);
    })
  }

  getAllTodos(){
    this.todoServerService.getAllTodo().subscribe(res => {
      this.todoArray = res;
    }, error => {
      alert(error);
    });
  }

  deleteTask(todo : Todo) {
    this.todoServerService.deleteTask(todo).subscribe(res => {
      this.getAllTodos();
    }, err=> {
      alert("Failed to delete task");
    });
  }

}
