package observer;

public interface VidaSubject {
    void adicionarObservador(VidaObserver observer);
    void removerObservador(VidaObserver observer);
    void notificarObservadores();
}
