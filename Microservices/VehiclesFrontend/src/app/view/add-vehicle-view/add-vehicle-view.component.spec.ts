import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddVehicleViewComponent } from './add-vehicle-view.component';

describe('AddVehicleViewComponent', () => {
  let component: AddVehicleViewComponent;
  let fixture: ComponentFixture<AddVehicleViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddVehicleViewComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(AddVehicleViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
