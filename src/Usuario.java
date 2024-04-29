import java.util.List;

public class Usuario {
    private String nombre;
    private ChatMediator mediator;

    public Usuario(String nombre, ChatMediator mediator) {
        this.nombre = nombre;
        this.mediator = mediator;
    }

    public void enviarMensaje(String receptor, String mensaje){
        mediator.enviarMensaje(nombre, receptor, mensaje);
    }

    public void recibirMensaje(String emisor, String mensaje){
        System.out.println(nombre + " recibe mensaje de "+ emisor + ": " + mensaje);
    }

    public List<String> obtenerMensajes(){
        return mediator.obtenerMensajes(nombre);
    }

    public String getNombre() {
        return nombre;
    }
}
