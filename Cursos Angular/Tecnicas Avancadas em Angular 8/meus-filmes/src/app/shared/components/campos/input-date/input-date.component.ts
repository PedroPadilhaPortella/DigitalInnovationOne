import { Component, Input, OnInit } from '@angular/core';
import { AbstractControl, FormGroup } from '@angular/forms';
import { ValidarCamposService } from 'src/app/shared/campos/validar-campos.service';

@Component({
    selector: 'dio-input-date',
    templateUrl: './input-date.component.html'
})
export class InputDateComponent {

    @Input() titulo: string;
    @Input() formGroup: FormGroup;
    @Input() controlName: string;

    constructor(public validar: ValidarCamposService) { }

    get formControl(): AbstractControl {
        return this.formGroup.controls[this.controlName];
    }
}
