import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {UbigeoService} from "./ubigeo.service";
import {switchMap, tap} from "rxjs/operators";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent implements OnInit{

  miFormulario: FormGroup = this.fb.group({
    departamento  : ['', Validators.required ],
    provincia    : ['', Validators.required ],
    distrito: ['', Validators.required ]
  })

  // LLenar combos
  departamentos: string[] = [];
  provincias: string[] = [];
  distritos: any[] = [];
  departamento: string = "";


  // UI
  cargando: boolean = false;

  constructor( private fb: FormBuilder,
               private ubigeoService: UbigeoService ) { }

  ngOnInit() {
    this.ubigeoService.departamentos()
      .subscribe(de => this.departamentos = de );


    // Al seleccionar un departamento
    this.miFormulario.get('departamento')?.valueChanges
      .pipe(
        tap( ( _ ) => {
          this.miFormulario.get('provincia')?.reset('');
          this.cargando = true;
        }),
        switchMap( departamento => {
          this.departamento = departamento;
          return this.ubigeoService.provincias( departamento )
        })
      )
      .subscribe( provincias => {
        this.provincias = provincias;
        this.cargando = false;
      });

    // Al seleccionar una provincia
    this.miFormulario.get('provincia')?.valueChanges
      .pipe(
        tap( ( _ ) => {
          this.miFormulario.get('distrito')?.reset('');
          this.cargando = true;
        }),
        switchMap( provincia => this.ubigeoService.distritos(this.departamento, provincia))
      )
      .subscribe( distritos => {
        this.distritos = distritos;
        this.cargando = false;
      });

  }

  guardar() {
    console.log(this.miFormulario.value);
  }

}
