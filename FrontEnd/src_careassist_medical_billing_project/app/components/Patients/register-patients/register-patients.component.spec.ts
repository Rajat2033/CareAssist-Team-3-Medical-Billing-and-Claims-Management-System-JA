import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterPatientsComponent } from './register-patients.component';

describe('RegisterPatientsComponent', () => {
  let component: RegisterPatientsComponent;
  let fixture: ComponentFixture<RegisterPatientsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegisterPatientsComponent]
    });
    fixture = TestBed.createComponent(RegisterPatientsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
