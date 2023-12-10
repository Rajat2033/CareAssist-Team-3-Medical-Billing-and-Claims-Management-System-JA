import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { JwtCompanyService } from 'src/app/services/InsuranceCompanyService/jwt-company.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {
  companyName:any;
  constructor(private jwtCompanyService: JwtCompanyService,private router:Router){
    this.companyName=sessionStorage.getItem('companyName');
  }

  logoutCompany() {
    
    this.jwtCompanyService.clearToken();
    this.router.navigate(['/login/company']);
  }
  

}
