import { Error404Component } from './components/error-404/error-404.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { RouterModule } from '@angular/router';

@NgModule({
    imports: [
        CommonModule,
        RouterModule
    ],
    declarations: [
        NavBarComponent,
        Error404Component
    ],
    exports: [
        NavBarComponent
    ]
})
export class CoreModule { }
