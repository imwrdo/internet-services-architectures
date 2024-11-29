import { Component, OnInit } from '@angular/core';
import { VehicleTypeService } from '../../api/vehicleTypes/service/vehicleType.service';
import { VehicleService } from '../../api/vehicle/service/vehicle.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ViewTitleComponent } from '../../component/view-title/view-title.component';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { ErrorMessageComponent } from '../../component/error-message/error-message.component';
import { Vehicle } from '../../api/vehicle/model/vehicle';
import { VehicleType } from '../../api/vehicleTypes/model/vehicleType';
import { VehicleFormComponent } from '../../component/vehicle-form/vehicle-form.component';

@Component({
  selector: 'app-add-vehicle-view',
  standalone: true,
  imports: [
    ViewTitleComponent,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    ErrorMessageComponent,
    VehicleFormComponent,
  ],
  templateUrl: './add-vehicle-view.component.html',
  styleUrl: './add-vehicle-view.component.css',
})
export class AddVehicleViewComponent implements OnInit {
  constructor(
    private vehicleTypeService: VehicleTypeService,
    private vehicleService: VehicleService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  message: string = '';
  vehicleType: VehicleType | undefined;

  ngOnInit() {
    this.route.params.subscribe((params) => {
      this.vehicleTypeService.getVehicleTypeById(params['vehicleTypeId']).subscribe({
        next: (vehicleType) => {
          this.vehicleType = vehicleType;
        },
        error: (error) => {
          this.message = error.error.message;
        },
      });
    });
  }

  onSubmit(vehicle: Vehicle): void {
    this.message = '';
    if (!this.vehicleType) {
      return;
    }
    this.vehicleService.createVehicle(vehicle, this.vehicleType.id).subscribe({
      next: (vehicle) => {
        this.router.navigate([
          '/vehicleTypes',
          this.vehicleType?.id,
          'vehicles',
          vehicle.id,
        ]);
      },
      error: (error) => {
        this.message = error.error.message;
      },
    });
  }
}
