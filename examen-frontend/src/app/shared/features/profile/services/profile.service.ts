import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../../../environments/environment';

export interface ProfileSummary {
  examinationsCompleted: number;
  todosCompleted: number;
  categoriesUsed: number;
  streakDays: number;
}

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  private baseUrl = `${environment.apiUrl}/profile`;

  constructor(private http: HttpClient) {}

  /**
   * Loads summary for the last 30 days (as your backend does).
   */
  getSummaryForLast30Days(): Observable<ProfileSummary> {
    return this.http.get<ProfileSummary>(`${this.baseUrl}/summary`);
  }
}
