import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllInsuranceClaimsComponent } from './get-all-insurance-claims.component';

describe('GetAllInsuranceClaimsComponent', () => {
  let component: GetAllInsuranceClaimsComponent;
  let fixture: ComponentFixture<GetAllInsuranceClaimsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GetAllInsuranceClaimsComponent]
    });
    fixture = TestBed.createComponent(GetAllInsuranceClaimsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
