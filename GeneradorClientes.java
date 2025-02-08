import java.util.Random;
public class GeneradorClientes extends Thread{
    
    private Random random = new Random();
    private Fila fila;
    private int numeroDeClientes;

    public GeneradorClientes(Fila pFila, int numeroClientes){
        this.fila = pFila;
        this.numeroDeClientes = numeroClientes;
    }

    @Override
    public void run(){
        int uidActual = 1;
        while(uidActual!=numeroDeClientes){
            int tiempo = random.nextInt(0,2000);
            fila.anadirCliente(uidActual, tiempo);
            System.out.println("Cliente " + uidActual + " añadido a la fila con tiempo de procesamiento " + tiempo + "ms");
            uidActual++;
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
        }
    }

}
