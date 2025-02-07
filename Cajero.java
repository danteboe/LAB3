public class Cajero extends Thread {
    private int id;
    private int[] filaClientes;
    private double factorDeCansancio;

    public Cajero(int id, int[] filaClientes) {
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

    public int[] getFilaClientes() {
        return filaClientes;
    }

    @Override
    public void run() {
        System.out.println("El cajero " + id + " comienza a procesar la fila " + id);
        
        for (int i = 0; i < filaClientes.length; i++) {
            int tiempoBase = filaClientes[i];
            double tiempoCalculado = tiempoBase * factorDeCansancio;

            System.out.println("El cajero " + id + " atendiendo al cliente " + (i + 1) + 
                               " de la fila " + id + 
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

        System.out.println("El cajero " + id + " ha terminado de atender.");
    }
}
