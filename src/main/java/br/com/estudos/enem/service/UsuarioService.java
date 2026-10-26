package br.com.estudos.enem.service;
import org.springframework.stereotype.Service;
import br.com.estudos.enem.entity.Usuario;



@Service
public interface UsuarioService {
    Usuario save(Usuario usuario);
    Usuario update(Long id, Usuario usuario);
    void  delete(Long id);
    Usuario findById(Long id);
    Usuario disabled(Long id);
    Usuario enable(Long id);
}
