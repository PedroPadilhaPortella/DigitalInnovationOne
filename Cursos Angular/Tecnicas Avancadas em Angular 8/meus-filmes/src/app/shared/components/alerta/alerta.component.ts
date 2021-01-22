import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Alerta } from '../../models/alerta';

@Component({
  selector: 'dio-alerta',
  templateUrl: './alerta.component.html'
})
export class AlertaComponent implements OnInit {

    alerta: Alerta = {
        titulo: 'Sucesso!',
        descricao: 'Seu registro foi salvo com Sucesso',
        sucesso: 'OK',
        cancelar: 'Cancelar',
        corBtnSucesso: 'accent',
        corBtnCancelar: 'warn',
        btnFechar: false
    }

    constructor(
        public dialogRef: MatDialogRef<AlertaComponent>,
        @Inject(MAT_DIALOG_DATA) public data: Alerta
    ) {}

    ngOnInit(): void {
    if(this.data) {
        this.alerta.titulo = this.data.titulo || this.alerta.titulo;
        this.alerta.descricao = this.data.descricao || this.alerta.descricao;
        this.alerta.sucesso = this.data.sucesso || this.alerta.sucesso;
        this.alerta.cancelar = this.data.cancelar || this.alerta.cancelar;
        this.alerta.corBtnSucesso = this.data.corBtnSucesso || this.alerta.corBtnSucesso;
        this.alerta.corBtnCancelar = this.data.corBtnCancelar || this.alerta.corBtnCancelar;
        this.alerta.btnFechar = this.data.btnFechar || this.alerta.btnFechar;
    }
    }
}
