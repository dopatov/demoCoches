package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CocheService {

    @Autowired
    private CocheRepository cocheRepository;

    @Autowired
    private PersonaRepository personaRepository;

    public void testCoches() {

        Coche seatIbiza = new Coche();
        seatIbiza.setMarca("Seat");
        seatIbiza.setModelo("Ibiza");
        seatIbiza.setPrecio(9500.00);
        seatIbiza.setMatricula("1578LGH");
        seatIbiza.setAño(2015);
        Persona noelia = personaRepository.findOne(3L);
        seatIbiza.setPropietario(noelia);
        cocheRepository.save(seatIbiza);

        Coche seatLeon = new Coche();
        seatLeon.setMarca("Seat");
        seatLeon.setModelo("Leon");
        seatLeon.setPrecio(2500.00);
        seatLeon.setMatricula("9452PKL");
        seatLeon.setAño(1999);

        Persona persona = new Persona();
        persona.setNombre("Lucas");
        persona.setEdad(23);
        personaRepository.save(persona);
        seatLeon.setPropietario(persona);
        cocheRepository.save(seatLeon);

        Coche opelCorsa = new Coche();
        opelCorsa.setMarca("Opel");
        opelCorsa.setModelo("Corsa");
        opelCorsa.setPrecio(7700.00);
        opelCorsa.setMatricula("7531HGF");
        opelCorsa.setAño(2012);
        Persona ivan = personaRepository.findOne(1L);
        opelCorsa.setPropietario(ivan);
        cocheRepository.save(opelCorsa);

        Coche porschePanamera = new Coche();
        porschePanamera.setMarca("Porsche");
        porschePanamera.setModelo("Panamera");
        porschePanamera.setPrecio(69900.00);
        porschePanamera.setMatricula("9632PLK");
        porschePanamera.setAño(2011);
        porschePanamera.setPropietario(noelia);
        cocheRepository.save(porschePanamera);

        Coche porscheCarrera911 = new Coche();
        porscheCarrera911.setMarca("Porsche");
        porscheCarrera911.setModelo("Carrera911");
        porscheCarrera911.setPrecio(55000.00);
        porscheCarrera911.setMatricula("9899BVS");
        porscheCarrera911.setAño(1995);
        Persona dimple = personaRepository.findOne(2L);
        porscheCarrera911.setPropietario(dimple);
        cocheRepository.save(porscheCarrera911);

        Coche opelCorsa2 = new Coche();
        opelCorsa2.setMarca("Opel");
        opelCorsa2.setModelo("Corsa");
        opelCorsa2.setPrecio(8500.00);
        opelCorsa2.setMatricula("76955JFK");
        opelCorsa2.setAño(2012);
        Persona ricard = personaRepository.findOne(5L);
        opelCorsa2.setPropietario(ricard);
        cocheRepository.save(opelCorsa2);

        Coche bmwX5 = new Coche();
        bmwX5.setMarca("BMW");
        bmwX5.setModelo("X5");
        bmwX5.setPrecio(61500.00);
        bmwX5.setMatricula("7569HDP");
        bmwX5.setAño(2016);
        Persona jordi = personaRepository.findOne(4L);
        bmwX5.setPropietario(jordi);
        cocheRepository.save(bmwX5);

        System.out.println("Los coches cuyo año de fabricación es igual o mayor a 2007:");
        System.out.println(cocheRepository.findByAñoGreaterThanEqual(2007));

        System.out.println("Los coches cuyo año de fabricación es igual o menor a 2007:");
        System.out.println(cocheRepository.findByAñoLessThanEqual(2007));

        System.out.println("Los coches fabricados entre 1995 y 2008 son: ");
        System.out.println(cocheRepository.findByAñoBetween(1995,2008));

        System.out.println("Los coches cuyo precio de fabricación es igual o mayor a 10.000euros:");
        System.out.println(cocheRepository.findByPrecioGreaterThanEqual(10000.00));

        System.out.println("Los coches cuyo precio es igual o menor a 10.000euros:");
        System.out.println(cocheRepository.findByPrecioLessThanEqual(10000.00));

        System.out.println("Los coches cuyo precio se encuentra entre los 8.000 y los 66.000euros son: ");
        System.out.println(cocheRepository.findByPrecioBetween(8000.00, 66000.00));

        System.out.println("El coche con matrícula 7569HDP es: ");
        System.out.println(cocheRepository.findByMatricula("7569HDP"));

        System.out.println("Los PORSCHE son: ");
        System.out.println(cocheRepository.findByMarca("Porsche"));

        System.out.println("Los Opel Corsa son: ");
        System.out.println(cocheRepository.findByMarcaAndModelo("Opel", "Corsa"));

        System.out.println("Los Seat con precio igual o inferior a 5.000euros son: ");
        System.out.println(cocheRepository.findByMarcaAndPrecioLessThanEqual("Seat", 5000.00));

        System.out.println("Los Seat con precio igual o superior a 5.000euros son: ");
        System.out.println(cocheRepository.findByMarcaAndPrecioGreaterThanEqual("Seat", 5000.00));

        System.out.println("El precio medio de los Porsche es: ");
        System.out.println(cocheRepository.obtenerMediaPorMarca("Porsche"));

        System.out.println("Los coches de Noelia son: ");
        System.out.println(cocheRepository.findByPropietario(noelia));

        System.out.println("Los coches de Noelia con precio superior a 10.000euros son: ");
        System.out.println(cocheRepository.findByPropietarioAndPrecioGreaterThanEqual(noelia, 10000.00));

        System.out.println("Los coches de Noelia fabricados entre 2010 y 2012 son:");
        System.out.println(cocheRepository.findByPropietarioAndAñoBetween(noelia, 2010, 2012));

        System.out.println("Los coches de Noelia con precio superior a 10.000euros son: ");
        System.out.println(cocheRepository.obetenerCochesPorPropietarioYPrecioSuperior(noelia, 10000.00));

        System.out.println("Los coches de Noelia fabricados entre 2010 y 2012 son:");
        System.out.println(cocheRepository.cochesPorPropietarioYAños(noelia, 2010, 2012));

        System.out.println("Los coches con dueños mayores de 26 años:");
        System.out.println(cocheRepository.obtenerCochesPorEdadPropietario(26));

        System.out.println("Los coches con propietarios entre 22 y 24 años son:");
        System.out.println(cocheRepository.obtenerCocheEntreEdades(22, 24));

        System.out.println("El coche con las letras JFK en la matrícula es:");
        System.out.println(cocheRepository.obtenerMatriculaPorLetras("JFK"));

        System.out.println("El precio medio, mínimo y máximo de cada marca es:");
        List<Object[]> estadisticaMarcaList = cocheRepository.obtenerMediaMaxYMin();
        for (Object[] estadisticaMarca : estadisticaMarcaList) {
            System.out.print("Marca: " + estadisticaMarca[0] + " ");
            System.out.print("Media: " + estadisticaMarca[1] + " ");
            System.out.print("Máximo: " + estadisticaMarca[2] + " ");
            System.out.println("Mínimo: " + estadisticaMarca[3]);
        }

        System.out.println("Los coches fabricados cada año son:");
        List<Object[]> cochesAñoList = cocheRepository.obtenerCochesFabricadosAño();
        for (Object[] cochesAño : cochesAñoList) {
            Integer año = (Integer) cochesAño[0];
            System.out.print("Año: " + año + " // ");
            System.out.println("Número de coches: " + cochesAño[1]);
            System.out.println("Listado de coches: " + cocheRepository.findByAño(año));
        }









    }
}
