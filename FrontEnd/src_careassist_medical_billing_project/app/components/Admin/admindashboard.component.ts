import { Component } from '@angular/core';
import { LoginAdminComponent } from './login-admin/login-admin.component';
import { JwtAdminService } from 'src/app/services/AdminService/jwt-admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admindashboard',
  templateUrl: './admindashboard.component.html',
  styleUrls: ['./admindashboard.component.css']
})
export class AdmindashboardComponent {

  adminname!:any;
  constructor(private jwtAdminService: JwtAdminService,private router:Router){

    this.adminname=sessionStorage.getItem('adminName');
    console.log(this.adminname);

  }

  logoutAdmin() {
    
    this.jwtAdminService.clearToken();
    this.router.navigate(['/login/admin']);
  }

  
}
