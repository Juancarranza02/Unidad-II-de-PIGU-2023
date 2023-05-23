/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DatosDTO.EstadosDTO;
import Models.ModelElementoDashboard;
import Models.ModelEstadoDashboard;
import Views.DashBoard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class ControladorDashboard implements ActionListener, MouseListener{
    
    DashBoard db;
    ModelElementoDashboard edb = new ModelElementoDashboard();
    
    int filaActual = 0;
    boolean verificar = false;
    
    public ControladorDashboard(DashBoard db) {
        this.db = db;
        this.db.btn_Aceptar.addActionListener(this);
        this.db.btn_Actualizar.addActionListener(this);
        this.db.btn_Eliminar.addActionListener(this);
        this.db.btn_cancelar.addActionListener(this);  
        this.db.btn_Exportar.addActionListener(this);
        this.db.tblMunicipios.addMouseListener(this);
        edb.setDatos(db);
        db.ilbd.setText(""+edb.lastItemList());
        db.setLocationRelativeTo(db);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == db.btn_Aceptar){
            int recNo = Integer.parseInt(db.txt_recNo.getText());
            int id = Integer.parseInt(db.txt_id.getText());
            String nombre = db.txt_Nombre.getText();
            Float masa_atómica = Float.parseFloat(db.txt_masa.getText());
            int número_atómico = Integer.parseInt(db.txt_numAtom.getText());
            String símbolo_químico = db.txt_simbolo.getText();
            String color = db.txt_color.getText();
            if(verificar){
                edb.Aceptar(recNo, id,masa_atómica,número_atómico, símbolo_químico, nombre,color);
                edb.setDatos(db);
            }

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == db.tblMunicipios){
            filaActual = db.tblMunicipios.getSelectedRow();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
   }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
