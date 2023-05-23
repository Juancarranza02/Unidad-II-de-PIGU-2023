/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Views.DashBoard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ControladorFrameExportar implements ActionListener{
    
    DashBoard ds; 

    public ControladorFrameExportar(DashBoard ds) {
        this.ds = ds;
        this.ds.btn_BuscarArchivos.addActionListener(this);
        this.ds.btn_GuardarArchivo.addActionListener(this);
        this.ds.btn_elinarArchivo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ds.btn_BuscarArchivos){
            buscarArchivo();
        }else if(e.getSource() == ds.btn_GuardarArchivo){
            if(guardadArchivo()){
                JOptionPane.showMessageDialog(ds, "Se guardo Correctamente");
            }else{
                JOptionPane.showMessageDialog(ds, "Error. Verifique...");
            }
        }else if(e.getSource() == ds.btn_elinarArchivo){
            if(Eliminar()){
                JOptionPane.showMessageDialog(ds, "Se Borro Correctamente");
            }else{
                JOptionPane.showMessageDialog(ds, "Error. Verifique...");
            }
        }
     }
    
    public void buscarArchivo() {
        System.out.println("Inico de la carga de archivo");
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");
        fc.setFileFilter(filter);
        int seleccion = fc.showOpenDialog(ds);
        if (seleccion == JFileChooser.CANCEL_OPTION) {

        } else if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fc.getSelectedFile();
            ds.txt_nombreArchivo.setText(archivoSeleccionado.getAbsolutePath());
            try ( FileReader fr = new FileReader(archivoSeleccionado)) {
                String cadena = "";
                int valor = fr.read();
                while (valor != -1) {
                    cadena += (char) valor;
                    valor = fr.read();
                }
                ds.textArea.setText(cadena);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public boolean guardadArchivo() {
        System.out.println("Inico guardar archivo");
        File archivo = new File(ds.txt_nombreArchivo.getText());
        PrintWriter escribir;
        try {
            escribir = new PrintWriter(archivo);
            escribir.print(ds.textArea.getText());
            escribir.close();
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("Error guardadArchivo "+ex.getMessage());
            return  false;
        }
    }
    
    public boolean Eliminar() {
        System.out.println("Inico eliminar archivo");
        File archivo = new File(ds.txt_nombreArchivo.getText());
        if (archivo.delete()) {
            System.out.println("Archivo borrado: " + archivo.getName());
            return true;
        } else {
            System.out.println("Error al borrar el archivo");
            return false;
        }
    }
    
    
}
