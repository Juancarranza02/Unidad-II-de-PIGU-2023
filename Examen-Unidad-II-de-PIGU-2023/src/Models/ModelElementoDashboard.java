/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import DatosDTO.ElementoQuimicoDTO;
import Views.DashBoard;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ModelElementoDashboard {
    List<ElementoQuimicoDTO> elementos = new ArrayList<ElementoQuimicoDTO>();

    public ModelElementoDashboard() {
        llenarEstados();
    }
    
    
    
    public  void llenarEstados(){
        elementos.add(new ElementoQuimicoDTO(1,1.1f,1,"H", "Hidrogeno", "rojo")); //0
        elementos.add(new ElementoQuimicoDTO(2,22.99f,11,"Na", "SODIO","Amarillo")); //1
        elementos.add(new ElementoQuimicoDTO(3,44.96f,21,"Sc", "ESCANDIO", "Amarillo"));   //2
        elementos.add(new ElementoQuimicoDTO(4,69.72f,31,"Ga", "GALIO","Amarillo"));  //3
        elementos.add(new ElementoQuimicoDTO(5,92.91f,41,"Nb", "NIOBIO","Amarillo"));  //3
        elementos.add(new ElementoQuimicoDTO(6,121.76f,51,"Sb" ,"ANTIMONIO","cafe"));  //3
        elementos.add(new ElementoQuimicoDTO(7,145f,61, "Pm", "PROMETIO","amarillo"));  //3
        elementos.add(new ElementoQuimicoDTO(8,174.97f,71,"Lu", "LUTECIO","amarillo"));  //3
        elementos.add(new ElementoQuimicoDTO(9,204.38f,81,"Tl", "TALIO","amarillo"));  //3
        elementos.add(new ElementoQuimicoDTO(10,231.04f,91,"Pa", "PROTACTINIO","Amarillo"));  //3
        elementos.add(new ElementoQuimicoDTO(11,258f,101,"Md", "MENDELEVIO","Amarillo"));  //3
        elementos.add(new ElementoQuimicoDTO(12,285f,111, "Rg","ROENTGENIO","Amarillo"));  //3
    }
    
    public void Aceptar(int recNo,int id, Float masa_atómica, int número_atómico, String símbolo_químico, String nombre, String color){
        if (recNo == -1){
            elementos.add(new ElementoQuimicoDTO(id,masa_atómica,número_atómico, símbolo_químico, nombre,color ));
        }else{
            elementos.get(recNo).setId(id);
            elementos.get(recNo).setNúmero_atómico(número_atómico);
            elementos.get(recNo).setNombre(nombre);
            elementos.get(recNo).setMasa_atómica(masa_atómica);
            elementos.get(recNo).setSímbolo_químico(símbolo_químico);
            elementos.get(recNo).setColor(color);
        }
        
    }
    public int lastItemList(){
        return  elementos.get(elementos.size()-1).getId();
    }

    public void setDatos(DashBoard db) {
        DefaultTableModel modeloTabla = (DefaultTableModel) db.tblMunicipios.getModel();
        limpiarTable(modeloTabla);
        int columnas = modeloTabla.getColumnCount();
         Object[] datos = new Object[columnas];
        for (int i = 0; i < elementos.size(); i++) {
            datos[0] = i;
            datos[1] = elementos.get(i).getId();
            datos[2] = elementos.get(i).getNúmero_atómico();
            datos[3] = elementos.get(i).getNombre();
            datos[4] = elementos.get(i).getMasa_atómica();
            datos[5] = elementos.get(i).getSímbolo_químico();
            datos[6] = elementos.get(i).getColor();
            modeloTabla.addRow(datos);
        }
    }
    
    public void limpiarTable(DefaultTableModel modeloTabla) {
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            modeloTabla.removeRow(i);
            i = i - 1;
        }
    }
    
    public void Actualizar(int filaActual, DashBoard db){
        if (filaActual != -1){
            db.txt_recNo.setText(""+db.tblMunicipios.getValueAt(filaActual, 0));
            db.txt_id.setText("" + db.tblMunicipios.getValueAt(filaActual, 1));
            db.txt_numAtom.setText("" + db.tblMunicipios.getValueAt(filaActual, 2));
            db.txt_Nombre.setText("" + db.tblMunicipios.getValueAt(filaActual, 3));
            db.txt_masa.setText("" + db.tblMunicipios.getValueAt(filaActual, 4));
            db.txt_simbolo.setText("" + db.tblMunicipios.getValueAt(filaActual, 5));
            db.txt_color.setText("" + db.tblMunicipios.getValueAt(filaActual, 6));

        }else{
            System.out.println("Es necesario Seleccionar un registro");
        }
    }
    
    public void removeRow(int filaActual){
        if (filaActual != -1){
           System.out.println(filaActual);
            JOptionPane.showMessageDialog(null, "Se elimino el registro: "+filaActual);
           elementos.remove(filaActual);
        }
    }
    
    public void LimpiarCampos(DashBoard db){
        int contador = Integer.parseInt(db.ilbd.getText());
        db.txt_Nombre.setText("");
        db.txt_masa.setText("");
        db.txt_numAtom.setText("");
        db.txt_simbolo.setText("");
        db.txt_id.setText(""+(contador+1));
        db.txt_Nombre.requestFocus(true);
    }
    
    public boolean ExportarInfo() {
        String ruta = System.getProperty("user.home");
        String url = ruta+"\\OneDrive\\Escritorio\\tblElementosQumicos.txt";
        System.out.println("Inico guardar archivo");
        File archivo = new File(url);
        PrintWriter escribir;
        try {
            escribir = new PrintWriter(archivo);
            for (ElementoQuimicoDTO quimico : elementos) {
                escribir.print("ID: "+quimico.getId()+ "  ");
                escribir.print("Nombre: "+quimico.getNombre() + "  ");
                escribir.print("Num. Atomico: "+quimico.getNúmero_atómico()+ "  ");
                escribir.print("Masa Atomica: "+quimico.getMasa_atómica()+ "  ");
                escribir.print("Simbolo: "+quimico.getSímbolo_químico()+ "  ");
                escribir.print("Color: "+quimico.getColor()+ "\n");
            }
            escribir.close();
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("Error en crear archivo "+ex.getMessage());
            return false;
        }
    }
    
}
