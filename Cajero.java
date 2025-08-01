
import java.util.HashMap;

public class Cajero extends Thread {
    private int id;
    private Fila filaClientes;
    private double factorDeCansancio;

    public Cajero(int id, Fila filaClientes) {
        this.id = id;
        this.filaClientes = filaClientes;
        this.factorDeCansancio = 1.0;
    }

    public double getFactorDeCansancio() {
        return factorDeCansancio;
    }

    public int getIdC() {
        return id;
    }

    public Fila getFilaClientes() {
        return filaClientes;
    }

    @Override
    public void run() {
        while(true){
        HashMap<Integer, Integer> clienteActual = filaClientes.sacarCliente();
        int tiempoBase = clienteActual.values().iterator().next();
        int idCliente = clienteActual.keySet().iterator().next();
        double tiempoCalculado = tiempoBase * factorDeCansancio;

        System.out.println("El cajero " + id + " atendiendo al cliente " + (idCliente) +  
                           " (tiempo de procesamiento básico: " + tiempoBase + "ms) " +
                           "factor de cansancio actual: " + factorDeCansancio + 
                           " tiempo de procesamiento actual: " + tiempoCalculado + "ms");

        try {
            Thread.sleep((long) tiempoCalculado);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        factorDeCansancio += tiempoBase * 0.001; 
    }
        
    }
}
