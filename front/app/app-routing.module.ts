import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { HotelBookingComponent } from './hotel-booking/hotel-booking.component';
import { ContactsComponent } from './contacts/contacts.component';
import { AboutComponent } from './about/about.component';
import { BookingListComponent } from './booking-list/booking-list.component';
import { RegisterComponent } from './register/register.component';
import { RegisterListComponent } from './register-list/register-list.component';

const routes: Routes = [
  {path:"",pathMatch:'full',redirectTo:'home'},
  {path:'login',component:LoginComponent},
  
  {path:'register',component:RegisterComponent},
  {path:'home',component:HomeComponent},
  {path:'hotel-booking',component:HotelBookingComponent},
  {path:'contacts',component:ContactsComponent},
  {path:'about',component:AboutComponent},
  {path:'booking-list',component:BookingListComponent},
  
  {path:'register-list',component:RegisterListComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
