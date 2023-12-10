import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginPatientComponent } from './login-patient.component';

describe('LoginPatientComponent', () => {
  let component: LoginPatientComponent;
  let fixture: ComponentFixture<LoginPatientComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LoginPatientComponent]
    });
    fixture = TestBed.createComponent(LoginPatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
