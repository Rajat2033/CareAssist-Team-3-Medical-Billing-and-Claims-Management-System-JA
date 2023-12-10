import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class JwtPatientService {

  private patientURL: string = 'http://localhost:8080/api/v1/patients/';
  private tokenKey: string = 'jwtToken';

  constructor(private http: HttpClient) {}

  login(username: string, password: string): Observable<string> {
    const requestBody = { username, password };
    return this.http.post<string>(this.patientURL + 'authenticate', requestBody,{responseType: 'text' as 'json'});
  }
  setToken(token: string): void {
    localStorage.setItem(this.tokenKey, token);
  }

  getToken(): string | null {
    return localStorage.getItem(this.tokenKey);
  }

  clearToken(): void {
    localStorage.removeItem(this.tokenKey);
  }
}
