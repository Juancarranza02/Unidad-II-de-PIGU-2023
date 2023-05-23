package examen.unidad.ii.de.pigu.pkg2023;

import Views.DashBoard;

public class ExamenUnidadIIDePIGU2023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Alumno alumno1 = new Alumno();
//        System.out.println("Respuesta de Alumno "+alumno1.Carranza63841());
        DashBoard db = new DashBoard();
        String ElementosQuimicos = "HIDROGENO\n" +
"SODIO\n" +
"ESCANDIO\n" +
"GALIO\n" +
"NIOBIO\n" +
"ANTIMONIO\n" +
"PROMETIO\n" +
"LUTECIO\n" +
"TALIO\n" +
"PROTACTINIO\n" +
"MENDELEVIO\n" +
"ROENTGENIO";
        db.txt_Area.setText(ElementosQuimicos);
        db.setVisible(true);

    }

}
