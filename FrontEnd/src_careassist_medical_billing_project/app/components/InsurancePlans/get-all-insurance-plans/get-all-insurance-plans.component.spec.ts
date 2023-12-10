import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllInsurancePlansComponent } from './get-all-insurance-plans.component';

describe('GetAllInsurancePlansComponent', () => {
  let component: GetAllInsurancePlansComponent;
  let fixture: ComponentFixture<GetAllInsurancePlansComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GetAllInsurancePlansComponent]
    });
    fixture = TestBed.createComponent(GetAllInsurancePlansComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
