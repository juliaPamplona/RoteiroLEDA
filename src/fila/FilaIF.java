package fila;

public interface FilaIF<E> {
	
	public void enfileirar(E item) throws FilaCheiaException;
	
	public E desenfileirar() throws FilaVaziaException;
	
	public E verificarCauda() throws FilaVaziaException;
	
	public E verificarCabeca() throws FilaVaziaException;
	
	public boolean isEmpty();
	
	public boolean isFull();
	
}