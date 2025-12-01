import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../../../environments/environment';

export interface ExaminationAnswer {
  questionId: number;
  answerValue: boolean;
}

export interface DailyExamination {
  id: number;
  date: string;
  answers: ExaminationAnswer[];
}

@Injectable({
  providedIn: 'root'
})
export class ExaminationService {
  private baseUrl = `${environment.apiUrl}/examination`;

  constructor(private http: HttpClient) {}

  /**
   * Loads today's examination (your backend exposes this).
   */
  getToday(): Observable<DailyExamination> {
    return this.http.get<DailyExamination>(`${this.baseUrl}/today`);
  }

  /**
   * Saves examination (your backend maps it to /save).
   */
  save(exam: DailyExamination): Observable<any> {
    return this.http.post(`${this.baseUrl}/save`, exam);
  }
}
