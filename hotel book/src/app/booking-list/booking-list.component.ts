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
 

  empDetail !: FormGroup;
  room : Room = new Room();
  roomList: Room[] = [];

  constructor(private formBuilder : FormBuilder, private roomService : RoomService) { }

  ngOnInit(): void {

    this.getAllRoom();

    this.empDetail = this.formBuilder.group({
      roomId: [''],
      roomType: [''],
      price: ['']
    });    

  }

  addRoom() {
    console.log(this.empDetail);
    this.room.roomId= this.empDetail.value.roomId;
    this.room.roomType= this.empDetail.value.roomType;
    this.room.price= this.empDetail.value.price;

    this.roomService.addRoom(this.room).subscribe(res=>{
        console.log(res);
        this.getAllRoom();
    },err=>{
        console.log(err);
    });

  }

  getAllRoom() {
    this.roomService.getAllRoom().subscribe(res=>{
        this.roomList = res;
    },err=>{
      console.log("error while fetching data.")
    });
  }

  editRoom(room : Room) {
    this.empDetail.controls['roomId'].setValue(room.roomId);
    this.empDetail.controls['roomId'].setValue(room.roomType);
    this.empDetail.controls['price'].setValue(room.price);

  }

  updateRoom() {

    this.room.roomId = this.empDetail.value.roomId;
    this.room.roomType = this.empDetail.value.roomType;
    this.room.price = this.empDetail.value.price;

    this.roomService.updateRoom(this.room).subscribe(res=>{
      console.log(res);
      this.getAllRoom();
    },err=>{
      console.log(err);
    })

  }

  deleteRoom(room : Room) {

    this.roomService.deleteRoom(room).subscribe(res=>{
      console.log(res);
      alert('Room deleted successfully');
      this.getAllRoom();
    },err => {
      console.log(err);
    });

  }
   
  
}
