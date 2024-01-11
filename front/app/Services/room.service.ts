import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Room } from '../Entity/room';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  addEmpURL : string;
  getEmpURL : string;
  updateEmpUrl : string;
  deleteEmpUrl : string;

  constructor(private http : HttpClient) {

    this.addEmpURL = 'http://localhost:8086/postroom';
    this.getEmpURL = 'http://localhost:8086/room';
    this.updateEmpUrl = 'http://localhost:8086/updateroom';
    this.deleteEmpUrl = 'http://localhost:8086/deleteroom';

   }

   addRoom(room : Room): Observable<Room> {
     return this.http.post<Room>(this.addEmpURL,room);
   }

   getAllRoom(): Observable<Room[]>{
     return this.http.get<Room[]>(this.getEmpURL);
   }

   updateRoom(room :Room) : Observable<Room>{
     return this.http.put<Room>(this.updateEmpUrl, room);
   }
   
  findAll(): Observable<any> {
    console.log(Room)
    return this.http.get('http://localhost:8086/room');
  }

   deleteRoom(room : Room) : Observable<Room> {
     return this.http.delete<Room>(this.deleteEmpUrl+'/'+room.roomId);
   }
  

}