
public class Escritor implements Runnable{
	private String nomeThread = null;
	private Buffer buffer;

	public Escritor(String nomeThread, Buffer buffer) {
		this.buffer = buffer;
		this.nomeThread = nomeThread;
	}

	@Override
	public void run() {
		buffer.escrever(buffer.getValor() + 1);
	}

}
