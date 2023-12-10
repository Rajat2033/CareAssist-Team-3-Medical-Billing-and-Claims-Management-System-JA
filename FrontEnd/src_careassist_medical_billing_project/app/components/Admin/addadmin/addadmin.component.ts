import { Component } from '@angular/core';
import { AdminService } from 'src/app/services/AdminService/admin.service';

@Component({
  selector: 'app-addadmin',
  templateUrl: './addadmin.component.html',
  styleUrls: ['./addadmin.component.css']
})
export class AddadminComponent {

  constructor(private adminService:AdminService){}

  addAdmin(formData:any)

  {
    this.adminService.insertAdmin(formData.form.value).subscribe(data=>{alert ("Admin Added Successfully!");
  console.log(data)})
  }
}