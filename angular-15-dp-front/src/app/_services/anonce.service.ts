import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Anonce } from '../models/anonce';
import { environment } from 'src/environments/environment';

@Injectable({providedIn: 'root'})
export class AnonceService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient){}

  public getAnonces(): Observable<Anonce[]> {
    return this.http.get<Anonce[]>(`${this.apiServerUrl}/api/anonce/all`);
  }
  public getAnonceOne(anonceId: number): Observable<Anonce> {
    return this.http.get<Anonce>(`${this.apiServerUrl}/api/anonce/find/${anonceId}`);
  }

  public addAnonce(anonce: Anonce): Observable<Anonce> {
    return this.http.post<Anonce>(`${this.apiServerUrl}/api/anonce/add`, anonce);
  }

  public reserveAnonce(anonce: Anonce): Observable<Anonce> {
    return this.http.put<Anonce>(`${this.apiServerUrl}/api/anonce/update`, anonce);
  }


  public updateAnonce(anonce: Anonce): Observable<Anonce> {
    return this.http.put<Anonce>(`${this.apiServerUrl}/api/anonce/update`, anonce);
  }

  public deleteAnonce(anonceId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/api/anonce/delete/${anonceId}`);
  }
}
