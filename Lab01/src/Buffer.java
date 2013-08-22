public class Buffer {
	private int buffer = -1; // compartilhado pelas threads Produtor e
								// Consumidor
	private boolean occupied = false; // contagem de buffers ocupados

	// coloca o valor no buffer
	public synchronized void escrever(int value) {
		// enquanto n�o houver posi��es vazias, coloca a thread em estado de
		// espera
		while (occupied) {
			// envia informa��es de thread e de buffer para a sa�da, ent�o
			// espera
			try {
				System.out.println("Leitor tentou ler.");
				wait();
			} // fim do try
			catch (InterruptedException exception) {
				exception.printStackTrace();
			} // fim do catch
		} // fim do while

		buffer = value; // configura novo valor de buffer

		// indica que a produtora n�o pode armazenar outro valor
		// at� a consumidora recuperar valor atual de buffer
		occupied = true;

		notify(); // instrui a thread em espera a entrar no estado execut�vel
	} // fim do m�todo set; libera bloqueio em SynchronizedBuffer

	// retorna valor do buffer
	public synchronized int ler() {
		// enquanto os dados n�o s�o lidos, coloca thread em estado de espera
		while (!occupied) {
			// envia informa��es de thread e de buffer para a sa�da, ent�o
			// espera
			try {
				System.out.println("Consumer tries to read.");
				wait();
			} // fim do try
			catch (InterruptedException exception) {
				exception.printStackTrace();
			} // fim do catch
		} // fim do while

		// indica que a produtora pode armazenar outro valor
		// porque a consumidora acabou de recuperar o valor do buffer
		occupied = false;

		int readValue = buffer; // armazena valor em buffer
		buffer = 0;
		notify(); // instrui a thread em espera a entrar no estado execut�vel
		
		return readValue;
	} // fim do m�todo get; libera bloqueio em SynchronizedBuffer
} // fim da classe SynchronizedBuffer

