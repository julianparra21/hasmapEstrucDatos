import javax.swing.*;
import java.util.HashMap;

public class Procesos {
    double n1,n2,n3;
    int cantGanan=0,cantpierden=0,cantRecupera=0,cantPierden,cantEstudiantesvalidados=0;
    String nombre;

    HashMap<String,Double> NotasEstudiantes = new HashMap<String,Double>();
    public Procesos() {
    pedirNotas();
    }

    private void pedirNotas() {
        int cantEstudiantes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes a procesar"));

        for (int i = 0; i < cantEstudiantes; i++) {
            nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante");
            n1=validarNota(1);
            n2=validarNota(2);
            n3=validarNota(3);



            double promedio = (n1+n2+n3)/3;

            if (promedio>=3.5) {
                JOptionPane.showMessageDialog(null, "El estudiante "+nombre+
                        " aprobo con un promedio de "+promedio);
                cantGanan++;
            }else{
                JOptionPane.showMessageDialog(null, "El estudiante "+nombre+
                        " reprobo con un promedio de "+promedio);
                cantpierden++;
            }
            if (promedio > 2.0 && promedio < 3.5) {
                cantRecupera++;
            }else if (promedio < 2.0) {
                cantPierden++;
            }
            NotasEstudiantes.put(nombre,promedio);
            cantEstudiantesvalidados++;
        }
        imprimirDatos();
        System.out.println("-----------------------------");
        promedioTotal();
        System.out.println("-----------------------------");
        mostrarEstudiantes();


    }

    private double validarNota(int n) {
        double nota =0;
       do {
                nota = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota "+n+" del estudiante "+nombre));
                if (nota<0 || nota>5) {
                    JOptionPane.showMessageDialog(null, "La nota"+n+" debe estar entre 0 y 5");
                }
            } while (nota<0 || nota>5);
        return nota;
    }


    private void mostrarEstudiantes() {
        System.out.println("lista estudiantes");
        for (String key : NotasEstudiantes.keySet()) {
            System.out.println("Nombre: "+key+" | "+" promedio: "+NotasEstudiantes.get(key));
        }
    }
    private void promedioTotal() {
        double promedioTotal = 0;
        for(String key : NotasEstudiantes.keySet()){
            promedioTotal += NotasEstudiantes.get(key);
        }
        System.out.println("El promedio total es: "+promedioTotal/NotasEstudiantes.size());
    }
    private void imprimirDatos() {
        System.out.println("Cantidad de estudiantes validados: "+cantEstudiantesvalidados);
        System.out.println("cantidad de notas ingresadas: "+cantEstudiantesvalidados*3);
        System.out.println("Cantidad de estudiantes que ganan: "+cantGanan);
        System.out.println("Cantidad de estudiantes que pierden: "+cantpierden);
        System.out.println("Cantidad de estudiantes que pueden recuperar: "+cantRecupera);
        System.out.println("Cantidad de estudiantes que pierden sin recuperacion: "+cantPierden);


    }
}
