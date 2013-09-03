public class Buffer {
	private int buffer = 0; 
	int valor = 0;

	public synchronized void escrever(int value) {

		while (buffer < 4) {

			try {
				wait();
			} 
			catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}


		buffer = 0;
		valor = value; 
		System.out.println("Escritor escreveu!");
		notifyAll(); 
	} 

	public synchronized int ler() {
		while (buffer == 4) {

			try {
				wait();
			} 
			catch (InterruptedException exception) {
				exception.printStackTrace();
			} 
		}
		buffer++;
		notifyAll();
		return valor;
	} 
	public int getValor() {
		return valor;
	}
} 
