import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, tap } from 'rxjs';
import { environment } from '../../../environments/environment';

export interface AuthRequest {
  email: string;
  password: string;
}

export interface RegisterRequest {
  fullName: string;
  email: string;
  password: string;
}

export interface AuthResponse {
  userId: number;
  fullName: string;
  email: string;
  token: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = `${environment.apiUrl}/auth`;

  private currentUserSubject = new BehaviorSubject<AuthResponse | null>(null);
  currentUser$ = this.currentUserSubject.asObservable();

  constructor(private http: HttpClient) {
    const saved = localStorage.getItem('auth');
    if (saved) {
      try {
        const parsed = JSON.parse(saved) as AuthResponse;
        this.currentUserSubject.next(parsed);
      } catch {
        localStorage.removeItem('auth');
      }
    }
  }

  login(data: AuthRequest): Observable<AuthResponse> {
    return this.http
      .post<AuthResponse>(`${this.baseUrl}/login`, data)
      .pipe(tap(res => this.handleAuth(res)));
  }

  register(data: RegisterRequest): Observable<AuthResponse> {
    return this.http
      .post<AuthResponse>(`${this.baseUrl}/register`, data)
      .pipe(tap(res => this.handleAuth(res)));
  }

  logout(): void {
    localStorage.removeItem('auth');
    localStorage.removeItem('token');
    this.currentUserSubject.next(null);
  }

  get token(): string | null {
    const current = this.currentUserSubject.value;
    if (current?.token) {
      return current.token;
    }
    return localStorage.getItem('token');
  }

  get isLoggedIn(): boolean {
    return !!this.token;
  }

  private handleAuth(res: AuthResponse): void {
    localStorage.setItem('auth', JSON.stringify(res));
    localStorage.setItem('token', res.token);
    this.currentUserSubject.next(res);
  }
}

// keep default export because the interceptor imports it as default
export default AuthService;
