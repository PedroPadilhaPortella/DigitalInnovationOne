import { CourseService } from '../course.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Course } from '../course';

@Component({
    selector: 'app-course-info',
    templateUrl: './course-info.component.html'
})
export class CourseInfoComponent implements OnInit {

    course: Course;
    constructor(private activatedRoute: ActivatedRoute, private courseService: CourseService, private router: Router) { }

    ngOnInit() {
        let id = +this.activatedRoute.snapshot.paramMap.get('id');
        this.courseService.retrieveById(id)
            .subscribe({
                next: course => this.course = course,
                error: err => console.error("Error: " + err)
            })
    }

    save(): void {
        this.courseService.save(this.course)
            .subscribe({
                next: () => console.log('Course saved with Success'),
                error: err => alert('Erro' + err)
            })
        this.router.navigate(['courses'])
    }
}
