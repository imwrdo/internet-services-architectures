import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditVehicleTypeViewComponent } from './edit-vehicleType-view.component';

describe('EditVehicleTypeViewComponent', () => {
  let component: EditVehicleTypeViewComponent;
  let fixture: ComponentFixture<EditVehicleTypeViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditVehicleTypeViewComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(EditVehicleTypeViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
