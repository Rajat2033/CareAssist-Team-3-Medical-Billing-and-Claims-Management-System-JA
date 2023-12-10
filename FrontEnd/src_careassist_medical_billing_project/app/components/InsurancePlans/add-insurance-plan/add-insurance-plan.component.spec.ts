import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddInsurancePlanComponent } from './add-insurance-plan.component';

describe('AddInsurancePlanComponent', () => {
  let component: AddInsurancePlanComponent;
  let fixture: ComponentFixture<AddInsurancePlanComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddInsurancePlanComponent]
    });
    fixture = TestBed.createComponent(AddInsurancePlanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
