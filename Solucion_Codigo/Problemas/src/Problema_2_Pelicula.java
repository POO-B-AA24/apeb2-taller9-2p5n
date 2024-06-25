import java.text.DecimalFormat;
import java.util.Random;
public class Problema_2_Pelicula {
    public static void main(String[] args) {
        Random random = new Random();
        String peliculas[] = {"PI", "Bohemian Rhapsody", "The sound of Metal", "Barbie", "300", "Imperio"};
        String autores[] = {"Alfredo", "Jesus", "Fabian", "Maria", "Carlos", "Ana"};
        String anios[] = {"2024", "2023", "2022", "2020", "2021", "2019"};
        String idiomas[] = {"Ingles", "Aleman", "Espaniol"};
        int num = 3;
        int idiomaRandom = 0;
        System.out.println("Numero de peliculas a comprar: " + num);
        System.out.println("Peliculas disponibles: ");
        for (int j = 0; j < peliculas.length; j++) {
            System.out.println((j + 1) + ") " + peliculas[j]);
        }
        for (int i = 0; i < num; i++) {
            int peliculaRandom = random.nextInt(peliculas.length);
            String titulo = peliculas[peliculaRandom];
            String autor = autores[peliculaRandom];
            String anio = anios[peliculaRandom];
            String idioma = idiomas[idiomaRandom];
            idiomaRandom = (idiomaRandom + 1) % idiomas.length;
            boolean DVD = random.nextBoolean();
            double dvdGb = 0;
            String tipoCinta = null;
            if (DVD) { 
                dvdGb = 4.5 + random.nextDouble() * 5.5; // Tamaño de DVD entre 4.5 y 10.0 GB
            } else {
                String[] tiposCinta = {"HQ", "Estandas", "VHS-C"};
                tipoCinta = tiposCinta[random.nextInt(tiposCinta.length)];
            }
            Pelicula pelicula = new Pelicula(titulo, autor, anio, idioma, DVD, dvdGb, tipoCinta);
            System.out.println(pelicula);
        }
    }
}
class Pelicula {
    String titulo;
    String autor;
    String anio;
    String idioma;
    double precio;
    boolean DVD;
    double dvdGb;
    String tipoCinta;
    public Pelicula(String titulo, String autor, String anio, String idioma, boolean DVD, double dvdGb, String tipoCinta) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.idioma = idioma;
        this.DVD = DVD;
        this.dvdGb = dvdGb;
        this.tipoCinta = tipoCinta;
        this.precio = calcularPrecio();
    }
    public double calcularPrecio() {
        switch (this.titulo) {
            case "PI":
                this.precio = 30;
                break;
            case "Bohemian Rhapsody":
                this.precio = 25;
                break;
            case "The sound of Metal":
                this.precio = 20;
                break;
            case "Barbie":
                this.precio = 15;
                break;
            case "300":
                this.precio = 10;
                break;
            case "Imperio":
                this.precio = 5;
                break;
            default:
                this.precio = 10;
                break;
        }
        if (DVD) {
            this.precio *= 1.1;
        }
        return this.precio;
    }
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        String dvdGbFormatted = df.format(dvdGb);
        String precioFormatted = df.format(precio);
        
        if (DVD) {
            return "Pelicula{" + "titulo=" + titulo + ", autor=" + autor + ", anio=" + anio + ", idioma=" + idioma + ", precio=" + precioFormatted + ", soporte=Dvd{gb=" + dvdGbFormatted + "} }";
        } else {
            return "Pelicula{" + "titulo=" + titulo + ", autor=" + autor + ", anio=" + anio + ", idioma=" + idioma + ", precio=" + precioFormatted + ", soporte=Vhs{tipoCinta=" + tipoCinta + "} }";
        }
    }
}