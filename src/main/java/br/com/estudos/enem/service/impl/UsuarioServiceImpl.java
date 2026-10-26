package br.com.estudos.enem.service.impl;


import br.com.estudos.enem.entity.Usuario;
import br.com.estudos.enem.repository.UsuarioRepository;
import br.com.estudos.enem.service.UsuarioService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario save(Usuario newUser){
        if(newUser.getNome() == null|| newUser.getNome().isBlank() || newUser.getEmail() == null || newUser.getEmail().isBlank() ||
                newUser.getSenhaHash() == null || newUser.getSenhaHash().isBlank()){
            throw new IllegalArgumentException("Usuario Invalido");
        }
        return usuarioRepository.save(newUser);
    }

    @Override
    public Usuario update(Long id, Usuario updateUser){
        Usuario newUser = usuarioRepository.findById(id).orElseThrow(() ->  new IllegalArgumentException("Usuario nao encontrado"));


        newUser.setNome(updateUser.getNome());
        newUser.setEmail(updateUser.getEmail());
        newUser.setSenhaHash(updateUser.getSenhaHash());

        return usuarioRepository.save(newUser);
    }

    @Override
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }

    @Override
    public Usuario disabled(Long id) {
        Usuario user = findById(id);
        user.setAtivo(false);
        return usuarioRepository.save(user);
    }

    @Override
    public Usuario enable(Long id) {
        Usuario user = findById(id);
        user.setAtivo(true);
        return usuarioRepository.save(user);
    }
}
