import java.util.ArrayList;
import java.util.Random;
public class Problema_5_Teatro {
    public static void main(String[] args) {
        ArrayList<Zona> listaZonas = new ArrayList<>();
        listaZonas.add(new Zona("Principal", 100, 50, 10.6));
        listaZonas.add(new Zona("Palco B", 20, 40, 32.12));
        listaZonas.add(new Zona("Central", 200, 70, 5.4));
        listaZonas.add(new Zona("Lateral", 50, 10, 8.3));
        venderEntrada(listaZonas, "Jesus", 1);
        venderEntrada(listaZonas, "Juan", 2);
        venderEntrada(listaZonas, "Gabriela", 3);
    }
    static void venderEntrada(ArrayList<Zona> listaZonas, String nombreEspectador, int tipoEntrada) {
        Random random = new Random();
        int ZonaRandom = random.nextInt(listaZonas.size());
        Zona zona = listaZonas.get(ZonaRandom);
        if (zona.verificarPuesto()) {
            Entrada entrada = null;
            switch (tipoEntrada) {
                case 1:
                    entrada = new EntradaNormal(zona, nombreEspectador);
                    break;
                case 2:
                    entrada = new EntradaAbonado(zona, nombreEspectador);
                    break;
                case 3:
                    entrada = new EntradaReducida(zona, nombreEspectador);
                    break;
                default:
                    System.out.println("Tipo de entrada incorrecto");
                    return;
            }
            zona.ocuparPuesto();
            entrada.calcularPrecioEntrada();
            entrada.asignarID();
            System.out.println("Entrada vendida: " + entrada);
        } else {
            System.out.println("No hay cupos disponibles en la zona " + zona.nombre);
        }
    }
}
class Zona {
    public String nombre;
    public int capacidad;
    public double precioNormal;
    public double precioAbonado;
    public Zona(String nombre, int capacidad, double precioNormal, double precioAbonado) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precioNormal = precioNormal;
        this.precioAbonado = precioAbonado;
    }
    public boolean verificarPuesto() {
        return capacidad > 0;
    }
    public void ocuparPuesto() {
        capacidad--;
    }
}
class Entrada {
    public Zona zona;
    public int id;
    public String nombreComprador;
    public double precio;
    public Entrada(Zona zona, String nombreComprador) {
        this.zona = zona;
        this.nombreComprador = nombreComprador;
    }
    public double calcularPrecioEntrada() {
        this.precio = this.zona.precioNormal; // Precio normal por defecto
        return precio;
    }
    public void asignarID() {
        Random random = new Random();
        int numeroAleatorio = 10000 + random.nextInt(90000);
        this.id = numeroAleatorio;
    }
    @Override
    public String toString() {
        return "Entrada{" + "zona=" + zona + ", id=" + id + ", nombreComprador=" + nombreComprador + ", precio=" + precio + '}';
    }
}
class EntradaNormal extends Entrada {
    public EntradaNormal(Zona zona, String nombreComprador) {
        super(zona, nombreComprador);
    }
}
class EntradaReducida extends Entrada {
    public EntradaReducida(Zona zona, String nombreComprador) {
        super(zona, nombreComprador);
    }
    @Override
    public double calcularPrecioEntrada() {
        this.precio = super.calcularPrecioEntrada() * 0.85; // Precio reducido al 85%
        return precio;
    }
}
class EntradaAbonado extends Entrada {
    public EntradaAbonado(Zona zona, String nombreComprador) {
        super(zona, nombreComprador);
    }
    @Override
    public double calcularPrecioEntrada() {
        this.precio = this.zona.precioAbonado; // Precio abonado específico de la zona
        return precio;
    }
}