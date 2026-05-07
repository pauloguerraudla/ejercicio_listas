import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel panel;
    private JTabbedPane tabbedPane1;
    private JSpinner spiCodigo;
    private JTextField txtReceptor;
    private JCheckBox fragilCheckBox;
    private JTextField txtDescripcion;
    private JButton btnRegistrar;
    private JTextField txtCodigo;
    private JButton btnBuscar;
    private JButton btnListar;
    private JTextArea txtListar;
    private JTextField txtPeso;
    private JButton btnOrdenar;
    Lista agencia=new Lista();

    public Ventana() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo=Integer.parseInt(spiCodigo.getValue().toString());
                String receptor=txtReceptor.getText();
                boolean fragil=fragilCheckBox.isSelected();
                String descripcion=txtDescripcion.getText();
                float peso=Float.parseFloat(txtPeso.getText());
                Envio envio1=new Envio(codigo,receptor,fragil,descripcion,peso);
                if(agencia.agregar(envio1)==true){
                    JOptionPane.showMessageDialog(null,
                            "Se agrego correctamente");
                }else{
                    JOptionPane.showMessageDialog(null,
                            "Revise el codigo");
                }
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int codigo = Integer.parseInt(txtCodigo.getText());
                    int indice = agencia.buscarCodigoBinario(codigo);
                    Envio envio = agencia.getValor(indice);
                    txtListar.setText("");
                    txtListar.setText(envio.toString());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,
                            ex.getMessage());
                }
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListar.setText(agencia.toString());
            }
        });
        btnOrdenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lista clonada=agencia.clonar();
                clonada.ordenar();
                txtListar.setText(clonada.toString());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
