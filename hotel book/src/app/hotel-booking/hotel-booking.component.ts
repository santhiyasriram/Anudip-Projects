import { Component } from '@angular/core';
import { Guest } from '../Entity/guest';
import { GuestService } from '../Services/guest.service';
import { Room } from '../Entity/room';
import { RoomService } from '../Services/room.service';

@Component({
  selector: 'app-hotel-booking',
  templateUrl: './hotel-booking.component.html',
  styleUrls: ['./hotel-booking.component.css']
})
export class HotelBookingComponent {
  

  room:Room=new Room();


  constructor(private roomService:RoomService){

  }

  ngOnInit():void{

  }
  hotel(){
    console.log(this.room)
    this.roomService.addRoom(this.room).subscribe((data: any)=>{
      alert("Booking Sucessfully")
      
    }
    )

}
}