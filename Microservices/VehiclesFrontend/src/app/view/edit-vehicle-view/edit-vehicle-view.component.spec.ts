import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditVehicleViewComponent } from './edit-vehicle-view.component';

describe('EditVehicleViewComponent', () => {
  let component: EditVehicleViewComponent;
  let fixture: ComponentFixture<EditVehicleViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditVehicleViewComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(EditVehicleViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
