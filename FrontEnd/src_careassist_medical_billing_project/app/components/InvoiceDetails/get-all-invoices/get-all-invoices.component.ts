import { Component, OnInit } from '@angular/core';
import { InvoiceDetails } from 'src/app/model/InvoiceDetails';
import { Patients } from 'src/app/model/Patients';
import { InvoiceDetailsService } from 'src/app/services/InvoiceDetailsService/invoice-details.service';

@Component({
  selector: 'app-get-all-invoices',
  templateUrl: './get-all-invoices.component.html',
  styleUrls: ['./get-all-invoices.component.css']
})
export class GetAllInvoicesComponent implements OnInit {

  invoiceList: InvoiceDetails[] = [];
  patientId: Patients[] = [];


  constructor(private invoiceService: InvoiceDetailsService) { }
  ngOnInit(): void {
    this.invoiceService.getAllInvoicesDetails().subscribe(data => {
      this.invoiceList = data;
      console.log(data);

    }
    );
  }


}
