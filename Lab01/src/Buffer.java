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

	public synchronized void ler() {
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
		System.out.println("Leitor " + Thread.currentThread().getId() + " leu o valor: " + valor);
	} 
	public int getValor() {
		return valor;
	}
} 
