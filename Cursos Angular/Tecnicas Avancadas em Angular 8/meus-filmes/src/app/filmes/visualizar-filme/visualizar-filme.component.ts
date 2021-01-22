import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { AlertaComponent } from 'src/app/shared/components/alerta/alerta.component';
import { Alerta } from 'src/app/shared/models/alerta';
import { Filme } from 'src/app/shared/models/filme';
import { FilmesService } from './../../core/filmes.service';

@Component({
    selector: 'dio-visualizar-filme',
    templateUrl: './visualizar-filme.component.html',
    styleUrls: ['./visualizar-filme.component.css']
})
export class VisualizarFilmeComponent implements OnInit {

    filme: Filme;
    id: number;
    readonly semFoto = '/assets/images/no-image.jpg';

    constructor(
        private activatedRoute: ActivatedRoute, 
        private filmesService: FilmesService,
        private dialog: MatDialog,
        private router: Router
    ) { }

    ngOnInit() {
        this.id = this.activatedRoute.snapshot.params['id'];
        this.visualizar();
    }

    editar() {
        this.router.navigate([`/filmes/cadastro/${this.id}`]);
    }

    excluir() {
        this.openDialog();
    }

    private visualizar(): void {
        this.filmesService.visualizar(this.id)
            .subscribe((filme: Filme) => this.filme = filme);
    }

    private openDialog() {
        const dialogConfig = new MatDialogConfig();
        dialogConfig.data = { 
            titulo: "Tem certeza que deseja excluir?",
            corBtnSucesso: 'warn',
            corBtnCancelar: 'primary',
            descricao: 'Caso você tenha certeza que deseja excluir, clique em OK', 
            btnFechar: true
        } as Alerta;

        const dialogRef = this.dialog.open(AlertaComponent, dialogConfig);

        dialogRef.afterClosed().subscribe((opcao: boolean) => {
            if(opcao) 
                this.filmesService.excluir(this.id).subscribe(
                    () => this.router.navigate(['/filmes'])
                );
        })
    }

}
