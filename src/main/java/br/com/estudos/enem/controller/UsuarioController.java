package br.com.estudos.enem.controller;
import br.com.estudos.enem.service.UsuarioService;
import br.com.estudos.enem.entity.Usuario;
import br.com.estudos.enem.dto.UsuarioResponse;
import br.com.estudos.enem.dto.UsuarioCadastroRequest;
import br.com.estudos.enem.dto.UsuarioUpdateRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;


    public UsuarioController(UsuarioService usuarioService) {


        this.usuarioService = usuarioService;
    }

    private UsuarioResponse converter(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.isAtivo()
        );
    }

    @PostMapping
    public UsuarioResponse save(@RequestBody UsuarioCadastroRequest request) {

        Usuario usuario = new Usuario();

        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuario.setSenhaHash(request.getSenha());

        Usuario usuarioSalvo = usuarioService.save(usuario);

        return converter(usuarioSalvo);
    }

    @PutMapping("/{id}")
    public UsuarioResponse update(@PathVariable Long id, @RequestBody UsuarioUpdateRequest request) {

        Usuario usuario = new Usuario();

        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());

        Usuario usuarioAtualizado = usuarioService.update(id, usuario);

        return converter(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestBody Long id) {

        usuarioService.delete(id);
    }
    @GetMapping("/{id}")
    public UsuarioResponse findById(@PathVariable Long id) {

        Usuario usuario = usuarioService.findById(id);

        return converter(usuario);
    }

    @PatchMapping("/{id}/desativacao")
    public Usuario disable(@PathVariable Long id) {
        return usuarioService.disabled(id);
    }

    @PatchMapping("/{id}/ativacao")
    public Usuario enable(@PathVariable Long id) {
        return usuarioService.enable(id);
    }


}
