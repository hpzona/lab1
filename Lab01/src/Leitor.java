
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
	            System.out.println("Leitor leu o valor: " + buffer.ler());
	         } // fim do try
	         // se a thread adormecida é interrompida, imprime rastreamento de pilha 
	         catch ( InterruptedException exception ) 
	         {
	            exception.printStackTrace();
	         } // fim do catch
	}
}
