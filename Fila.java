import java.util.ArrayList;
import java.util.HashMap;

public class Fila{

    private boolean hayClientes = false;
    private ArrayList<HashMap<Integer,Integer>> fila = new ArrayList<HashMap<Integer,Integer>>();

    public synchronized void anadirCliente(int id, int tiempo){
        HashMap<Integer,Integer> cliente = new HashMap<Integer,Integer>();
        cliente.put(id,tiempo);
        fila.add(cliente);
        hayClientes = true;
        notify();
    }

    public synchronized HashMap<Integer,Integer> sacarCliente(){
        while(!hayClientes){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        if (fila.size() == 1){
            hayClientes = false;
        }

        return fila.remove(0);
    }

}