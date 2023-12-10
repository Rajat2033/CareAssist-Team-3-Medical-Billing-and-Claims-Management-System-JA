import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetinvoicePatientnameComponent } from './getinvoice-patientname.component';

describe('GetinvoicePatientnameComponent', () => {
  let component: GetinvoicePatientnameComponent;
  let fixture: ComponentFixture<GetinvoicePatientnameComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GetinvoicePatientnameComponent]
    });
    fixture = TestBed.createComponent(GetinvoicePatientnameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
