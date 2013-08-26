
public class Escritor implements Runnable{
	private String nomeThread = null;
	private Buffer buffer;
	private int valor;

	public Escritor(String nomeThread, Buffer buffer) {
		this.buffer = buffer;
		this.nomeThread = nomeThread;
		this.valor = 0;
	}

	@Override
	public void run() {
		buffer.escrever(valor++);
	}

}
