package br.com.estudos.enem.controller;
import br.com.estudos.enem.service.UsuarioService;
import br.com.estudos.enem.entity.Usuario;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;


    public UsuarioController(UsuarioService usuarioService) {

        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario save(@RequestBody Usuario usuario) {

        return usuarioService.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario update(@RequestBody Usuario usuario) {

        return usuarioService.update(usuario.getId(), usuario);
    }
    @DeleteMapping("/{id}")
    public void delete(@RequestBody Long id) {

        usuarioService.delete(id);
    }
    @GetMapping("/{id}")
    public Usuario findById(@PathVariable Long id) {
        return usuarioService.findById(id);
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
