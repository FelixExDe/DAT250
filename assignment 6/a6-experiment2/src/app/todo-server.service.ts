import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {Todo} from "./Todo";

@Injectable({
  providedIn: 'root'
})
export class TodoServerService {
  serverURL: string;

  constructor(private http: HttpClient) {
    this.serverURL = "/todos";
  }

  addTodo(todo : Todo) : Observable<Todo> {
    return this.http.post<Todo>(this.serverURL, todo);
  }

  getAllTodo(): Observable<Todo[]>{
    return this.http.get<Todo[]>(this.serverURL);
  }

  deleteTask(todo : Todo) : Observable<Todo> {
    return this.http.delete<Todo>(this.serverURL+'/'+todo.id);
  }
}
