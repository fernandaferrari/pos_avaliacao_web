package com.avaliacao.web.avaliacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.avaliacao.web.avaliacao.model.Usuario;
import com.avaliacao.web.avaliacao.repository.UsuarioRepository;

public class UsuarioService implements UserDetailsService{

	@Autowired private UsuarioRepository usuarioRepository;
	@Autowired private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByNome(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado: " + username);
        }
        return org.springframework.security.core.userdetails.User
            .withUsername(username)
            .password(usuario.getSenha())
            .roles("USER")
            .build();
	}

	public void save(Usuario user) {
		String senhaCriptografada = passwordEncoder.encode(user.getSenha());
		user.setSenha(senhaCriptografada);
		usuarioRepository.save(user);
	}
}
