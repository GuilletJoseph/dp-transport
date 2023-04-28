import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { User } from '../models/user';
import { HttpClient } from '@angular/common/http';


const USER_KEY = 'auth-user';

@Injectable({
  providedIn: 'root'
})
export class StorageService {
  private apiServerUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) {}

  public clean(): void {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.clear();
   
  }

  public saveUser(user: any): void {
   window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }

  public getUser(): any {
    const user = window.sessionStorage.getItem(USER_KEY);
    if (user) {
  return this.http.get<User>(`${this.apiServerUrl}/api/user/find/${JSON.parse(user).id}`);
    }
    return {};
  }


  public getUser2(): any {
    const user2 = window.sessionStorage.getItem(USER_KEY);
    if (user2) {
     return JSON.parse(user2);
    }
    return {};
  }

  public isLoggedIn(): boolean {
    const user = window.sessionStorage.getItem(USER_KEY);
    if (user) {
      return true;
    }

    return false;
  }
}
