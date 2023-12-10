import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateProviderComponent } from './update-provider.component';

describe('UpdateProviderComponent', () => {
  let component: UpdateProviderComponent;
  let fixture: ComponentFixture<UpdateProviderComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateProviderComponent]
    });
    fixture = TestBed.createComponent(UpdateProviderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
