import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Principal {
	
	public static void main(String[] args) {
		int  poolLeitores = 4;
		int  poolEscritores = 1;
		
		
		//Leitor
		ExecutorService te  =  Executors.newFixedThreadPool(poolLeitores);
		ScheduledExecutorService  ste = Executors.newScheduledThreadPool(poolEscritores);
		
		ste.scheduleAtFixedRate(new Escritor("Escritor-scheduled-At-Fixed-Rate", 10, 10000, TimeUnit.NANOSECONDS);
		

	}

}
