import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';
import { environment } from 'src/environments/environment';

const API_URL = 'http://localhost:8080/api/user/';


@Injectable({providedIn: 'root'})
export class UserService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient){}

  public getUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.apiServerUrl}/api/user/all`);
  }

  public getUserOne(userId: number): Observable<User> {
    return this.http.get<User>(`${this.apiServerUrl}/api/user/find/${userId}`);
  }


  public addUser(user: User): Observable<User> {
    return this.http.post<User>(`${this.apiServerUrl}/api/user/add`, user);
  }

  public updateUser(user: User): Observable<User> {
    return this.http.put<User>(`${this.apiServerUrl}/api/user/update`, user);
  }

  public deleteUser(userId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/api/user/delete/${userId}`);
  }

  getPublicContent(): Observable<any> {
   // return this.http.get(API_URL + 'all', { responseType: 'text' });
    return this.http.get<User[]>(`${this.apiServerUrl}/api/user/all`);
  }

  getUserBoard(): Observable<any> {
    return this.http.get(API_URL + 'user', { responseType: 'text' });
  }
  
  getModeratorBoard(): Observable<any> {
    return this.http.get(API_URL + 'mod', { responseType: 'text' });
  }

  getAdminBoard(): Observable<any> {
    return this.http.get(API_URL + 'admin', { responseType: 'text' });
  }
}

