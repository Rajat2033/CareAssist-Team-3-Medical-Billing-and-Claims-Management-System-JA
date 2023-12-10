import { Component, OnInit } from '@angular/core';
import { InsuranceCompany } from 'src/app/model/InsuranceCompany';
import { InsuranceCompanyService } from 'src/app/services/InsuranceCompanyService/insurance-company.service';

@Component({
  selector: 'app-get-all-companies',
  templateUrl: './get-all-companies.component.html',
  styleUrls: ['./get-all-companies.component.css']
})
export class GetAllCompaniesComponent implements OnInit{

  insuranceCompanyList:InsuranceCompany[] =[];
 
  constructor(private companyService:InsuranceCompanyService){
    
  }
  ngOnInit(): void {
    this.companyService.getAllCompanyData().subscribe(data=>{
      this.insuranceCompanyList = data;
    })
  }

 



  deleteCompany(companyId:number)
  {
    this.companyService.deleteCompanyById(companyId).subscribe(data=>{
   console.log("Company Deleted:"+data)
    })
  }
}
