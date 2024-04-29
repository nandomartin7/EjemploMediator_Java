import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ChatMediator mediator = new SalaChat();

        int opcion=0;
        while (opcion !=4){
            System.out.println("Seleccione una opcion: \n1. Crear nuevo usuario\n2. Enviar mensaje\n3. Ver mensajes recibidos\n4. Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("Ingrese el nombre del nuevo usuario: ");
                    String nombreUsNuevo = sc.nextLine();

                    Usuario usuario = new Usuario(nombreUsNuevo, mediator);
                    mediator.registrarUsuario(usuario);
                break;
                case 2:
                    System.out.println("Emisor: ");
                    String emisor = sc.nextLine();

                    System.out.println("Receptor: ");
                    String receptor = sc.nextLine();

                    System.out.println("Mensaje: ");
                    String mensaje = sc.nextLine();

                    mediator.enviarMensaje(emisor,receptor,mensaje);
                break;
                case 3:
                    System.out.println("Nombre del usuario: ");
                    String nombreUser = sc.nextLine();

                    List<String> mensajes = mediator.obtenerMensajes(nombreUser);
                    if (mensajes != null){
                        System.out.println("Mensajes para '"+ nombreUser +"': ");
                        for (String msm : mensajes){
                            System.out.println("- "+ msm);
                        }
                    } else if (mensajes.isEmpty()) {
                        System.out.println("No hay mensajes para "+nombreUser);
                    }
                    break;
                case 4:

                break;
                default:
                    System.out.println("Opcion Incorrecta");
                break;
            }
        }
    }
}
