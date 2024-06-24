package com.example.cidades.security;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.example.cidades.domain.model.Usuario;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    private JwtUtil jwtUtil;
    private UserDetailsSecurityServer userDetailsSecurityServer;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil,
                                  UserDetailsSecurityServer userDetailsSecurityServer) {
        super(authenticationManager);
        this.jwtUtil = jwtUtil;
        this.userDetailsSecurityServer = userDetailsSecurityServer;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            System.out.println("Token recebido: " + token); // Log do token
            UsernamePasswordAuthenticationToken auth = getAuthenticationToken(token);
            if (auth != null && auth.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(auth);
                System.out.println("Autenticação bem-sucedida para o usuário: " + auth.getName());
            } else {
                System.out.println("Falha na autenticação");
            }
        } else {
            System.out.println("Cabeçalho Authorization ausente ou não começa com Bearer");
        }
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthenticationToken(String token) {
        if (jwtUtil.isValidToken(token)) {
            String email = jwtUtil.getUserName(token);
            Usuario usuario = (Usuario) userDetailsSecurityServer.loadUserByUsername(email);
            return new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
        }
        return null;
    }
}
