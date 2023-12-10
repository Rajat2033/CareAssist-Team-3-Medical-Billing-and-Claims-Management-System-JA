import { Component } from '@angular/core';
import { PatientsService } from 'src/app/services/PatientsService/patients.service';

@Component({
  selector: 'app-update-patients',
  templateUrl: './update-patients.component.html',
  styleUrls: ['./update-patients.component.css']
})
export class UpdatePatientsComponent {

  patientId!:number;
  constructor(private patientService:  PatientsService){}

  

  updatePatient(formData:any){
    console.log(formData);

    this.patientService.updatePatient(formData.form.value).subscribe(
      (result) => {
        console.log(result);
        alert(' Patient Data Updated Successfully');
      },
      (error) => {
        console.error(error);
      }
    );
  }

}
