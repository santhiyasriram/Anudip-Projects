import { Component } from '@angular/core';
import { Guest } from '../Entity/guest';
import { GuestService } from '../Services/guest.service';

@Component({
  selector: 'app-register-list',
  templateUrl: './register-list.component.html',
  styleUrls: ['./register-list.component.css']
})
export class RegisterListComponent {


  guests!: Guest[];

  constructor(private guestService: GuestService) {
  }

  ngOnInit() {
    this.guestService.findAll().subscribe(data => {
      this.guests = data;
    });
  }
}
