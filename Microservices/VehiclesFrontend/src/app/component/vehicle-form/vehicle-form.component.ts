import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ErrorMessageComponent } from '../error-message/error-message.component';
import { Vehicle } from '../../api/vehicle/model/vehicle';

@Component({
  selector: 'app-vehicle-form',
  standalone: true,
  imports: [
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    ErrorMessageComponent,
  ],
  templateUrl: './vehicle-form.component.html',
  styleUrl: './vehicle-form.component.css',
})
export class VehicleFormComponent {
  @Input() vehicle: Vehicle = {
    id: '',
    brand: '',
    yearOfManufacture: 0,
  };
  @Output() submit = new EventEmitter<Vehicle>();
  @Input() message: string = '';

  onSubmit(): void {
    if (this.vehicle) {
      this.submit.emit(this.vehicle);
    }
  }
}
