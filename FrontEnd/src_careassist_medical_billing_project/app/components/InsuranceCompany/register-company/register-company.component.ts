import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { InsuranceCompanyService } from 'src/app/services/InsuranceCompanyService/insurance-company.service';

@Component({
  selector: 'app-register-company',
  templateUrl: './register-company.component.html',
  styleUrls: ['./register-company.component.css']
})
export class RegisterCompanyComponent implements OnInit {
  maxDate?:string;
  registerCompanyFormsGroup!: FormGroup;
  submitted = false;
  constructor(private companyService: InsuranceCompanyService, private router: Router, private formBuilder: FormBuilder) {

    const today=new Date();
    this.maxDate=today.toISOString().split('T')[0 ];
   }
  ngOnInit(): void {
    this.registerCompanyFormsGroup = this.formBuilder.group({
      companyName: ['', Validators.required],
      companyPassword: ['', [Validators.required, Validators.pattern("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")]],
      companyEmail: ['', [Validators.required, Validators.email]],
      companyContact: ['', Validators.required],
      companyStartYears: ['', Validators.required]
    })

  }

  get f() {
    return this.registerCompanyFormsGroup.controls;
  }
  submitform() {

    this.submitted = true;
    if (this.registerCompanyFormsGroup.valid) {

      const formData = this.registerCompanyFormsGroup.value;

      this.registerInsuranceCompany(formData);
    }
  }
  registerInsuranceCompany(formData: any) {

    formData = this.registerCompanyFormsGroup.value;
    this.companyService.registerCompany(formData).subscribe(
      (response) => {
       alert('Insurance company registered successfully:');
        this.router.navigate(['/login/company']);

      }
    );
  }

}
