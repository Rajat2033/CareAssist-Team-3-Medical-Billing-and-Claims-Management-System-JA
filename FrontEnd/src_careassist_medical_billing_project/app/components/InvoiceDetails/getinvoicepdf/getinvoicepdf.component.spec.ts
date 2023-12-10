import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetinvoicepdfComponent } from './getinvoicepdf.component';

describe('GetinvoicepdfComponent', () => {
  let component: GetinvoicepdfComponent;
  let fixture: ComponentFixture<GetinvoicepdfComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GetinvoicepdfComponent]
    });
    fixture = TestBed.createComponent(GetinvoicepdfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
