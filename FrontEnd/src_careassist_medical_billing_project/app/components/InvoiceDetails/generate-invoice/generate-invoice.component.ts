import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { InvoiceDetailsService } from 'src/app/services/InvoiceDetailsService/invoice-details.service';

@Component({
  selector: 'app-generate-invoice',
  templateUrl: './generate-invoice.component.html',
  styleUrls: ['./generate-invoice.component.css']
})
export class GenerateInvoiceComponent {
  patientId!: number;
  invoiceForm!: FormGroup;

  constructor(
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private invoiceService: InvoiceDetailsService // Update the path
  ) {
    this.route.params.subscribe(params => {
      this.patientId = +params['patientId'];
    });

    this.invoiceForm = this.formBuilder.group({

      invoiceDate:['',Validators.required],
      invoiceDueDate:['',Validators.required],
      invoiceTax:['',Validators.required],
      consultationFee:['',Validators.required],
      diagnosticTestsFee:['',Validators.required],
      diagnosticScanFee:['',Validators.required],
      invoiceTotalAmount:['',Validators.required],
      totalBillAmount:['',Validators.required]

    
    });
  }

  onSubmit() {
    if (this.invoiceForm.valid) {
      const invoiceDetails = this.invoiceForm.value;

      // Call the service method to generate the invoice
      this.invoiceService.createNewInvoice(invoiceDetails,this.patientId)
        .subscribe(
          (result) => {
           
            console.log('Invoice generated successfully:', result);
            alert('Invoice generated successfully');
           
          },
          (error) => {
            // Handle error
            console.error('Error generating invoice:', error);
          }
        );
    }
  }
}
