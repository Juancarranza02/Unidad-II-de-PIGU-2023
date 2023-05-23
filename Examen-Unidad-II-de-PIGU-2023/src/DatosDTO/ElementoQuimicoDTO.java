/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatosDTO;

public class ElementoQuimicoDTO {
    private int id;
    private Float masa_atómica;
    private int número_atómico;
    private String símbolo_químico;
    private String nombre; 
    private String color;

    public ElementoQuimicoDTO() {
    }

    public ElementoQuimicoDTO(int id, Float masa_atómica, int número_atómico, String símbolo_químico, String nombre, String color) {
        this.id = id;
        this.masa_atómica = masa_atómica;
        this.número_atómico = número_atómico;
        this.símbolo_químico = símbolo_químico;
        this.nombre = nombre;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public Float getMasa_atómica() {
        return masa_atómica;
    }

    public void setMasa_atómica(Float masa_atómica) {
        this.masa_atómica = masa_atómica;
    }

    public int getNúmero_atómico() {
        return número_atómico;
    }

    public void setNúmero_atómico(int número_atómico) {
        this.número_atómico = número_atómico;
    }

    public String getSímbolo_químico() {
        return símbolo_químico;
    }

    public void setSímbolo_químico(String símbolo_químico) {
        this.símbolo_químico = símbolo_químico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
