import { SharedModule } from './shared/shared.module';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { CourseListComponent } from './courses/course-list.component';
import { CourseInfoComponent } from './courses/course-info/course-info.component';
import { Error404Component } from './core/components/error-404/error-404.component';
import { CoreModule } from './core/core.module';
import { CoursesModule } from './courses/courses.module';

@NgModule({
    declarations: [
        AppComponent,

    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        FormsModule,
        CoreModule,
        CoursesModule,
        SharedModule,
        RouterModule.forRoot([
            {
                path: '',
                redirectTo: 'courses',
                pathMatch: 'full'
            },
            {
                path: 'courses',
                component: CourseListComponent
            },
            {
                path: 'courses/info/:id',
                component: CourseInfoComponent
            },
            {
                path: '**',
                component: Error404Component
            }
        ]),
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
