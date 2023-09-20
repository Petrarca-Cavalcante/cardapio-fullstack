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
      nome: 'Sanduiche gaiteiro',
      preco: '14,99',
      categoria: 'Sanduíche',
      descricao: 'bão dms'
    },
    {
      nome: 'Beirute',
      preco: '14,99',
      categoria: 'Sanduíche',
      descricao: 'bão dms'
    },
    {
      nome: 'Pizza',
      preco: '14,99',
      categoria: 'Pizza',
      descricao: 'bão dms'
    },
    {
      nome: 'Coca-cola',
      preco: '14,99',
      categoria: 'Bebidas',
      descricao: 'bão dms'
    },
    {
      nome: 'Grogue-Express',
      preco: '14,99',
      categoria: 'drinks',
      descricao: 'bão dms'
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
        this.categorias.push(produto.categoria)
      }
    }
  }

}
