import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SalaChat implements ChatMediator {
    private HashMap<String, Usuario> usuarios = new HashMap<>();
    private HashMap<String, List<String>> mensajesUsuario = new HashMap<>();

    @Override
    public void registrarUsuario(Usuario usuario) {
        try {
            String nombreUsuario = usuario.getNombre();
            if (usuarioExiste(nombreUsuario)){
                throw new Exception();
            }
            usuarios.put(usuario.getNombre(),usuario);
            mensajesUsuario.put(nombreUsuario, new ArrayList<>());
            System.out.println("Usuario '"+ nombreUsuario +"' registrado con exito");

        }catch (Exception ex){
            System.out.println("Usuario '" + usuario.getNombre() + "' ya existe");
        }
    }

    @Override
    public void enviarMensaje(String emisor, String receptor, String mensaje) {
        try {
            if (!usuarioExiste(receptor) || !usuarioExiste(emisor)){
                throw new RuntimeException();
            }
            Usuario usuario = usuarios.get(receptor);
            usuario.recibirMensaje(emisor,mensaje);
            mensajesUsuario.get(receptor).add(mensaje);
        }catch (Exception ex){
            System.out.println("Uno de los usuarios no existe");
        }
    }

    @Override
    public List<String> obtenerMensajes(String nombreUsuario) {
        try {
            if (!usuarioExiste(nombreUsuario)){
                throw new Exception();
            }
            return mensajesUsuario.get(nombreUsuario);
        }catch (Exception ex){
            System.out.println("El usuario '" + nombreUsuario + "' no existe");
            return null;
        }
    }

    @Override
    public boolean usuarioExiste(String nombreUsuario) {
        return usuarios.containsKey(nombreUsuario);
    }
}
