  import { Component, TemplateRef } from '@angular/core';
  import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
  import { produto } from './types';
  import { HttpClient } from '@angular/common/http';


  @Component({
    selector: 'app-menu',
    templateUrl: './menu.component.html',
    styleUrls: ['./menu.component.scss']
  })
  export class MenuComponent {

    constructor(private http: HttpClient, private modalService: BsModalService) { }

    public produtos: produto[] = []
    public categorias: string[] = []


    ngOnInit(): void {
      this.getProdutos()

    }

    public getProdutos(): void {
      this.http.get<produto[]>("http://localhost:8080/produto").subscribe(
        response => {
          this.produtos = response
          this.organizarCategorias()
        },
        error => console.error(error)
        )
    }

    organizarCategorias() {
      for (let produto of this.produtos) {
        const findCategory: string | undefined= this.categorias.find(categoria => produto.categoria === categoria)
        if (!findCategory) {
          this.categorias.push(produto.categoria)
        }
      }
      for (let i = 0; i < this.categorias.length; i++) {
        this.categorias[i] = this.categorias[i].charAt(0).toUpperCase() + this.categorias[i].slice(1).toLowerCase();
      }
    }

    modalRef?: BsModalRef;

    openModal(template: TemplateRef<any>) {
      this.modalRef = this.modalService.show(template);
    }

  }
