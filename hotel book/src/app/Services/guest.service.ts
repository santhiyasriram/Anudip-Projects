import { Injectable } from '@angular/core';
import { Guest } from '../Entity/guest';
import { Observable } from 'rxjs/internal/Observable';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GuestService  {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8086/post';
  }
  findAll(): Observable<any> {
    console.log(Guest)
    return this.http.get('http://localhost:8086/guest');
  }

  public save(guest: Guest) {
    return this.http.post<Guest>(this.usersUrl, guest);
  }}
