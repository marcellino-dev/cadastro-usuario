package tecnoiso.demo.infrastructure.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import tecnoiso.demo.infrastructure.entitys.Usuario;

import java.beans.Transient;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository <Usuario,Integer> {
    Optional<Usuario> findByEmail(String email);

    @Transactional
    void  deleteByEmail (String email);
}
