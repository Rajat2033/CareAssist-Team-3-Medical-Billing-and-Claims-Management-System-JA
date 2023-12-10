import { Component, OnInit } from '@angular/core';
import { HealthcareProvider } from 'src/app/model/HealthcareProvider';
import { HealthcareProviderService } from 'src/app/services/HealthcareProviderService/healthcare-provider.service';

@Component({
  selector: 'app-get-all-providers',
  templateUrl: './get-all-providers.component.html',
  styleUrls: ['./get-all-providers.component.css']
})
export class GetAllProvidersComponent implements OnInit {

  healthcareProvidersList:HealthcareProvider[] = [];
  constructor(private providerService: HealthcareProviderService){}
  ngOnInit(): void {
    this.providerService.getAllProviders().subscribe(data=>{this.healthcareProvidersList=data;})
  }



 

  deleteProvider(providerId:number)
  {
    this.providerService.deleteProviderById(providerId).subscribe(data=>{alert("Provider Deleted");})
  }
  

}
