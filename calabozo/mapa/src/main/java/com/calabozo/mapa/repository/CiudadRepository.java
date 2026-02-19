package com.calabozo.mapa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.calabozo.mapa.model.Ciudad;
import java.util.List;

/**
 * Repositorio para la entidad Ciudad, proporcionando operaciones CRUD y
 * consultas personalizadas.
 */
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {

        /**
         * Busca ciudades por el nombre del país.
         * 
         * @param pais El nombre del país.
         * @return Una lista de ciudades que pertenecen al país especificado.
         */
        public List<Ciudad> findByPais(String pais);

        /**
         * Busca ciudades que pertenecen a una lista de países.
         * 
         * @param listaPaises Una lista de nombres de países.
         * @return Una lista de ciudades que pertenecen a cualquiera de los países en la
         *         lista.
         */
        public List<Ciudad> findByPaisIn(List<String> listaPaises);

        /**
         * Devuelve las 5 ciudades con mayor extensión.
         * 
         * @param extension La extensión mínima para filtrar (aunque el método devuelve
         *                  las 5 mayores sin usar este parámetro directamente como
         *                  filtro de valor).
         * @return Una lista de las 5 ciudades con mayor extensión.
         */
        public List<Ciudad> findTop5ByExtension(int extension);

        /**
         * Muestra la primera ciudad cuyo nombre coincida con el introducido y con la
         * mayor extensión.
         * 
         * @param nomCiudad El nombre de la ciudad a buscar.
         * @return La primera ciudad encontrada que coincida con el nombre y tenga la
         *         mayor extensión.
         */
        public Ciudad findFirstByNombreOrderByExtensionDesc(String nomCiudad);

        // Contar numero de ciudades que tengan la extension mayor que
        public int countByExtensionGreaterThan(int extension);

        // Sacar la lista de ciudades con pais como el patron de nombre igual al
        // recibido y con extension mayor o igual a la recibida
        public List<Ciudad> findByPaisLikeAndNombreOrExtensionGreaterThanEqual(String patron, String nombre,
                        int extension);

        /**
         * Obtener estadísticas de ciudades por país usando SQL nativo
         */
        @Query(value = "SELECT pais, COUNT(*) as total, AVG(num_habitantes) as promedio_habitantes, " +
                        "SUM(extension) as extension_total FROM ciudad GROUP BY pais", nativeQuery = true)
        List<Object[]> obtenerEstadisticasPorPais();

        /**
         * Buscar ciudades con al menos X calabozos (usando JOIN)
         */
        @Query(value = "SELECT c.* FROM ciudad c " +
                        "LEFT JOIN calabozo cb ON c.id = cb.id_ciudad " +
                        "GROUP BY c.id HAVING COUNT(cb.id) >= :minCalabozos", nativeQuery = true)
        List<Ciudad> ciudadesConMinCalabozos(@Param("minCalabozos") int minCalabozos);

}
