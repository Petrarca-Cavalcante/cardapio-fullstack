import { Component, TemplateRef } from '@angular/core';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { produto } from './types';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent {

  public produtos: produto[] = [
    {
      nome: 'X-burger',
      valor: '14,99',
      categoria: 'Sanduíche',
      descricao: 'Pão, hambuguer, salame e alface'
    },
    {
      nome: 'Beirute',
      valor: '14,99',
      categoria: 'Sanduíche',
      descricao: 'Pão sírio, ovo, alface, tomate, queijo, presunto'
    },
    {
      nome: 'Pizza',
      valor: '14,99',
      categoria: 'Pizza',
      descricao: 'sample text'
    },
    {
      nome: 'Coca-cola',
      valor: '14,99',
      categoria: 'Bebidas',
      descricao: 'sample text'
    },
    {
      nome: 'Ponche Goiano',
      valor: '14,99',
      categoria: 'Drinks',
      descricao: 'maçã, laranja, morango, calda de abacaxi, vinho tinto, vinho branco e água com gás.'
    },
    {
      nome: "Empadão goiano",
      valor: "12,99",
      categoria: "tortas",
      descricao: "sample text"
    }

  ]

  public categorias: string[] = []

  modalRef?: BsModalRef;
  constructor(private modalService: BsModalService) {
    this.organizarCategorias();
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  organizarCategorias() {
    for (let produto of this.produtos) {
      const findCategory: string | undefined = this.categorias.find(categoria => produto.categoria === categoria)
      if (!findCategory) {
        this.categorias.push(produto.categoria.replace(/(^|\s)([^\s]+)/g, match => match.charAt(0).toUpperCase() + match.slice(1)))
      }
    }
  }

}
