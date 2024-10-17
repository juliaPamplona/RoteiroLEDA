package listasEncadeadas;

public interface ListaEncadeadaIF<T extends Comparable<T>> {
	
	public boolean isEmpty(); //Verifica se vazio
	public int size(); // Retorna tamanho
	public NodoListaEncadeada<T> search(T chave); // Busca chave em Lista
	public void insert(T chave); // Insere chave no final da lista
	public void insert(T chave, int index); // Insere chave na lista por index
	public NodoListaEncadeada<T> remove(T chave) throws ListaVaziaException; // Remove elemento por chave 
	public String imprimeEmOrdem(); // Imprime a ordem que os elementos são inseridos, retorna uma cadeia de string com as chaves dos elementos
	public String imprimeInverso(); // Imprime uma cadeia de caractere com a ordem inversa de acordo com as chaves inseridas
	public NodoListaEncadeada<T> sucessor(T chave); // Retorna o sucessor da chave na lista
	public NodoListaEncadeada<T> predecessor(T chave); // Retorna o predecessor da chave na lista
	public T[] toArray(Class<T> clazz); // Retorna um array de acordo com a ordem de elementos inseridos

}
