import { FormGroup, FormBuilder } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { debounceTime } from 'rxjs/operators';
import { FilmesService } from './../../core/filmes.service';
import { Filme } from 'src/app/shared/models/filme';
import { ConfigParams } from 'src/app/shared/models/configParams';
import { Router } from '@angular/router';

@Component({
    selector: 'dio-listagem-filmes',
    templateUrl: './listagem-filmes.component.html',
    styleUrls: ['./listagem-filmes.component.scss']
})
export class ListagemFilmesComponent implements OnInit {
    
    filmes: Filme[] = []
    filtrosListagem: FormGroup;
    generos: Array<string>;
    readonly semFoto = '/assets/images/no-image.jpg';
    config: ConfigParams = {
        pagina: 0,
        limite: 8
    }

    constructor(
        private filmesService: FilmesService, 
        private fb: FormBuilder, 
        private router: Router
    ) { }

    ngOnInit(): void {
        this.filtrosListagem = this.fb.group({
            texto: [''],
            genero: ['']
        })

        this.filtrosListagem.get('texto').valueChanges
            .pipe(debounceTime(400))
            .subscribe((val: string) => {
                this.config.pesquisa = val;
                this.resetarConsulta();
        })
        
        this.filtrosListagem.get('genero').valueChanges.subscribe((val: string) => {
            this.config.campo = { tipo: 'genero', valor: val };
            this.resetarConsulta();
        })

        this.generos = ['Ação', 'Romance', 'Aventura', 'Terror', 'Ficção Científica', 'Comédia', 'Anime', 'Drama'];
        
        this.listarFilmes();

    }
    
    onScroll(): void {
        this.listarFilmes();
    }
    
    detalhes(id: number):void {
        this.router.navigate([`/filmes/${id}`]);
    }

    private listarFilmes(): void {
        this.config.pagina++;
        this.filmesService.listar(this.config)
            .subscribe((filmes: Filme[]) => this.filmes.push( ...filmes ))
    }

    private resetarConsulta(): void {
        this.config.pagina = 0;
        this.filmes = []
        this.listarFilmes();
    }
}
