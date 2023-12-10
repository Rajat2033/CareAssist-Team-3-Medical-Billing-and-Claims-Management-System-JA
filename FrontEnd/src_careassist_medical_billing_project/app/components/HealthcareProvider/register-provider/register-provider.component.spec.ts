import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterProviderComponent } from './register-provider.component';

describe('RegisterProviderComponent', () => {
  let component: RegisterProviderComponent;
  let fixture: ComponentFixture<RegisterProviderComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegisterProviderComponent]
    });
    fixture = TestBed.createComponent(RegisterProviderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
