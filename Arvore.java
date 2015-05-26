class Arvore{

	Nodo raiz;
	
	public Arvore(int k){
		raiz = new Nodo(k);
	}
	
	public void add(int k){
		Nodo aux = raiz.busca(k);
		if(k > aux.info) addFix(aux.dir = new Nodo(k, aux));
		if(k < aux.info) addFix(aux.esq = new Nodo(k, aux));
	}
	
	public void left_rotate(Nodo x){
		Nodo y = x.dir;
		x.dir = y.esq;
		if(y.esq != null) y.esq.pai = x;
		y.pai = x.pai;
		if(x.pai == null) raiz = y;
		else if(x == x.pai.esq) x.pai.esq = y;
		else x.pai.dir = y;
		y.esq = x;
		x.pai = y;	
	}
	
	public void right_rotate(Nodo x){
		Nodo y = x.esq;
		x.esq = y.dir;
		if(y.dir != null) y.dir.pai = x;
		y.pai = x.pai;
		if(x.pai == null) raiz = y;
		else if(x == x.pai.dir) x.pai.dir = y;
		else x.pai.esq = y;
		y.dir = x;
		x.pai = y;	
	}

	public void addFix(Nodo z){
		Nodo y;
		while(z.pai != null && z.pai.cor){
			if(z.pai == z.pai.pai.esq){
				y = z.pai.pai.dir;
				if(y.cor){
					z.pai.cor = false;
					y.cor = false;
					z.pai.pai.cor = true;
					z = z.pai.pai;
				} else {
					if(z == z.pai.dir){
						z = z.pai;
						left_rotate(z);
					}
					z.pai.cor = false;
					z.pai.pai.cor = true;
					right_rotate(z.pai.pai);
				}
			} else {
				y = z.pai.pai.esq;
				if(y.cor){
					z.pai.cor = false;
					y.cor = false;
					z.pai.pai.cor = true;
					z = z.pai.pai;
				} else {
					if(z == z.pai.esq){
						z = z.pai;
						right_rotate(z);
					}
					z.pai.cor = false;
					z.pai.pai.cor = true;
					left_rotate(z.pai.pai);
				}
			}			
		}
		raiz.cor = false;		
	}
	
	
	
	
}
