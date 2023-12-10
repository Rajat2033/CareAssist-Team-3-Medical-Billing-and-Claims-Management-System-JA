import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PatientsService } from 'src/app/services/PatientsService/patients.service';

@Component({
  selector: 'app-register-patients',
  templateUrl: './register-patients.component.html',
  styleUrls: ['./register-patients.component.css']
})
export class RegisterPatientsComponent implements OnInit {
 maxDate?:string;
  submitted = false;
  registerPatientFormsGroup!: FormGroup;

  constructor(private formBuilder: FormBuilder,private patientService:PatientsService,private router:Router) { 

    const today=new Date();
    this.maxDate=today.toISOString().split('T')[0 ]
  }
  ngOnInit(): void {
    this.registerPatientFormsGroup = this.formBuilder.group({

      patientName:['',Validators.required],
      patientEmail:['',[Validators.required,Validators.email]],
      patientPassword:['',[Validators.required,Validators.pattern("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")]],
      patientDOB:['',Validators.required],
      patientGender:['',Validators.required],
      patientContact:['',Validators.required],
      patientAddress:['',Validators.required],
      patientDisease:['',Validators.required]

     

    })
    
  }

  get f(){
    return this.registerPatientFormsGroup.controls;
  }

  submitform() {

    this.submitted = true;
    if (this.registerPatientFormsGroup.valid) {

      const formData = this.registerPatientFormsGroup.value;

      this.registerPatient(formData);
    }
  }
  registerPatient(formData: any) {

    formData = this.registerPatientFormsGroup.value;
    this.patientService.registerPatients(formData).subscribe(
      (response) => {
        alert('Patient Has registered successfully:');
        this.router.navigate(['/login/patient']);

      }
    );
  }

}
