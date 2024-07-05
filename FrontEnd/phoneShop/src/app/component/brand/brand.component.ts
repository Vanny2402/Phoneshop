import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { BrandService } from '../../service/brand.service';

@Component({
  selector: 'app-brand',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './brand.component.html',
  styleUrls: ['./brand.component.css']  // Change styleUrl to styleUrls
})
export class BrandComponent implements OnInit {
  form!: FormGroup;
  brands! : any[];


  constructor(private fb: FormBuilder,private brandService : BrandService) {}
  
  ngOnInit(): void {
    this.form = this.fb.group({
      name: ['']
    });
    this.getAllBrands();
  }

  createBrand() {
    this.brandService.saveBrand(this.form.value).subscribe((t)=> {
      console.log(t);
    });
  }
  getAllBrands(){
    this.brandService.getBrands().subscribe((t)=>{
      console.log(t)
      this.brands=t.list;
    });
  }

}
