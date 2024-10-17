package conjuntoDinamico;
import listasEncadeadas.ListaDuplamenteEncadeadaImpl;
import listasEncadeadas.ListaEncadeadaIF;
import listasEncadeadas.ListaVaziaException;
import listasEncadeadas.NodoListaDuplamenteEncadeada;

public class MeuConjuntoDinamicoEncadeado implements ConjuntoDinamicoIF<Integer> {

	//lista encadeada
	ListaEncadeadaIF<Integer> meusDados = new ListaDuplamenteEncadeadaImpl<>();

	@Override
	public void inserir(Integer item) {
		meusDados.insert(item);
	}

	@Override
	public Integer remover(Integer item) throws ListaVaziaException {
		if (meusDados.isEmpty()){
			throw new ListaVaziaException();
		}
		return meusDados.remove(item).getChave();
	}

	@Override
	public Integer predecessor(Integer item) throws ConjuntoVazioException {
		if(meusDados.isEmpty()){
			throw new ConjuntoVazioException("O conjunto esta vazio.");
		}
		Integer pred = null;
		NodoListaDuplamenteEncadeada<Integer> atual = ((ListaDuplamenteEncadeadaImpl<Integer>) meusDados).search(item);
		if (atual != null && atual.getAnterior() != null) {
			pred = (Integer) atual.getAnterior().getChave();
		}
		return pred;
	}

	@Override
	public Integer sucessor(Integer item) throws ConjuntoVazioException {
		if(meusDados.isEmpty()){
			throw new ConjuntoVazioException("O conjunto esta vazio.");
		}
		Integer succ = null;
		NodoListaDuplamenteEncadeada<Integer> atual = ((ListaDuplamenteEncadeadaImpl<Integer>) meusDados).search(item);
		if (atual != null && atual.getProximo() != null) {
			succ = (Integer) atual.getProximo().getChave();
		}
		return succ;
	}

	@Override
	public int tamanho() {
		return meusDados.size();
	}

	@Override
	public Integer buscar(Integer item) {
		NodoListaDuplamenteEncadeada<Integer> no = ((ListaDuplamenteEncadeadaImpl<Integer>) meusDados).search(item);
		return no != null ? (Integer) no.getChave() : null;
	}

	@Override
	public Integer minimum() throws ConjuntoVazioException {
		if (meusDados.isEmpty()) {
			throw new ConjuntoVazioException("O conjunto esta vazio.");
		}
		NodoListaDuplamenteEncadeada<Integer> atual = (NodoListaDuplamenteEncadeada<Integer>) ((ListaDuplamenteEncadeadaImpl<Integer>) meusDados).cabeca.getProximo();
		Integer min = (Integer) atual.getChave();

		while (atual != null) {
			if (atual.getChave().compareTo(min) < 0) {
				min = (Integer) atual.getChave();
			}
			atual = (NodoListaDuplamenteEncadeada<Integer>) atual.getProximo();
		}
		return min;
	}

	@Override
	public Integer maximum() throws ConjuntoVazioException{
		if (meusDados.isEmpty()) {
			throw new ConjuntoVazioException("O conjunto esta vazio.");
		}
		NodoListaDuplamenteEncadeada<Integer> atual = (NodoListaDuplamenteEncadeada<Integer>) ((ListaDuplamenteEncadeadaImpl<Integer>) meusDados).cabeca.getProximo();
		Integer max = (Integer) atual.getChave();

		while (atual != null) {
			if (atual.getChave().compareTo(max) > 0) {
				max = (Integer) atual.getChave();
			}
			atual = (NodoListaDuplamenteEncadeada<Integer>) atual.getProximo();
		}
		return max;
	}
}