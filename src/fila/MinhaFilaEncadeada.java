package fila;
//import listasEncadeadas.ListaEncadeadaIF;

public class MinhaFilaEncadeada implements FilaIF<Integer> {
	
//	private ListaEncadeadaIF filaEncadeada = null;
	
	class No {
	    Object item;
	    No proximo;

	    public No(Object item) {
	        this.item = item;
	        this.proximo = null;
	    }
	}
    
	    private No cabeca;
	    private No cauda;
	    private int capacidadeMaxima;

	    public MinhaFilaEncadeada(int capacidadeMaxima) {
	        this.capacidadeMaxima = capacidadeMaxima; 
	        }

	    public MinhaFilaEncadeada() {
	        this.cabeca = null;
	        this.cauda = null;
	    }

	    public boolean isEmpty() {
	        return cabeca == null;
	    }

	public void enfileirar(Integer item) throws FilaCheiaException {
		
		        No novoNo = new No(item);
		        if (isEmpty()) {
		            cabeca = novoNo;
		        } else {
		            cauda.proximo = novoNo;
		        }
		        cauda = novoNo;
		    }

	
	public Integer desenfileirar() throws FilaVaziaException {
		 if (isEmpty()) {
	            throw new RuntimeException("Fila vazia");
	        } else {
	        Object item = cabeca.item;
	        cabeca = cabeca.proximo; 
	        if (cabeca == null) {
	            cauda = null;
	        } }
		return null;
	}

	public Integer verificarCauda() {
		  if (isEmpty()) {
	            throw new RuntimeException("Fila vazia");
	        }
		  else {
			  return (Integer) cauda.item; 
			  }
	}

	public Integer verificarCabeca() {
		if (isEmpty()) {
            throw new RuntimeException("Fila vazia");
        } else {
        return (Integer) cabeca.item; }
	}

	public boolean isFull() {
	        int count = 0;
	        No temp = cabeca;
	        while (temp != null) {
	            count++;
	            temp = temp.proximo;
	        }
	        return count == capacidadeMaxima;
	    }
	}
