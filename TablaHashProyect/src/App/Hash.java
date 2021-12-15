package App;

public class Hash {
    int dato,saldo,estado;
    String nombre;
    public static void insertHash(Hash[] h, int tama, int n, String name, int saldo) {
        boolean i = false;
        int j = n%tama;
        do {
            if (h[j].estado == 0 || h[j].estado == 1) {
                h[j].estado = 2;
                h[j].dato = n;
                h[j].nombre=name;
                h[j].saldo=saldo;
                i = true;
            } else {
                j++;
                j%=tama;
            }
        } while (j < tama && i == false);
    }
    public static int searchHash(Hash[] h, int tama, int n) {
        int j = n%tama;
        while (j < tama) {
            if (h[j].estado == 0) {
                return -1;
            } else if (h[j].dato == n) {
                if (h[j].estado == 1) {
                    return -1;
                } else {
                    System.out.print("Key: "+h[j].dato+"\nNombre: "+h[j].nombre+"\nSaldo: "+h[j].saldo+"\n");
                    return j;
                }
            } else {
                j++;
                j%=tama;
            }
        }
        return -1;
    }

    public static void showHashTable(Hash[] h){
        int cont = 0;
        for(int i=0;i<h.length;i++){
            System.out.println("Pos "+cont+"\nClave: "+h[i].dato+"\nNombre: "+h[i].nombre+"\nSaldo: "+h[i].saldo+"\n");
            cont++;
        }
        for(int i = 0; i<71;i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static int deleteHashTable(Hash[] h, int tama, int n) {
        int i = searchHash(h, tama, n);
        if (i == -1) {
            return -1;
        } else {
            h[i].estado = 1;
            h[i].dato=0;
            h[i].nombre="";
            h[i].saldo=0;
            return 1;
        }
    }

}
