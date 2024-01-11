import { Component, OnInit } from '@angular/core';
import { Room } from '../Entity/room';
import { RoomService } from '../Services/room.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { FormGroup, FormBuilder } from '@angular/forms';
@Component({
  selector: 'app-booking-list',
  templateUrl: './booking-list.component.html',
  styleUrls: ['./booking-list.component.css']
})
export class BookingListComponent implements OnInit {

  

  rooms!: Room[];

  constructor(private roomService: RoomService) {
  }

  ngOnInit() {
    this.roomService.findAll().subscribe(data => {
      this.rooms = data;
    });
  }
  }
   
  

