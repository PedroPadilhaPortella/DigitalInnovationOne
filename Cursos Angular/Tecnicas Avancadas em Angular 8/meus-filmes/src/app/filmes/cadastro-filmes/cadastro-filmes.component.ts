import { AlertaComponent } from './../../shared/components/alerta/alerta.component';
import { Filme } from './../../shared/models/filme';
import { FilmesService } from './../../core/filmes.service';
import { ValidarCamposService } from './../../shared/campos/validar-campos.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { Alerta } from 'src/app/shared/models/alerta';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
    selector: 'dio-cadastro-filmes',
    templateUrl: './cadastro-filmes.component.html'
})
export class CadastroFilmesComponent implements OnInit {

    id: number;
    cadastro: FormGroup;
    generos: Array<string>;

    get f() {
        return this.cadastro.controls;
    }

    constructor(
        public validar: ValidarCamposService, 
        private filmeService: FilmesService,
        private fb: FormBuilder,
        private dialog: MatDialog,
        private router: Router,
        private activatedRoute: ActivatedRoute
    ) { }

    ngOnInit() {
        this.generos = ['Ação', 'Romance', 'Aventura', 'Terror', 'Ficção Científica', 'Comédia', 'Anime', 'Drama'];

        this.id = this.activatedRoute.snapshot.params['id'];

        if (this.id) {
            this.filmeService.visualizar(this.id).subscribe((filme: Filme) => this.criarFormulario(filme))
        } else {
            this.criarFormulario(this.criarFilmeEmBranco());
        }
    }

    afterViewInit() {}
        
    submit(): void {
        this.cadastro.markAllAsTouched();
        if(this.cadastro.invalid) return;
        
        const filme = this.cadastro.getRawValue() as Filme;

        if(this.id) {
            filme.id = this.id;
            this.editar(filme);
        } else {
            this.salvar(filme)
        }
    }
    
    reiniciar(): void {
        this.cadastro.reset();
    }
    
    private salvar(filme: Filme): void {
        this.filmeService.salvar(filme)
        .subscribe(
            () => this.openDialog(),
            () => this.openErrorDialog(),
            );   
    }

    private editar(filme: Filme): void {
        this.filmeService.editar(filme)
        .subscribe(
            () => this.openEditDialog(),
            () => this.openErrorDialog(),
        );
    }
        
    private criarFormulario(filme: Filme): void {
        this.cadastro = this.fb.group({
            titulo: [filme.titulo, 
                [Validators.required, Validators.minLength(2), Validators.maxLength(256)]
            ],
            urlFoto: [filme.urlFoto, 
                [Validators.minLength(10)]
            ],
            dtLancamento: [filme.dtLancamento, 
                [Validators.required]
            ],
            descricao: [filme.descricao],
            nota: [filme.nota, 
                [Validators.required, Validators.min(0), Validators.max(10)]
            ],
            urlIMDb: [filme.urlIMDb, 
                [Validators.minLength(10)]
            ],
            genero: [filme.genero, 
                [Validators.required]
            ]
        });  
    }

    criarFilmeEmBranco(): Filme {
        return {
            id: null,
            titulo: null,
            dtLancamento: null,
            urlFoto: null,
            descricao: null,
            nota: null,
            urlIMDb: null,
            genero: null
        } as Filme;
    }

    openDialog() {
        const dialogConfig = new MatDialogConfig();
        dialogConfig.data = { 
            sucesso: 'Ir para a Listagem', 
            cancelar: 'Cadastrar outro Filme', 
            btnFechar: true 
        } as Alerta;

        const dialogRef = this.dialog.open(AlertaComponent, dialogConfig);
        
        dialogRef.afterClosed().subscribe((opcao: boolean) => {
            if(opcao) {
                this.router.navigateByUrl('filmes');
            }else {
                this.reiniciar();
            }
        })
    }
    
    openEditDialog() {
        const dialogConfig = new MatDialogConfig();
        dialogConfig.data = { 
            titulo: 'Registro atualizado com Sucesso',
            descricao: 'Seu Registro foi atualizado com Sucesso',
            corBtnCancelar: 'primary'
        } as Alerta;
        const dialogRef = this.dialog.open(AlertaComponent, dialogConfig);
        dialogRef.afterClosed().subscribe(() => this.router.navigate(['filmes']))
    }

    openErrorDialog() {
        const dialogConfig = new MatDialogConfig();
        dialogConfig.data = { 
            sucesso: 'Fechar', 
            titulo: 'Erro ao Salvar Registro', 
            descricao: 'Não foi possível salvar o filme, tente novamente mais tarde.', 
            corBtnSucesso: "warn" 
        } as Alerta;
        this.dialog.open(AlertaComponent, dialogConfig);
    }
}