package listasEncadeadas;

public class NodoListaEncadeada <T extends Comparable <T>>{
	
	protected T chave;//identificador
	protected NodoListaEncadeada <T> proximo = null;
	
	// Get e set da chave:
	public T getChave() {
		return chave;
	}

	public void setChave(T chave) {
		this.chave = chave;
	}
	
	// Get e set do proximo: 
	public NodoListaEncadeada<T> getProximo() {
		return proximo;
	}

	public void setProximo(NodoListaEncadeada<T> proximo) {
		this.proximo = proximo;
	}
	// Construtores: 
	
	public NodoListaEncadeada() { 
		this.setChave(null);
		this.setProximo(null);
	}

	public NodoListaEncadeada(T chave) { 
		this.setChave(chave);
		this.setProximo(null);
	}

	public NodoListaEncadeada(T chave, NodoListaEncadeada<T> proximo) {
		this.setChave(chave);
		this.setProximo(proximo);
	}

	public boolean isNull() { 
		return (chave == null);
	}
	
	public boolean equals(Object objeto) { 
		if (objeto == null || this.chave == null) {
			return false;
		}
		if (this == objeto){
			return true;
		}

		@SuppressWarnings("unchecked")
		NodoListaEncadeada<T> aComparar = (NodoListaEncadeada<T>) objeto;

		return this.chave != null && this.chave.equals(aComparar.getChave()); 
		// Retorna a chave igual ao objeto
	}
	
	@Override
	public String toString() {
		if (!this.isNull())
			return this.chave.toString();
		return null;
	}
}
