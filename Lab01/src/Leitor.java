
public class Leitor implements Runnable {

	private Buffer buffer;

	public Leitor(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
	         try 
	         {
	            Thread.sleep( 10 );
	            System.out.printf("Leu");
	            System.out.println(buffer.ler());
	         } // fim do try
	         // se a thread adormecida � interrompida, imprime rastreamento de pilha 
	         catch ( InterruptedException exception ) 
	         {
	            exception.printStackTrace();
	         } // fim do catch
	}
}