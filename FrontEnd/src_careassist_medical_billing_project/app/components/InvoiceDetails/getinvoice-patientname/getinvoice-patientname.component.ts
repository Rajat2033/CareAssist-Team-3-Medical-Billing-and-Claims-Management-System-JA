import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { InvoiceDetails } from 'src/app/model/InvoiceDetails';
import { InvoiceDetailsService } from 'src/app/services/InvoiceDetailsService/invoice-details.service';

@Component({
  selector: 'app-getinvoice-patientname',
  templateUrl: './getinvoice-patientname.component.html',
  styleUrls: ['./getinvoice-patientname.component.css']
})
export class GetinvoicePatientnameComponent implements OnInit{
patientName!:any;
invoicesList:InvoiceDetails[]=[];
status=false;
  constructor(private invoiceService: InvoiceDetailsService,private router:Router){

    this.patientName=sessionStorage.getItem('patientName');
  }
  ngOnInit(): void {
    this.invoiceService.getInvoicesByPatientName(this.patientName).subscribe(
      (data) => {
        this.invoicesList= data;
      },
      (error) => {
        console.error('Error fetching invoices:', error);
      }
    );
  }
  getInvoice(invoiceId:any)

  {
    console.log(invoiceId);
   this.router.navigate(['/getpdf/',invoiceId]);
  }
 
  

}
