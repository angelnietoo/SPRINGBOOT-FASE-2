package com.calabozo.mapa.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.calabozo.mapa.model.User;

/**
 * Repositorio para la entidad User, proporcionando operaciones CRUD y consultas
 * personalizadas.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Busca un usuario por su dirección de email.
     * 
     * @param email La dirección de email del usuario.
     * @return Un Optional que contiene el usuario si se encuentra, o vacío si no.
     */
    Optional<User> findByEmail(String email);

    /**
     * Busca un usuario por su ID de Google.
     * 
     * @param googleId El ID de Google del usuario.
     * @return Un Optional que contiene el usuario si se encuentra, o vacío si no.
     */
    Optional<User> findByGoogleId(String googleId);

    /**
     * Verifica si existe un usuario con la dirección de email especificada.
     * 
     * @param email La dirección de email a verificar.
     * @return true si existe un usuario con ese email, false en caso contrario.
     */
    Boolean existsByEmail(String email);
}
