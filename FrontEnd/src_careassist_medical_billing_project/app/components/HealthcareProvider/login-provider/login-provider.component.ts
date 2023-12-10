import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { JwtProviderService } from 'src/app/services/HealthcareProviderService/jwt-provider.service';

@Component({
  selector: 'app-login-provider',
  templateUrl: './login-provider.component.html',
  styleUrls: ['./login-provider.component.css']
})
export class LoginProviderComponent {
  constructor(private jwtProviderService:JwtProviderService,private router:Router){}


  loginProvider(formData:any)
  {
   

      let username = formData.form.value.name;
      let password = formData.form.value.password;


      this.jwtProviderService.login(username, password).subscribe(
        (token) => {
        

          sessionStorage.setItem('providerName',username);
          console.log(token);
          this.jwtProviderService.setToken(token);
          this.router.navigate(['/provider/dashboard'])
      
        }
      );
    
   
  }
 
}