import java.util.ArrayList;

public class Lista {
    private ArrayList<Envio> envios;

    public Lista(){
        envios=new ArrayList<>();
    }

    public boolean agregar(Envio envio){
        if(envios.isEmpty()){//primer elemento
            envios.add(envio);
            return true;
        }else{//desde el segundo elemento
            if(envio.getCodigo()>envios.getLast().getCodigo()){
                envios.add(envio);
                return true;
            }
            return false;//repetido o es menor
        }
    }

    public int buscarCodigoBinario(int codigo){
        if(codigo<envios.getFirst().getCodigo() ||
        codigo>envios.getLast().getCodigo())
            return -1;//no existe

        int inf=0;
        int sup=envios.size()-1;
        int centro;

        while(inf<=sup){
            centro=(inf+sup)/2;
            if(codigo==envios.get(centro).getCodigo()){
                return centro;//indice en el que se encuentra
            }else if(codigo<envios.get(centro).getCodigo()){
                sup=centro-1; //izquierdo
            }else{
                inf=centro+1; //derecho
            }
        }
        return -1;//No se encontro
    }

    public Envio getValor(int indice) throws Exception {
        if(indice<0 || indice>=envios.size())
            throw new Exception("indice fuera de rango");
        return envios.get(indice);
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for(Envio envio:envios){
            sb.append(envio.toString());
        }
        return sb.toString().length()!=0?sb.toString():"No hay elementos";
    }

    public void ordenar(){
        Envio aux=new Envio();
        int n=envios.size();
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(envios.get(j).getPeso()>envios.get(j+1).getPeso()){
                    aux=envios.get(j+1);
                    envios.set(j+1,envios.get(j));
                    envios.set(j,aux);
                }
            }
        }
    }

    public Lista clonar(){
        Lista aux=new Lista();
        aux.envios=(ArrayList<Envio>) envios.clone();
        return aux;
    }
}
