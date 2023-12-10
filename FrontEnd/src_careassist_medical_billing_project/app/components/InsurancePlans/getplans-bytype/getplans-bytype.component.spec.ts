import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetplansBytypeComponent } from './getplans-bytype.component';

describe('GetplansBytypeComponent', () => {
  let component: GetplansBytypeComponent;
  let fixture: ComponentFixture<GetplansBytypeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GetplansBytypeComponent]
    });
    fixture = TestBed.createComponent(GetplansBytypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
