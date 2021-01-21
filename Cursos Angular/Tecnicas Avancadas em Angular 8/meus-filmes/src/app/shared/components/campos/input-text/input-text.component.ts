import { ValidarCamposService } from './../../../campos/validar-campos.service';
import { Component, Input } from '@angular/core';
import { FormGroup, AbstractControl } from '@angular/forms';

@Component({
    selector: 'dio-input-text',
    templateUrl: './input-text.component.html'
})
export class InputTextComponent {

    @Input() titulo: string;
    @Input() formGroup: FormGroup;
    @Input() controlName: string;

    constructor(public validar: ValidarCamposService) { }

    get formControl(): AbstractControl {
        return this.formGroup.controls[this.controlName];
    }
}