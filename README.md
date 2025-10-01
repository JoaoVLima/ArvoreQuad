# ArvoreQuad
Arvore Quad, uma Arvore Multiway que pode ser usada em varias aplicacoes interessantes.

### To run:
```bash
mvn compile exec:java
```

<img width="1594" height="791" alt="image" src="https://github.com/user-attachments/assets/225cc42c-57de-4c75-96e8-26163810a072" />
<img width="399" height="241" alt="image" src="https://github.com/user-attachments/assets/2e080f28-63e4-4995-9777-5e719b338138" />


### Como usar:
```
ArvoreQuad arvore = new ArvoreQuad(4, 0, 0, 100, 100);
arvore.inserir(10,10);
arvore.inserir(20,20);
arvore.inserir(60,60);
arvore.inserir(70,70);
arvore.inserir(0,50);

arvore.inserir(80,70);
arvore.inserir(80,80);
arvore.inserir(90,90);
arvore.imprimir();

Node a = arvore.buscarNode(70, 70);
a.imprimeln();

a = arvore.remover(60,60);
a.imprimeln();
a = arvore.remover(70,70);
a.imprimeln();
a = arvore.remover(80,70);
a.imprimeln();
a = arvore.remover(80,80);
a.imprimeln();

arvore.imprimir();


a = arvore.remover(90,90);
a.imprimeln();

arvore.imprimir();
```

### Saida do programa
```
N� atual no endere�ocom.limadeveloper.listaencadeada.Node@2f92e0f4
N� atual no endere�ocom.limadeveloper.listaencadeada.Node@65b54208
N� atual no endere�ocom.limadeveloper.listaencadeada.Node@1be6f5c3
Quadrante est� cheio.
Dividir
N� atual no endere�ocom.limadeveloper.listaencadeada.Node@6b884d57
N� atual no endere�ocom.limadeveloper.listaencadeada.Node@38af3868
N� atual no endere�ocom.limadeveloper.listaencadeada.Node@77459877
N� atual no endere�ocom.limadeveloper.listaencadeada.Node@5b2133b1
Quadrante est� cheio.
Dividir
N� atual no endere�ocom.limadeveloper.listaencadeada.Node@72ea2f77
N� atual no endere�ocom.limadeveloper.listaencadeada.Node@33c7353a
Quadrante
	Quadrante
		(0,50) -> (10,10) -> (20,20) -> Null
	Quadrante
		Null
	Quadrante
		Null
	Quadrante
		Quadrante
			(60,60) -> (70,70) -> Null
		Quadrante
			(80,70) -> Null
		Quadrante
			Null
		Quadrante
			(80,80) -> (90,90) -> Null
(70,70)
(70,70)
(60,60)
(80,70)
(90,90)
Quadrante
	Quadrante
		(0,50) -> (10,10) -> (20,20) -> Null
	Quadrante
		Null
	Quadrante
		Null
	Quadrante
		Quadrante
			Null
		Quadrante
			Null
		Quadrante
			Null
		Quadrante
			(80,80) -> Null
(80,80)
Quadrante
	Quadrante
		(0,50) -> (10,10) -> (20,20) -> Null
	Quadrante
		Null
	Quadrante
		Null
	Quadrante
		Null
```
