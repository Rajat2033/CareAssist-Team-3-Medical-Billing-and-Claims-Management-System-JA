import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetpatientforInvoiceComponent } from './getpatientfor-invoice.component';

describe('GetpatientforInvoiceComponent', () => {
  let component: GetpatientforInvoiceComponent;
  let fixture: ComponentFixture<GetpatientforInvoiceComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GetpatientforInvoiceComponent]
    });
    fixture = TestBed.createComponent(GetpatientforInvoiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
