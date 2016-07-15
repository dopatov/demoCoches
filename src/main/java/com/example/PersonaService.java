package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public void testPersonas() {
        Persona ivan = new Persona();
        ivan.setNombre("Ivan");
        ivan.setApellido("Merino");
        ivan.setEdad(23);
        personaRepository.save(ivan);

        Persona dimple = new Persona();
        dimple.setNombre("Dimple");
        dimple.setApellido("Ramchandani");
        dimple.setEdad(26);
        personaRepository.save(dimple);

        Persona noelia = new Persona();
        noelia.setNombre("Noelia");
        noelia.setApellido("Villa");
        noelia.setEdad(25);
        personaRepository.save(noelia);

        Persona jordi = new Persona();
        jordi.setNombre("Jordi");
        jordi.setApellido("Portero");
        jordi.setEdad(25);
        personaRepository.save(jordi);

        Persona ricard = new Persona();
        ricard.setNombre("Ricard");
        ricard.setApellido("Sole");
        ricard.setEdad(25);
        personaRepository.save(ricard);

        Persona noeliaEj = new Persona();
        noeliaEj.setNombre("Noelia");
        noeliaEj.setApellido("Hernandez");
        noeliaEj.setEdad(25);
        personaRepository.save(noeliaEj);

        System.out.println(personaRepository.findOne(2L));
        System.out.println(personaRepository.findByNombre("Noelia"));

        System.out.println("Mostramos todas las personas cuya edad es mayor o igual a 23: ");
        System.out.println(personaRepository.findByEdadGreaterThanEqual(23));

        System.out.println("Mostramos todas las personas que se llamen Noelia Villa: ");
        System.out.println(personaRepository.findByNombreAndApellido("Noelia", "Villa"));

        System.out.println("Mostramos todas las personas que se llamen Noelia: ");
        System.out.println(personaRepository.findByNombreOrApellido("Noelia", "Villa"));


    }
}
