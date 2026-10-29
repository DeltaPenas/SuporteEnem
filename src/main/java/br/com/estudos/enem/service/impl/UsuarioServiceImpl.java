package br.com.estudos.enem.service.impl;


import br.com.estudos.enem.config.PasswordConfig;
import br.com.estudos.enem.entity.Usuario;
import br.com.estudos.enem.repository.UsuarioRepository;
import br.com.estudos.enem.service.UsuarioService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {

        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Usuario save(Usuario newUser){
        if(newUser.getNome() == null|| newUser.getNome().isBlank() || newUser.getEmail() == null || newUser.getEmail().isBlank() ||
                newUser.getSenhaHash() == null || newUser.getSenhaHash().isBlank()){
            throw new IllegalArgumentException("Usuario Invalido");
        }
        if(usuarioRepository.existsByEmail(newUser.getEmail())){
            throw new IllegalArgumentException("Email ja cadastrado");
        }
        String criptPassword = passwordEncoder.encode(newUser.getSenhaHash());
        newUser.setSenhaHash(criptPassword);

        return usuarioRepository.save(newUser);
    }

    @Override
    public Usuario update(Long id, Usuario usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        if (usuario.getNome() == null || usuario.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome é obrigatório");
        }

        if (usuario.getEmail() == null || usuario.getEmail().isBlank()) {
            throw new IllegalArgumentException("O email é obrigatório");
        }
        if(usuarioRepository.existsByEmail(usuario.getEmail())){
            throw new IllegalArgumentException("O email já foi utilizado");
        }

        usuarioExistente.setNome(usuario.getNome());
        usuarioExistente.setEmail(usuario.getEmail());

        return usuarioRepository.save(usuarioExistente);
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
    @Override
    public Usuario updatePassword(Long id, String newPassword){
        Usuario updatedPasswordUser = usuarioRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Usuário não encontrado"));
        updatedPasswordUser.setSenhaHash(passwordEncoder.encode(newPassword));
        return usuarioRepository.save(updatedPasswordUser);
    }

}
