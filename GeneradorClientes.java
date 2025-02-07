public class GeneradorClientes extends Thread{
    
    private Fila fila;

    public GeneradorClientes(Fila pFila){
        this.fila = pFila;
    }

    @Override
    public void run(){
        int uidActual = 0;
        while(uidActual!=100){
            fila.anadirCliente(uidActual);
            uidActual++;
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
        }
    }

}
