import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, pipe, throwError } from 'rxjs';
import { InvoiceDetails } from 'src/app/model/InvoiceDetails';
import { JwtAdminService } from '../AdminService/jwt-admin.service';
import { JwtProviderService } from '../HealthcareProviderService/jwt-provider.service';
import { JwtPatientService } from '../PatientsService/jwt-patient.service';

@Injectable({
  providedIn: 'root'
})
export class InvoiceDetailsService {




  adminURL: string = 'http://localhost:8080/api/v1/invoicedetails';

  invoiceURL: string = "http://localhost:8080/api/v1/invoicedetails"

  constructor(private http: HttpClient, private jwtAdmin: JwtAdminService, private jwtProvider: JwtProviderService, private jwtPatient: JwtPatientService) { }






  getAllInvoicesDetails(): Observable<InvoiceDetails[]> {
    const token = this.jwtAdmin.getToken();

    console.log(token);
    if (token) {
      const tokenString = 'Bearer ' + token;
      const headers = new HttpHeaders().set('Authorization', tokenString);


      console.log(headers);
      return this.http.get<InvoiceDetails[]>(this.adminURL + '/getallinvoices', { headers });
    }
    else {
      return new Observable<InvoiceDetails[]>;
    }

  }




  getInvoiceById(invoiceId: number)
  {
    const token = this.jwtPatient.getToken();

    console.log(token);
    if (token) {
      const tokenString = 'Bearer ' + token;
      const headers = new HttpHeaders().set('Authorization', tokenString);

      return this.http.get<InvoiceDetails>(this.invoiceURL + `/getinvoicebyid/${invoiceId}`,{headers})
        .pipe(
          catchError((error: any) => {
            console.error('Error searching patient:', error);
            return throwError(error); // Re-throw the error to be handled by the caller
          })
        );
    } else {
      // If the token is not available, emit an error
      return throwError('Token not available');
    }
  }


  


  createNewInvoice(invoice: InvoiceDetails, patientId: number): Observable<InvoiceDetails> {
    const token = this.jwtProvider.getToken();

    console.log(token);
    if (token) {
      const tokenString = 'Bearer ' + token;
      const headers = new HttpHeaders().set('Authorization', tokenString);

      return this.http.post<InvoiceDetails>(this.invoiceURL + `/add/newinvoice/${patientId}`, invoice, { headers })
        .pipe(
          catchError((error: any) => {
            console.error('Error adding claim:', error);
            return throwError(error); // Re-throw the error to be handled by the caller
          })
        );
    } else {
      // If the token is not available, emit an error
      return throwError('Token not available');
    }
  }


  




  getInvoicesByPatientName(patientName: string): Observable<InvoiceDetails[]> {
    const token = this.jwtPatient.getToken();

    console.log(token);
    if (token) {
      const tokenString = 'Bearer ' + token;
      const headers = new HttpHeaders().set('Authorization', tokenString);

      return this.http.get<InvoiceDetails[]>(this.invoiceURL + `/invoicebypatientname/${patientName}`,{headers})
        .pipe(
          catchError((error: any) => {
            console.error('Error searching patient:', error);
            return throwError(error); // Re-throw the error to be handled by the caller
          })
        );
    } else {
      // If the token is not available, emit an error
      return throwError('Token not available');
    }

  }

}

