import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MenuComponent } from 'src/app/menu/menu.component';
import { produto } from 'src/app/menu/types';

@Component({
  selector: 'app-criar-produto-form',
  templateUrl: './criar-produto-form.component.html',
  styleUrls: ['./criar-produto-form.component.scss']
})
export class CriarProdutoFormComponent {
  @Output() submissaoBemSucedida = new EventEmitter<void>();

  form!: FormGroup

  constructor(
    private http: HttpClient,
    private fb: FormBuilder
  ) { }
  get f(): any {
    return this.form.controls
  }

  ngOnInit(): void {
    this.validation()
  }

  public validation(): void {
    this.form = this.fb.group({
      nome: ["", [Validators.required, Validators.maxLength(25)]],
      valor: ["", [Validators.required, Validators.pattern(/^[0-9]+(\.[0-9]{1,2})?$/)]],
      categoria: ["", [Validators.required, Validators.maxLength(15)]],
      descricao: ["", [Validators.maxLength(180)]]
    })
  }

  onSubmit() {
    if (this.form.valid) {
      const formData = this.form.value;
      this.http.post<produto>("http://localhost:8080/produto", formData).subscribe(
        response => {
          console.log('Resposta do servidor:', response);
          this.submissaoBemSucedida.emit()
            
        },
        error => {
          console.error('Erro ao enviar dados para o servidor:', error);
        }
      );
    }
  }
}
