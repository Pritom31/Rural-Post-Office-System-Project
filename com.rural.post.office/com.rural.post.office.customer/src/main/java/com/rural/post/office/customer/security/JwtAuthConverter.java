//package com.rural.post.office.customer.security;
//
//import org.springframework.security.authentication.AbstractAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.oauth2.jwt.Jwt;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.Map;
//
//public class JwtAuthConverter implements Converter<Jwt, AbstractAuthenticationToken>{
//    @Override
//    public AbstractAuthenticationToken convert(Jwt jwt) {
//
//        Collection<GrantedAuthority> authorities =
//                extractRoles(jwt);
//
//        return new JwtAuthenticationToken(jwt, authorities);
//    }
//
//    private Collection<GrantedAuthority> extractRoles(Jwt jwt) {
//
//        Map<String, Object> realmAccess =
//                jwt.getClaim("realm_access");
//
//        if (realmAccess == null || !realmAccess.containsKey("roles")) {
//            return List.of();
//        }
//
//        @SuppressWarnings("unchecked")
//        List<String> roles = (List<String>) realmAccess.get("roles");
//
//        return roles.stream()
//                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
//                .toList();
//    }
//}
