package listasEncadeadas;

public class NodoListaDuplamenteEncadeada<T extends Comparable <T>> extends NodoListaEncadeada {
	private NodoListaDuplamenteEncadeada<T> anterior;

	public NodoListaDuplamenteEncadeada(T chave) {
		super(chave);
		this.anterior = null;
	}

	public NodoListaDuplamenteEncadeada() {
		super(null);
		this.anterior = null;
	}

	public NodoListaDuplamenteEncadeada<T> getAnterior() {
		return anterior;
	}
	public void setAnterior(NodoListaDuplamenteEncadeada<T> anterior) {
		this.anterior = anterior;
	}

	public NodoListaDuplamenteEncadeada<T> getProximo() {
		return (NodoListaDuplamenteEncadeada<T>)this.proximo;
	}
}
