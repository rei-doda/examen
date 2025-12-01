import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../../../environments/environment';

export interface Todo {
  id: number;
  title: string;
  done: boolean;
  date: string;
}

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private baseUrl = `${environment.apiUrl}/todos`;

  constructor(private http: HttpClient) {}

  getToday(): Observable<Todo[]> {
    return this.http.get<Todo[]>(`${this.baseUrl}/today`);
  }

  getAll(): Observable<Todo[]> {
    return this.http.get<Todo[]>(this.baseUrl);
  }

  toggle(id: number, done: boolean): Observable<Todo> {
    return this.http.patch<Todo>(`${this.baseUrl}/${id}`, { done });
  }
}
