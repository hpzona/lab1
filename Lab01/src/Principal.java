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
		//Escritor
		ScheduledExecutorService  ste = Executors.newScheduledThreadPool(poolEscritores);
		//Buffer
		Buffer buffer = new Buffer();
		
		for(int i=0; i<120; i++) {
			te.execute(new Leitor(buffer));
			ste.scheduleAtFixedRate(new Escritor("Escritor-scheduled-At-Fixed-Rate",buffer), 10, 10000, TimeUnit.NANOSECONDS);
		}
	}
}
