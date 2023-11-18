package com.projetointegrador.app.rest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetointegrador.app.rest.Models.Usuario;
import com.projetointegrador.app.rest.Repo.UsuarioRepository;

@RestController
public class ApiControllers {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@GetMapping(value="/")
	public String getPage(){
		return "TAMO AKI";
	}
	
	@GetMapping(value = "/users")
	public List<Usuario> getUsers(){
		return usuarioRepo.findAll();
	}
	
	@PostMapping( value ="/saveUser" )
	public String saveUser(@RequestBody Usuario usuario) {
		usuarioRepo.save(usuario);
		return "USUARIO SALVO";
	}
	
	@PutMapping(value = "update/{id}")
	public String updateUser(@PathVariable long id, @RequestBody Usuario usuario) {
		
		Usuario updateUsuario = usuarioRepo.findById(id).get();
		
		updateUsuario.setAtivo(usuario.isAtivo());
		updateUsuario.setDataCadastro(usuario.getDataCadastro());
		updateUsuario.setDataNascimento(usuario.getDataNascimento());
		updateUsuario.setLogin(usuario.getLogin());
		updateUsuario.setSenha(usuario.getSenha());
		updateUsuario.setNome(usuario.getNome());
		
		usuarioRepo.save(updateUsuario);
		
		return "USUARIO ATUALIZADO";
		
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String deleteUser(@PathVariable long id){
		Usuario deleteUser = usuarioRepo.findById(id).get();
		
		usuarioRepo.delete(deleteUser);
		
		return "USUARIO DELETADO ID:"+id;
		
	}
	
}
