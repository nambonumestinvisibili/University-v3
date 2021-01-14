import { Component, OnInit, Input } from '@angular/core';
import {Hero} from "../hero";


@Component({
  selector: 'app-her-detail',
  templateUrl: './her-detail.component.html',
  styleUrls: ['./her-detail.component.css']
})
export class HerDetailComponent implements OnInit {

  @Input() hero: Hero = {id: 11, name: "Dawid"};

  constructor() { }

  ngOnInit(): void {
  }

}
