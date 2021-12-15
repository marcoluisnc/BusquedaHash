package Testing;

import java.util.Arrays;

public class HashT {
    String [] arreglo;
    int tamaño,contador;

    public HashT(int tam) {
        tamaño = tam;
        arreglo=new String[tam];
        Arrays.fill(arreglo,"-1");
    }
    public void funcionHash(String []cadenaArreglo){
        for(int i=0;i< cadenaArreglo.length;i++){
            String elemento= cadenaArreglo[i];
            int indiceArreglo=Integer.parseInt(elemento)%(tamaño-1);
            System.out.println("El indice es "+indiceArreglo+" Para el sueldo de cantidad:  $"+ elemento);
            //colisiones
            while(Integer.parseInt(arreglo[indiceArreglo])!=-1){
                indiceArreglo++;
                System.out.println("Ocurrio una colision en el indice "+(indiceArreglo-1)+" Cambiar el indice "+ indiceArreglo);
                indiceArreglo%=tamaño;
            }
            arreglo[indiceArreglo]=elemento;
        }
    }

    public String buscarClave(String elemento){
        int indiceArreglo=Integer.parseInt(elemento) % (tamaño-1);
        contador=0;
        try {
            while (Integer.parseInt(arreglo[indiceArreglo]) != -1) {
                if (arreglo[indiceArreglo].equals(elemento)) {
                    System.out.println();
                    return "El indice es " + indiceArreglo + " Para el sueldo de cantidad:  $" + elemento;
                }
                indiceArreglo++;
                indiceArreglo %= tamaño;
                contador++;
                if (contador > (tamaño - 1)) {
                    break;
                }
            }
        }catch (NullPointerException e){
            System.out.println("Regresar");
        }
        return  "La clave "+elemento+" No fue encontrada ";
    }

    public void mostrar(String [] cadenaArreglo) {
        /*for(int i=0;i< cadenaArreglo.length;i++){
            String elemento= cadenaArreglo[i];
            int indiceArreglo=Integer.parseInt(elemento)%(tamaño-1);
            System.out.println("El indice es "+indiceArreglo+" Para el sueldo de cantidad:  $"+ elemento);
        }

         */
        int incremento=0, i, j;
        for (i = 0; i < 1; i++) {
            incremento+=20;//Debe de ser deacuerdo al numero de elementos
            for (j = 0;j<71; j++) {
                System.out.print("-");
            }
            System.out.println();
            for(j=incremento-20; j<incremento; j++){
                System.out.format("|%3s"+" ",j);
            }
            System.out.println("|");
            for(int n=0; n<71; n++){
                System.out.print("-");
            }
            System.out.println();
            for(j=incremento-20; j<incremento; j++){
                if(arreglo[j].equals("-1")){
                    System.out.print(String.format("|%3s"+" ",j));
                }else{
                    System.out.print(String.format("|%3s", arreglo[j]));
                }
            }
            System.out.println("|");
            for(j=0; j<71; j++){
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
