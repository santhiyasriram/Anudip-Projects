import { Component } from '@angular/core';
import { RoomService } from '../Services/room.service';
import { Room } from '../Entity/room';

@Component({
  selector: 'app-user-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.css']
})
export class UserEditComponent {


  

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
