/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import DatosDTO.EstadosDTO;
import Views.DashBoard;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ModelEstadoDashboard {
     EstadosDTO dto;
    List<EstadosDTO> estados = new ArrayList<EstadosDTO>();

    public ModelEstadoDashboard() {
        llenarEstados();
    }
    
    
    
    public  void llenarEstados(){
        estados.add(new EstadosDTO(1, "Campeche")); //0
        estados.add(new EstadosDTO(2, "Yucatan")); //1
        estados.add(new EstadosDTO(3, "Quintana Roo"));   //2
        estados.add(new EstadosDTO(4, "Tabasco"));  //3
        System.out.println(estados);
    }
    
    public void removeRow(int filaActual){
        if (filaActual != -1){
           System.out.println(filaActual);
            JOptionPane.showMessageDialog(null, "Se elimino el registro: "+filaActual);
           estados.remove(filaActual);
        }
    }
    
    public void Aceptar(int recNo, int id, String Nombre){
        if (recNo == -1){
            estados.add(new EstadosDTO(id, Nombre));
        }else{
            estados.get(recNo).setID(id);
            estados.get(recNo).setNombre(Nombre);

        }
        
    }

    public void setDatos(DashBoard db) {
        DefaultTableModel modeloTabla = (DefaultTableModel) db.tblMunicipios.getModel();
        limpiarTable(modeloTabla);
        int columnas = modeloTabla.getColumnCount();
         Object[] datos = new Object[columnas];
        for (int i = 0; i < estados.size(); i++) {
            datos[0] = i;
            datos[1] = estados.get(i).getID();
            datos[2] = estados.get(i).getNombre();
            modeloTabla.addRow(datos);
        }
    }
    
    public void limpiarTable(DefaultTableModel modeloTabla) {
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            modeloTabla.removeRow(i);
            i = i - 1;
        }
    }
    
    public int lastItemList(){
        return  estados.get(estados.size()-1).getID();
    }
    
    public boolean ExportarInfo() {
        String ruta = System.getProperty("user.home");
        String url = ruta+"\\OneDrive\\Escritorio\\tblEstados.txt";
        System.out.println("Inico guardar archivo");
        File archivo = new File(url);
        PrintWriter escribir;
        try {
            escribir = new PrintWriter(archivo);
            for (EstadosDTO estado : estados) {
                escribir.print("ID: "+estado.getID()+ "  ");
                escribir.print("Nombre: "+estado.getNombre() + "\n");
            }
            escribir.close();
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("Error en crear archivo "+ex.getMessage());
            return false;
        }
    }
    
}
