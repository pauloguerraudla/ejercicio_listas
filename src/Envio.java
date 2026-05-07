public class Envio {
    private int codigo;
    private String receptor;
    private Boolean fragil;
    private String descripcion;
    private float peso;

    public Envio(int codigo, String receptor, Boolean fragil, String descripcion,float peso) {
        this.codigo = codigo;
        this.receptor = receptor;
        this.fragil = fragil;
        this.descripcion = descripcion;
        this.peso=peso;
    }

    public Envio() {

    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public Boolean getFragil() {
        return fragil;
    }

    public void setFragil(Boolean fragil) {
        this.fragil = fragil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Envio " +
                "codigo: " + codigo +
                ", receptor: " + receptor +
                ", fragil: " + fragil +
                ", descripcion: " + descripcion +
                ", peso: "+peso+"\n";
    }
}
