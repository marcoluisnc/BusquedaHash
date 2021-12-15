package App;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        try {
            int i, clave;
            String opc = "";
            String nombre = "";
            Object[] menu = {"Insertar usuario","Buscar por clave","Eliminar por clave","Mostrar todos"};
            int saldo = 0;
            int tama = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la tabla"));
            Hash[] h = new Hash[tama];
            for (i = 0; i < h.length; i++) {
                h[i] = new Hash();
                h[i].estado = 0;
            }
            do {
                opc = leerOpc("Que opcion desea",menu);
                switch (opc) {
                    case "Insertar usuario":
                        clave = leerEntero("Ingrese la clave del usuario:");
                        nombre=JOptionPane.showInputDialog("Ingrese el nombre del usuario");
                        saldo=leerEntero("Ingrese el saldo del usuario");
                        Hash.insertHash(h, tama, clave, nombre, saldo);
                        break;
                    case "Buscar por clave":
                        if(i!=-1){
                            clave = leerEntero("Ingrese el número de clave a ser buscado:");
                            i = Hash.searchHash(h, tama, clave);
                        }else
                            System.out.println("No se encontro");
                        break;
                    case "Eliminar por clave":
                        if(i!=-1){
                            clave = leerEntero("Ingrese el número de clave a ser eliminado:");
                            i = Hash.deleteHashTable(h, tama, clave);
                        }else
                            System.out.println("No se encontro");
                        break;
                    case "Mostrar todos": Hash.showHashTable(h);
                        break;
                    case "Salir":
                }
            } while (opc.compareTo("Salir") != 0);
        } catch (NullPointerException e) {
            System.out.println("Saliendo..");
        }

    }
    //Metodos para leer
    public static String leerOpc(String mensaje,Object[] opciones){
        return (String) JOptionPane.showInputDialog(null,mensaje,"LISTA DE OPCIONES",
                JOptionPane.QUESTION_MESSAGE,null,opciones,opciones[0]);
    }
    public static int leerEntero(String mensaje){
        int valor = 0;
        boolean hayError = true;
        do {
            try{
                String temp = JOptionPane.showInputDialog(mensaje);
                if(temp==null){
                    throw new NullPointerException("");
                }
                valor = Integer.parseInt(temp);
                hayError = false;
            }
            catch (NumberFormatException varError){
                JOptionPane.showMessageDialog(null,"Debe haber un numero entero");
            }
        }while(hayError);

        return valor;
    }
}
