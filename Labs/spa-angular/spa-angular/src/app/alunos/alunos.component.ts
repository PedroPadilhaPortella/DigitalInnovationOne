import { Component, Input } from '@angular/core';

@Component({
    selector: 'spa-alunos',
    templateUrl: './alunos.component.html',
    styleUrls: ['./alunos.component.css']
})
export class AlunosComponent {

    @Input() valorInicial: number = 10;

}
