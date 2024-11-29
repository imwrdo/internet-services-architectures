import { Component } from '@angular/core';
import { ViewTitleComponent } from '../../component/view-title/view-title.component';
import { VehicleTypeService } from '../../api/vehicleTypes/service/vehicleType.service';
import { VehicleType } from '../../api/vehicleTypes/model/vehicleType';
import { ErrorMessageComponent } from '../../component/error-message/error-message.component';
import { Router } from '@angular/router';
import { VehicleTypeFormComponent } from '../../component/vehicleType-form/vehicleType-form.component';

@Component({
  selector: 'app-add-vehicleType-view',
  standalone: true,
  imports: [ViewTitleComponent, ErrorMessageComponent, VehicleTypeFormComponent],
  templateUrl: './add-vehicleType-view.component.html',
  styleUrl: './add-vehicleType-view.component.css',
})
export class AddVehicleTypeViewComponent {
  constructor(
    private vehicleTypeService: VehicleTypeService,
    private router: Router
  ) {}

  message: string = '';

  onSubmit(vehicleType: VehicleType): void {
    this.message = '';
    this.vehicleTypeService.createVehicleType(vehicleType).subscribe({
      next: (vehicleType: VehicleType) => {
        this.router.navigate(['/vehicleTypes', vehicleType.id]);
      },
      error: (error) => {
        this.message = error.error.message;
      },
    });
  }
}
