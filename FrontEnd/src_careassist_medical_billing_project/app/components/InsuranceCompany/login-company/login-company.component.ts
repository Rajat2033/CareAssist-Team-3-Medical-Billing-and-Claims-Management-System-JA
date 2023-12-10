import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { JwtCompanyService } from 'src/app/services/InsuranceCompanyService/jwt-company.service';

@Component({
  selector: 'app-login-company',
  templateUrl: './login-company.component.html',
  styleUrls: ['./login-company.component.css']
})
export class LoginCompanyComponent {
  constructor(private jwtCompanyService:JwtCompanyService,private router:Router){}


  loginCompany(formData:any)
  {
   

      let username = formData.form.value.name;
      let password = formData.form.value.password;


      this.jwtCompanyService.login(username, password).subscribe(
        (token) => {
        
          sessionStorage.setItem('companyName',username);
          console.log(token);
          this.jwtCompanyService.setToken(token);
          this.router.navigate(['/company/dashboard'])
      
        }
      );
    
   
  }


}
