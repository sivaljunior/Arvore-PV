class Nodo{

	int info;
	Nodo pai;
	Nodo esq, dir;
	boolean cor; //true = vermelho, false = preto
	
	public Nodo(int k){
		info = k;
		pai = dir = esq = null;
		cor = false;
	}

	public Nodo(int k, Nodo p){
		this(k);
		pai = p;
		cor = true;
	}
	
	public Nodo minimo(){
		if(esq != null) return esq.minimo();
		return this;
	}
	
	public Nodo busca(int k){
		if(k > info && dir != null) return dir.busca(k);
		if(k < info && esq != null) return esq.busca(k);
		return this;
	}
	
	public void print() {
		System.out.println(this + ": " + this.esq + " <- (" + this.info + " + " + (this.cor ? "V" : "P") + ") -> " + this.dir);
		if (this.esq != null) this.esq.print();
		if (this.dir != null) this.dir.print();
	}
	
	public void cinquenta(Contador counter, int chave, Arvore resultado) {
		if (counter.i >= 50) return;
		if (esq != null) {
			esq.cinquenta(counter, chave, resultado);
		}
		if (this.info > chave && counter.i < 50) {
			resultado.add(info);
			counter.i++;
		}
		if (dir != null) {
			dir.cinquenta(counter, chave, resultado);
		}
	}
	
	public void graph() {
		if (this.cor) {
			System.out.println("\t" + this.info + " [style = filled, fillcolor = red];");
		} else {
			System.out.println("\t" + this.info + " [style = filled, fillcolor = black, fontcolor = white];");
		}
		if (this.esq != null) {
			System.out.println("\t" + this.info + " -> " + this.esq.info + " [label = \" left\"];");
			this.esq.graph();
		} else {
			System.out.println("\t" + this.info + " -> nil [label = \" left\"];");
		}
		if (this.dir != null) {
			System.out.println("\t" + this.info + " -> " + this.dir.info + " [label = \" right\"];");
			this.dir.graph();
		} else {
			System.out.println("\t" + this.info + " -> nil [label = \" right\"];");
		}
	}
	
}
