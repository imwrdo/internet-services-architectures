import { Component, OnInit } from '@angular/core';
import { ViewTitleComponent } from '../../component/view-title/view-title.component';
import { VehicleTypeService } from '../../api/vehicleTypes/service/vehicleType.service';
import { VehicleType } from '../../api/vehicleTypes/model/vehicleType';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { VehicleTypeFormComponent } from '../../component/vehicleType-form/vehicleType-form.component';
import { ErrorMessageComponent } from '../../component/error-message/error-message.component';

@Component({
  selector: 'app-add-vehicleType-view',
  standalone: true,
  imports: [ViewTitleComponent, VehicleTypeFormComponent, ErrorMessageComponent],
  templateUrl: './edit-vehicleType-view.component.html',
  styleUrl: './edit-vehicleType-view.component.css',
})
export class EditVehicleTypeViewComponent implements OnInit {
  constructor(
    private vehicleTypeService: VehicleTypeService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  vehicleType: VehicleType | undefined;
  message: string = '';

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.vehicleTypeService.getVehicleTypeById(params['id']).subscribe({
        next: (vehicleType: VehicleType) => {
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
    if (this.vehicleType === undefined) {
      return;
    }
    this.vehicleTypeService.updateVehicleType(this.vehicleType).subscribe({
      next: (vehicleType: VehicleType) => {
        this.router.navigate(['/vehicleTypes', vehicleType.id]);
      },
      error: (error) => {
        this.message = error.error.message;
      },
    });
  }
}
