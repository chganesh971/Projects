import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpService } from '../service/http.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  inputs = {
    "name":"",
    "surname":"",
    "address":""
  }
  
  constructor(private snack:MatSnackBar, private emailService:HttpService) { }

  ngOnInit(): void {
  }

  sendEmail() {
    if(this.inputs.name == "" || this.inputs.surname == "" || this.inputs.address == "" || this.inputs.name.trim().length == 0 || this.inputs.surname.trim().length == 0 || this.inputs.address.trim().length == 0) {
      this.snack.open("Please enter details!","OK");
      return false;
    }
    

    this.emailService.sendEmail(this.inputs.name).subscribe(res => {    
      this.snack.open(res);
      return true;
    });

  }
  

}
