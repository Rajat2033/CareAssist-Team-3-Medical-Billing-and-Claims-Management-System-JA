import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginCompanyComponent } from './login-company.component';

describe('LoginCompanyComponent', () => {
  let component: LoginCompanyComponent;
  let fixture: ComponentFixture<LoginCompanyComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LoginCompanyComponent]
    });
    fixture = TestBed.createComponent(LoginCompanyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
