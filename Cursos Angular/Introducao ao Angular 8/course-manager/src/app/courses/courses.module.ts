import { CourseService } from './course.service';
import { SharedModule } from './../shared/shared.module';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseListComponent } from './course-list.component';
import { CourseInfoComponent } from './course-info/course-info.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
    imports: [
        CommonModule,
        HttpClientModule,
        FormsModule,
        RouterModule,
        SharedModule,
    ],
    declarations: [
        CourseListComponent,
        CourseInfoComponent
    ],
    providers: [
        CourseService
    ]
})
export class CoursesModule { }
