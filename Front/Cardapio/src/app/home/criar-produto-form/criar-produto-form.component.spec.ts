import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CriarProdutoFormComponent } from './criar-produto-form.component';

describe('CriarProdutoFormComponent', () => {
  let component: CriarProdutoFormComponent;
  let fixture: ComponentFixture<CriarProdutoFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CriarProdutoFormComponent]
    });
    fixture = TestBed.createComponent(CriarProdutoFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
