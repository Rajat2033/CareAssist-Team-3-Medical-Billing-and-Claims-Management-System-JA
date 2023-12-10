import { Component, ViewChild, ElementRef, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { jsPDF } from 'jspdf';
import { InvoiceDetails } from 'src/app/model/InvoiceDetails';
import { InvoiceDetailsService } from 'src/app/services/InvoiceDetailsService/invoice-details.service';
@Component({
  selector: 'app-getinvoicepdf',
  templateUrl: './getinvoicepdf.component.html',
  styleUrls: ['./getinvoicepdf.component.css']
})
export class GetinvoicepdfComponent implements OnInit {

  invoiceDetails!:InvoiceDetails;

  @ViewChild('invoice', { static: false }) invoicedata!: ElementRef;
  constructor(private route: ActivatedRoute,private invoiceservice:InvoiceDetailsService) { }

  invoiceId!:number;
  ngOnInit(): void {
    this.route.params.subscribe(params => {
       this.invoiceId = params['invoiceId']; 
      console.log(this.invoiceId);
      this.invoiceservice.getInvoiceById(this.invoiceId).subscribe((data) => {
       
        this.invoiceDetails = data;
        console.log(data);
      });
    });
  }
  
    generatePdf()
    {
      let pdf = new jsPDF('p', 'pt', 'a4');//p=portrait,pt=point,a4=size()
      pdf.html(this.invoicedata.nativeElement, { callback: (pdf) => { pdf.save('invoice.pdf'); } });
    }
  


}

