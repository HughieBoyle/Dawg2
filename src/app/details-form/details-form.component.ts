import { Component } from '@angular/core';

@Component({
  selector: 'app-details-form',
  templateUrl: './details-form.component.html',
  styleUrls: ['./details-form.component.css']
})
export class DetailsFormComponent {
  option: string = 'somethingElse';
  firstname: string[];
  lastname: string[];
  email: string[];
  tel: string[];

  ilnesses: string[] = ['cancer', 'heart-failure', 'alszheimers', 'HIV', 'diabetes'];
}
