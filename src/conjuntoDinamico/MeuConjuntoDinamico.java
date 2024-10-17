package conjuntoDinamico;
import listasEncadeadas.ListaVaziaException;

public class MeuConjuntoDinamico implements ConjuntoDinamicoIF<Integer> {
	
	private Integer [] meusDados; // Array com os dados
	private int numInsercao = 0; // posição de inserção

	public MeuConjuntoDinamico(){ // Construtor da classe
		meusDados = new Integer[10];
		numInsercao = 0;
	}
	
	@Override
	public void inserir(Integer item) { // Para inserir elementos
		if (arrayEstaCheio()) { 
			meusDados = aumentarArray(); 
		}
		meusDados[numInsercao] = item; // insere item na posição de inserção
		numInsercao++; // Vai para a próxima posição
	}

	private boolean arrayEstaCheio() { // Verifica se array está cheio
		return numInsercao == meusDados.length;
    }

	private Integer[] aumentarArray() { // Aumenta o tamanho do array
		Integer[] arrayMaior = new Integer[numInsercao * 2]; // Cria um array maior (arrayMaior)
		for (int i = 0; i < meusDados.length; i++){ // Copia os dados de meusDados (array cheio)
			arrayMaior[i] = meusDados[i]; // Adiciona os dados no novo array (arrayMaior)
		}
		return arrayMaior;
	}
	
	@Override
	public Integer remover(Integer item) throws ConjuntoVazioException { // Remove item
		if (numInsercao == 0) { // Verifica se posição atual do array está vazia
			throw new ConjuntoVazioException("O conjunto está vazio.");
		}
		Integer temp = null;
		boolean existe = false;

		for (int i = 0; i < numInsercao; i++){ 
			if (meusDados[i].equals(item)){ // Verifica se a posição atual do array contem o item a ser removido
				temp = meusDados[i];
				meusDados[i] = null; // Remove o item
				existe = true;
				for (int j = i; j < numInsercao; j++){
					meusDados[j] = meusDados[j+1]; // Move os dados

				}
				meusDados[numInsercao - 1] = null;
            	numInsercao--;
			}
		}
		if (!existe){
			System.out.println("Falha ao remover o item " + item + " pois ele não existe nos dados.");
		}
		return temp;
	}
	@Override
	public Integer predecessor(Integer item) throws ConjuntoVazioException { // Retorna o predecessor do Item
		if (numInsercao == 0){
			throw new ConjuntoVazioException("O conjunto esta vazio.");
		}
		if(buscar(item) != null){
			for (int i = 1; i < numInsercao; i++){
				if (meusDados[i].equals(item)){
					return meusDados[i-1];
				}
			}
		} else {
			throw new ConjuntoVazioException("O item não existe");
		}
		return null;
	}
	@Override
	public Integer sucessor(Integer item) throws ConjuntoVazioException { // Retorna o sucessor do Item
		if (numInsercao == 0){
			throw new ConjuntoVazioException("O conjunto esta vazio.");
		}
		if (buscar(item) != null){
			for (int i = 0; i < numInsercao - 1; i++){
				if (meusDados[i].equals(item)){
					return meusDados[i+1];
				}
			}
		}
		return null;
	}
	@Override
	public Integer buscar (Integer item) { // Busca o item
		Integer temp = null;
		if (numInsercao > 0){
			for (int i = 0; i < numInsercao; i++){
				if (meusDados[i].equals(item)){
					temp = meusDados[i];
					break;
				}
			}
		}
		return temp;
	}

	public Integer minimum() throws ConjuntoVazioException{ // Retorna o menor numero do array
		Integer min;
		if (numInsercao == 0){
			throw new ConjuntoVazioException("O conjunto está vazio.");
		} else{
			min = meusDados[0];
			for(int i = 1; i < numInsercao; i++){
				if(min > meusDados[i]){
					min = meusDados[i];
				}
			}
		}
		return min;
	}

	public Integer maximum() throws ConjuntoVazioException{ // Retorna o maior numero do array
		Integer max;
		if (numInsercao == 0){
			throw new ConjuntoVazioException("O conjunto está vazio");
		} else{
			max = meusDados[0];
			for(int i = 1; i < numInsercao; i++){
				if(max < meusDados[i]){
					max = meusDados[i];
				}
			}
		}
		return max;
	}
	
	public int tamanho() {
		return numInsercao;
	} 
}
