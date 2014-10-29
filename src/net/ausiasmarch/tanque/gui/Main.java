/*
 * Main.java
 */
package net.ausiasmarch.tanque.gui;

//import net.ausiasmarch.common.Convert;
import net.ausiasmarch.tanque.modelo.*;
import net.ausiasmarch.common.Convert;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Administrador
 */
public class Main extends javax.swing.JFrame {

    private ControlRiego controlRiego;
    private EstadoTanque estado;
    private String mensaje;

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();

        estado = tanque.getEstado();
        controlRiego = new ControlRiego(estado);

        mensaje = controlRiego.getMensaje();
        setSize(580, 445);
        setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonLlenarMedio = new javax.swing.JButton();
        jButtonVaciarMedio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNivelSequia = new javax.swing.JTextField();
        jTextFieldNivelHumedadSuelo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tanque = new net.ausiasmarch.tanque.modelo.Tanque();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tanque de agua");
        setResizable(false);

        jButtonLlenarMedio.setText("Llenar Medio");
        jButtonLlenarMedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLlenarMedioActionPerformed(evt);
            }
        });

        jButtonVaciarMedio.setText("Vaciar Medio");
        jButtonVaciarMedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVaciarMedioActionPerformed(evt);
            }
        });

        jLabel1.setText("Nivel de sequia [0-10]:");

        jTextFieldNivelSequia.setText("5");

        jTextFieldNivelHumedadSuelo.setText("5");

        jLabel2.setText("Nivel de humedad del suelo [0-10]:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tanque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldNivelHumedadSuelo)
                            .addComponent(jTextFieldNivelSequia, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonLlenarMedio)
                            .addComponent(jButtonVaciarMedio))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tanque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNivelSequia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLlenarMedio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldNivelHumedadSuelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonVaciarMedio))
                    .addComponent(jLabel2))
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLlenarMedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLlenarMedioActionPerformed

        int sequiaTipo = 0;

        if (!Convert.isValidInt(jTextFieldNivelSequia.getText())) {
            this.mensaje = "Valor erroneo para el campo sequ�a";
            mensaje(mensaje);
            return;
        }
        sequiaTipo = Convert.parseInt(jTextFieldNivelSequia.getText());
        controlRiego.setSequia(sequiaTipo);

        if (controlRiego.permitidoLlenar() != 0) {
            controlRiego.tipoMensaje(controlRiego.permitidoLlenar());
            mensaje = controlRiego.getMensaje();
            mensaje(mensaje);
            return;
        }
        tanque.llenarMedio();
        controlRiego.setEstado(tanque.getEstado());

    }//GEN-LAST:event_jButtonLlenarMedioActionPerformed

    private void jButtonVaciarMedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVaciarMedioActionPerformed

        int humedadTipo;

        if (!Convert.isValidInt(jTextFieldNivelHumedadSuelo.getText())) {
            this.mensaje = "Valor erroneo para el campo humedad";
            mensaje(mensaje);
            return;
        }
        humedadTipo = Convert.parseInt(jTextFieldNivelHumedadSuelo.getText());
        controlRiego.setHumedad(humedadTipo);
        if (controlRiego.permitidoVaciar() != 0) {
            controlRiego.tipoMensaje(controlRiego.permitidoVaciar());
            mensaje = controlRiego.getMensaje();
            mensaje(mensaje);
            return;
        }
        tanque.vaciarMedio();
        controlRiego.setEstado(tanque.getEstado());
    }//GEN-LAST:event_jButtonVaciarMedioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            String look = UIManager.getSystemLookAndFeelClassName();
            javax.swing.UIManager.setLookAndFeel(look);

            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (info.getName().equals(("Nimbus"))) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    private void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLlenarMedio;
    private javax.swing.JButton jButtonVaciarMedio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextFieldNivelHumedadSuelo;
    private javax.swing.JTextField jTextFieldNivelSequia;
    private net.ausiasmarch.tanque.modelo.Tanque tanque;
    // End of variables declaration//GEN-END:variables
}
