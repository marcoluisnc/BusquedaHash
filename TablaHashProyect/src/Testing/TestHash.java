package Testing;

import javax.swing.*;

public class TestHash {
    public static void main(String[] args) {
        HashT hash=new HashT(20);
        String elementos[] = null;
        Object[] accion = {"Buscar por clave","Eliminar por clave","Mostrar"};
        String opc;
        String sueldos = "1000 2000 5000 51";
        elementos = sueldos.split(" ");
        hash.funcionHash(elementos);
        try {
            do {
                opc = leerOpc("Que opcion deseas hacer?", accion);
                switch (opc) {
                    case "Buscar por clave":
                        String clave;
                        try {
                            do {
                                clave = JOptionPane.showInputDialog("Clave a buscar");
                                String salida = hash.buscarClave(clave);
                                JOptionPane.showMessageDialog(null, salida);
                            } while (clave.charAt(0) != '0');
                        } catch (NullPointerException e) {
                            System.out.println("Ha cancelado");
                        }
                        break;
                    case "Eliminar por clave":
                        break;
                    case "Mostrar":
                        hash.mostrar(elementos);
                        break;
                    case "Salir":
                }
            } while (opc.compareTo("Salir") != 0);
        }catch (NullPointerException e){
            System.out.println("Cancelado");
        }
    }
    public static String leerOpc(String mensaje,Object[] opciones){
        return (String) JOptionPane.showInputDialog(null,mensaje,"LISTA DE OPCIONES",
                JOptionPane.QUESTION_MESSAGE,null,opciones,opciones[0]);
    }
}
