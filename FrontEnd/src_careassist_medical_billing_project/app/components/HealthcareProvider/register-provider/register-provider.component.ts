import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HealthcareProvider } from 'src/app/model/HealthcareProvider';
import { HealthcareProviderService } from 'src/app/services/HealthcareProviderService/healthcare-provider.service';

@Component({
  selector: 'app-register-provider',
  templateUrl: './register-provider.component.html',
  styleUrls: ['./register-provider.component.css']
})
export class RegisterProviderComponent   {


  constructor(private formBuilder: FormBuilder, private providerService: HealthcareProviderService,private router:Router) { 

  
  }




  

  
  registerProvider(formData: any) {

    
    this.providerService.registerHealthcareProvider(formData.form.value).subscribe(
      (response) => {
        alert('Provider registered successfully:');
        this.router.navigate(['/login/provider']);

      }
    );
  }
}

