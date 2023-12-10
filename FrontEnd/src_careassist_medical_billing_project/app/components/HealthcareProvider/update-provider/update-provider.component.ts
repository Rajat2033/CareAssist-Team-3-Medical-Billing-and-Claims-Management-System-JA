import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { HealthcareProviderService } from 'src/app/services/HealthcareProviderService/healthcare-provider.service';

@Component({
  selector: 'app-update-provider',
  templateUrl: './update-provider.component.html',
  styleUrls: ['./update-provider.component.css']
})
export class UpdateProviderComponent {
  constructor(private providerService:  HealthcareProviderService){}

  

  updateProvider(formData:any){
    console.log(formData);

    this.providerService.updateProvider(formData).subscribe(
      (result) => {
        console.log(result);
        alert('Data Updated Successfully');
      },
      (error) => {
        console.error(error);
      }
    );
  }

}
