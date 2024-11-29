import { Component, EventEmitter, Input, Output } from '@angular/core';
import { VehicleType } from '../../api/vehicleTypes/model/vehicleType';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ErrorMessageComponent } from '../error-message/error-message.component';

@Component({
  selector: 'app-vehicleType-form',
  standalone: true,
  imports: [
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    ErrorMessageComponent,
  ],
  templateUrl: './vehicleType-form.component.html',
  styleUrl: './vehicleType-form.component.css',
})
export class VehicleTypeFormComponent {
  @Input() vehicleType: VehicleType = {
    id: '',
    name: '',
    yearOfInvention: 0,
  };
  @Output() submit = new EventEmitter<VehicleType>();
  @Input() message: string = '';

  onSubmit(): void {
    if (this.vehicleType) {
      this.submit.emit(this.vehicleType);
    }
  }
}
