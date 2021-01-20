import { Component, Input, OnChanges } from '@angular/core';

@Component({
    selector: 'stars',
    templateUrl: 'stars.component.html',
    styleUrls: [
        'stars.component.css'
    ]
})
export class StarsComponent implements OnChanges {

    @Input() rating: number = 0;
    starWidth: number;
    constructor() { }

    ngOnChanges(): void {
        this.starWidth = this.rating * 94 / 5;
    }

}
