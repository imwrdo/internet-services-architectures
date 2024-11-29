import { Component, OnInit } from '@angular/core';
import { VehicleService } from '../../api/vehicle/service/vehicle.service';
import { VehicleType } from '../../api/vehicleTypes/model/vehicleType';
import { Vehicle } from '../../api/vehicle/model/vehicle';
import { VehicleTypeService } from '../../api/vehicleTypes/service/vehicleType.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ViewTitleComponent } from '../../component/view-title/view-title.component';
import { ErrorMessageComponent } from '../../component/error-message/error-message.component';
import { VehicleFormComponent } from '../../component/vehicle-form/vehicle-form.component';

@Component({
  selector: 'app-edit-vehicle-view',
  standalone: true,
  imports: [ViewTitleComponent, ErrorMessageComponent, VehicleFormComponent],
  templateUrl: './edit-vehicle-view.component.html',
  styleUrl: './edit-vehicle-view.component.css',
})
export class EditVehicleViewComponent implements OnInit {
  constructor(
    private vehicleService: VehicleService,
    private vehicleTypeService: VehicleTypeService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  vehicle: Vehicle | undefined;
  vehicleType: VehicleType | undefined;
  message: string = '';

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.vehicleService.getVehicleById(params['vehicleId']).subscribe({
        next: (vehicle) => {
          this.vehicle = vehicle;
        },
        error: (error) => {
          this.message = error.error.message;
        },
      });
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

  onSubmit(): void {
    this.message = '';
    if (this.vehicle) {
      this.vehicleService.updateVehicle(this.vehicle).subscribe({
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
}
