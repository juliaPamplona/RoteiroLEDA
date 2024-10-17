package pilha;
import java.util.NoSuchElementException;

public class MinhaPilhaEncadeada<E> implements PilhaIF<E> {

    private No<E> topo;

    public MinhaPilhaEncadeada() {
        topo = null;
    }

    @Override
    public void empilhar(E item) throws PilhaCheiaException {
        No<E> novoNo = new No<>(item);
        novoNo.setProximo(topo);
        topo = novoNo;
    }

    @Override
    public E desempilhar() throws PilhaVaziaException {
        if (isEmpty()) {
            throw new PilhaVaziaException("A pilha está vazia.");
        }
        E dado = topo.getDado();
        topo = topo.getProximo();
        return dado;
    }

    @Override
    public E topo() {
        if (isEmpty()) {
            throw new NoSuchElementException("A pilha está vazia.");
        }
        return topo.getDado();
    }

    @Override
    public PilhaIF<E> multitop(int k) throws PilhaVaziaException, PilhaCheiaException {
        if (k <= 0) {
            throw new IllegalArgumentException("O valor de k deve ser positivo.");
        }

        MinhaPilhaEncadeada<E> novaPilha = new MinhaPilhaEncadeada<>();
        No<E> atual = topo;
        for (int i = 0; i < k && atual != null; i++) {
            novaPilha.empilhar(atual.getDado());
            atual = atual.getProximo();
        }
        return novaPilha;
    }

    @Override
    public boolean isEmpty() {
        return topo == null;
    }

    private static class No<E> {
        private E dado;
        private No<E> proximo;

        public No(E dado) {
            this.dado = dado;
        }

        public E getDado() {
            return dado;
        }

        public void setDado(E dado) {
            this.dado = dado;
        }

        public No<E> getProximo() {
            return proximo;
        }

        public void setProximo(No<E> proximo) {
            this.proximo = proximo;
        }
    }
}