import { BovineDetailsComponent } from './../bovine-details/bovine-details.component';
import { BovineListComponent } from './../bovine-list/bovine-list.component';
import { Component, OnInit } from '@angular/core';
import { Bovine } from '../bovine';
import { BovineService } from '../bovine-service.service';
import { FormGroup, FormControl, NgForm } from '@angular/forms';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';



@Component({
  selector: 'app-search-bovine',
  templateUrl: './search-bovine.component.html',
  styleUrls: ['./search-bovine.component.css']
})
export class SearchBovineComponent implements OnInit {

  searchForm: FormGroup;
  searchCriteria: SearchBovinesForm;
   id: number;
   bovine: Observable<Bovine[]>;
  submitted: boolean;
  tagNumber: string;

  constructor(private dataService: BovineService, private router: Router) { }

  ngOnInit(): void {
    const resp = this.dataService.getAllBovine();
    resp.subscribe((data) => this.bovine = data);
  }

// getBovineByTagNumber(): void {
//     const search: SearchBovinesForm = {
//       id: this.searchForm.controls.id.value,
//       movedFrom: this.searchForm.controls.movedFrom.value,
//       movedTo: this.searchForm.controls.movedTo.value,
//       thirdParty: this.searchForm.controls.thirdParty.value,
//       tagNumber: this.searchForm.controls.tagNumber.value,
//       healthCertNo: this.searchForm.controls.healthCertNo.value,
//       // fromDate: this.searchForm.controls.fromDate.value,
//       // toDate: this.searchForm.controls.toDate.value,
//       provinceMovementSystem: this.searchForm.controls.provinceMovementSystem.value
//     };
//     this.searchCriteria = search;
//   }

  // searchBovine() {
  //   this.dataService.getBovineByTagNumber(this.searchForm.controls.tagNumber.value)
  //     .subscribe(bovine => this.bovine = bovine);
  // }
  // searchBovine() {
  //   this.dataService.findBytagNumber(this.tagNumber)
  //     .subscribe(bovine => this.bovine = bovine);
  // }
  // searchBovine() {
  //   this.dataService.getBovineById(this.id)
  //     // .subscribe(data => console.log(data), error => console.log(error))
  //     .subscribe(bovine => this.bovine = bovine);
  //   // this.bovine = this.dataService.getBovinesList();
  //   // this.gotoList();
  // }
  // gotoList() {
  //   this.router.navigate(['/bovine']);
  // }
  // onSubmit() {
  //   this.submitted = true;
  //   this.searchBovine();
  // }
  onSubmit() {
    const resp = this.dataService.getAllBovine();
    resp.subscribe((data) => this.bovine = data);
    this.gotoList();
}
  gotoList() {
    this.router.navigate(['/bovine']);
  }
}
export class SearchBovinesForm {
  id: number;
  movedFrom: string;
  movedTo: string;
  thirdParty: string;
  tagNumber: string;
  healthCertNo: string;
  // fromDate: Date;
  // toDate: Date;
  provinceMovementSystem: string;
}

