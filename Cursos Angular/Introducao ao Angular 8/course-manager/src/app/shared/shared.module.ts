import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReplacePipe } from './pipe/replace.pipe';
import { StarsComponent } from './components/stars/stars.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@NgModule({
    imports: [
        CommonModule,
        HttpClientModule,
        FormsModule,
        RouterModule,
    ],
    declarations: [
        ReplacePipe,
        StarsComponent,
    ],
    exports: [
        ReplacePipe,
        StarsComponent
    ]
})
export class SharedModule { }
