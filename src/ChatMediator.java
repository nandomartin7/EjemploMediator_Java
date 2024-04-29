import java.util.List;

public interface ChatMediator {
    void registrarUsuario (Usuario usuario);
    void enviarMensaje(String emisor, String receptor, String mensaje);
    List<String> obtenerMensajes(String nombreUsuario);
    boolean usuarioExiste(String nombreUsuario);

}
