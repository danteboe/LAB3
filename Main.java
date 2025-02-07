public class Main {
    public static void main(String[] args){
        
        int numCajeros = 5;
        int numClientes = 10;

        Fila fila = new Fila();
        GeneradorClientes clientes = new GeneradorClientes(fila, numClientes);
        clientes.start();

        for (int i = 0; i < numCajeros; i++){
            Cajero cajero = new Cajero(i, fila);
            cajero.start();
        }
    }
}
