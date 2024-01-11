import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { GuestService } from '../Services/guest.service';
import { Guest } from '../Entity/guest';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  guest:Guest=new Guest();


  constructor(private guestService:GuestService){

  }

  ngOnInit():void{

  }
  Login(){
    console.log(this.guest)
    this.guestService.save(this.guest).subscribe(data=>{
      alert("Login Sucessfully")
      
    }
    )
  }
}