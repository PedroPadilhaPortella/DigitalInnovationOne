import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Course } from "./course";

@Injectable({
    providedIn: 'root'
})
export class CourseService {

    private url: string = 'http://localhost:3100/api/courses';
    constructor(private http: HttpClient) {}

    retrieveAll(): Observable<Course[]> {
        return this.http.get<Course[]>(this.url);
    }

    retrieveById(id: number): Observable<Course> {
        return this.http.get<Course>(`${this.url}/${id}`);
    }

    save(course: Course):  Observable<Course> {
        if(course.id) {
            return this.http.put<Course>(`${this.url}/${course.id}`, course);
        } else {
            return this.http.post<Course>(this.url, course);
        }
    }

    deleteById(id: number): Observable<any> {
        return this.http.delete<any>(`${this.url}/${id}`);
    }
}