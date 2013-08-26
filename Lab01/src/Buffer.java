public class Buffer {
	private int buffer = 0; // compartilhado pelas threads Produtor e
								// Consumidor
	int valor = 0;

	// coloca o valor no buffer
	public synchronized void escrever(int value) {
		// enquanto n�o houver posi��es vazias, coloca a thread em estado de
		// espera
		while (buffer == 4) {
			// envia informa��es de thread e de buffer para a sa�da, ent�o
			// espera
			try {
				System.out.println("Escritor escreveu!");
				wait();
			} // fim do try
			catch (InterruptedException exception) {
				exception.printStackTrace();
			} // fim do catch
			buffer = 0;
		} // fim do while

		valor = value; // configura novo valor de buffer

		// indica que a produtora n�o pode armazenar outro valor
		// at� a consumidora recuperar valor atual de buffer

		notifyAll(); // instrui a thread em espera a entrar no estado execut�vel
	} // fim do m�todo set; libera bloqueio em SynchronizedBuffer

	// retorna valor do buffer
	public synchronized int ler() {
		// enquanto os dados n�o s�o lidos, coloca thread em estado de espera
		while (buffer < 4) {
			// envia informa��es de thread e de buffer para a sa�da, ent�o
			// espera
			try {
				System.out.println("Leitor tentou ler, buffer = " + buffer);
				buffer++;
				wait();
			} // fim do try
			catch (InterruptedException exception) {
				exception.printStackTrace();
			} // fim do catch
		} // fim do while

		// indica que a produtora pode armazenar outro valor
		// porque a consumidora acabou de recuperar o valor do buffer
		// armazena valor em buffer
		
		notify(); // instrui a thread em espera a entrar no estado execut�vel
		
		return valor;
	} // fim do m�todo get; libera bloqueio em SynchronizedBuffer

	public int getValor() {
		return valor;
	}
} // fim da classe SynchronizedBuffer

