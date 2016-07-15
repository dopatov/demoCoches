package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface CocheRepository extends JpaRepository<Coche,Long> {

    List<Coche> findByMarca (String marca);

    List<Coche> findByAño(Integer año);

    List<Coche> findByMarcaAndModelo (String marca, String modelo);

    List<Coche> findByAñoGreaterThanEqual (Integer año);

    List<Coche> findByAñoLessThanEqual (Integer año);

    List<Coche> findByAñoBetween (Integer min, Integer max);

    List<Coche> findByPrecioGreaterThanEqual(Double precio);

    List<Coche> findByPrecioLessThanEqual(Double precio);

    List<Coche> findByPrecioBetween(Double min, Double max);

    Coche findByMatricula(String matricula);

    List<Coche> findByMarcaAndPrecioLessThanEqual(String marca, Double precio);

    List<Coche> findByMarcaAndPrecioGreaterThanEqual(String marca, Double precio);

    @Query("SELECT AVG (coche.precio) from Coche coche where coche.marca = :marca")
    Double obtenerMediaPorMarca(@Param("marca") String marca);//("marca") tiene que coincidir con lo que se pide arriba
    //Media del precio para los coches en los que la marca sea: tal marca. AVG-Media.

    List<Coche> findByPropietario(Persona propietario);

    /*
    OPCIÓN B:
    @Query("SELECT(coche)from Coche coche where coche.propietario= :propietario")
    List<Coche>obtenerCochesPorPropietario(@Param("propietario")Persona propietario);
     */

    List<Coche> findByPropietarioAndPrecioGreaterThanEqual(Persona propietario, Double precio);

    List<Coche> findByPropietarioAndAñoBetween(Persona propietario, Integer min, Integer max);

    @Query("SELECT coche from Coche coche where coche.propietario = :propietario " +
            "and coche.precio >= :precio ")
    List<Coche> obetenerCochesPorPropietarioYPrecioSuperior(
            @Param("propietario") Persona propietario,
            @Param("precio") Double precio);

    @Query("SELECT coche from Coche coche where coche.propietario = :propietario and coche.año between :minAño and :maxAño")
    List<Coche> cochesPorPropietarioYAños(
            @Param("propietario") Persona propietario,
            @Param("minAño") Integer minAño,
            @Param("maxAño") Integer maxAño);

    @Query("SELECT coche from Coche coche where propietario.edad >= :edad")
    List<Coche> obtenerCochesPorEdadPropietario(@Param("edad") Integer edad);

    @Query("SELECT coche from Coche coche where propietario.edad between :minEdad and :maxEdad")
    List<Coche> obtenerCocheEntreEdades(
            @Param("minEdad") Integer minEdad,
            @Param("maxEdad") Integer maxEdad);

    @Query("SELECT coche from Coche coche where coche.matricula LIKE(CONCAT('%',:letrasMatricula,'%'))")
    List<Coche> obtenerMatriculaPorLetras(@Param("letrasMatricula") String letrasMatricula);

    @Query("SELECT (coche.marca), AVG(coche.precio), MIN(coche.precio),MAX(coche.precio) from Coche coche GROUP BY coche.marca")
    List<Object[]> obtenerMediaMaxYMin();

    @Query("SELECT coche.año, COUNT(coche) from Coche coche GROUP BY coche.año")
    List<Object[]> obtenerCochesFabricadosAño();


}

