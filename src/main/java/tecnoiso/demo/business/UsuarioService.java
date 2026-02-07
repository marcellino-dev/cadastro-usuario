package tecnoiso.demo.business;

import org.springframework.stereotype.Service;
import tecnoiso.demo.infrastructure.entitys.Usuario;
import tecnoiso.demo.infrastructure.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }
    public void salvarUsuario(Usuario usuario) {
        repository.saveAndFlush(usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email){
        return repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("email não encontrado"));

    }
    public void deletarUsuarioPorEmail(String email){
repository.deleteByEmail(email);

}
    public void atualizarUsuarioPorId(Integer id, Usuario usuario) {
        Usuario usuarioEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        Usuario usuarioAtualizado = Usuario.builder()
                .id(usuarioEntity.getId())
                .email(usuario.getEmail() != null
                        ? usuario.getEmail()
                        : usuarioEntity.getEmail())
                .nome(usuario.getNome() != null
                        ? usuario.getNome()
                        : usuarioEntity.getNome())
                .build();

        repository.saveAndFlush(usuarioAtualizado);

    }

}
