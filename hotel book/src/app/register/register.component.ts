import { Component } from '@angular/core';
import { Guest } from '../Entity/guest';
import { GuestService } from '../Services/guest.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  guest:Guest=new Guest();


  constructor(private guestService:GuestService){

  }

  ngOnInit():void{

  }
  Login(){
    console.log(this.guest)
    this.guestService.save(this.guest).subscribe(data=>{
      alert("Login Sucessfully")
      
    },error=>alert("Sorry please enter correct Email and Password")
    )
  }
}
