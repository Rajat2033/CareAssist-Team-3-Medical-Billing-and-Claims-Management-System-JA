import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProviderDashboardComponent } from './provider-dashboard.component';

describe('ProviderDashboardComponent', () => {
  let component: ProviderDashboardComponent;
  let fixture: ComponentFixture<ProviderDashboardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProviderDashboardComponent]
    });
    fixture = TestBed.createComponent(ProviderDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
