package org.iesvdm;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AlturaAlumnoTest {
    @Test
    void verdadero() {
        assertTrue(1==1);
    }


    @Test
    void aniadeNombreTest1() {


        final String[] array = new String[2];

        array[0]="Jose";
        array[1]="Paco";

        String nombre = "María";
        String[] arrayActual = AlturaAlumno
                .añadeNombre(array, nombre);

        assertTrue(arrayActual[arrayActual.length-1]
                    .equals(nombre) );

        for (int i = 0; i< array.length;i++)
            assertEquals(array[i], arrayActual[i]);

//        String[] arrayExpected = Arrays.copyOf(array, array.length+1);
//        arrayExpected[arrayExpected.length-1]=nombre;
//
//        assertArrayEquals(arrayExpected, arrayActual);

    }

    @Test
    void aniadeNombreTest2() {


        final String[] array = new String[0];
        int longInicial = array.length;

        String nombre = "María";
        String[] arrayActual = AlturaAlumno
                .añadeNombre(array, nombre);

//        assertTrue(arrayActual[arrayActual.length-1]
//                .equals(nombre) );
        assertEquals(longInicial+1, arrayActual.length);
        assertEquals(nombre, arrayActual[longInicial+1]);

    }

    @Test
    void modificaAlturaPosicionEnElArray() {

        //When (Cuando)
        double[] array = {1.6, 1.8, 1.7};
        double[] array2 = Arrays.copyOf(array,array.length);
        int posicion = 1;
        double altura = 1.9;


        //Do (Hacer)
        AlturaAlumno.modificaAltura(array, posicion, altura);


        //Then (Entonces)

        //altura esta en la posicion
        assertTrue( altura == array[posicion]);

        //Todos los demas elementos del array no cambian
        for (int i = 0; i < array.length; i++) {
            if (i != posicion) {
                assertEquals(array[i], array2[i]);
            }
        }

    }

    @Test
    void modificaAlturaPosicionFueraDeRangoArray() {

        //When (Cuando)
        double[] array = {1.6, 1.8, 1.7};
        double[] array2 = Arrays.copyOf(array,array.length);
        int posicion = array.length+2;
        double altura = 1.9;


        //Do (Hacer)
        AlturaAlumno.modificaAltura(array, posicion, altura);


        //Then (Entonces)

        //altura esta en la posicion
        //assertTrue( altura == array[posicion]);

        //Todos los demas elementos del array no cambian
//        for (int i = 0; i < array.length; i++) {
//                assertEquals(array[i], array2[i]);
//        }
        assertArrayEquals(array2, array);

    }
    
    @Test
    void buscaNombreTest(){
        String[] array = {"Paco","Juan","Ana"};
        String nombre = "Ana";

        //Do
        AlturaAlumno.buscaNombre(array,nombre);
        //Then
        assertEquals(2, AlturaAlumno.buscaNombre(array, nombre));
    }
    @Test
    void buscaNombreTestVacio(){
        String[] array = {"Paco","Juan","Ana"};
        String nombre = "";

        //Do
        AlturaAlumno.buscaNombre(array,nombre);
        //Then
        assertEquals(-1, AlturaAlumno.buscaNombre(array, nombre));
    }
    @Test
    void buscaNombreTestVacioNull(){
        String[] array = {"Paco","Juan","Ana"};
        //String nombre = ""; <- NO se ha inicializado

        //Do
        //Then
       // assertEquals(-1, AlturaAlumno.buscaNombre(array, nombre));
    }
    @Test
    void mostrarTestAFallo(){
        String[] array = {"Paco","Juan","Ana"};
        double[] alturas = {1.9, 1.78};

    }
    @Test
    void calculaMaximoTest(){
    double[] array = {2.1,3.6,1.5,6.3};
    double[] res = {3, 6.3};

    assertArrayEquals(res, AlturaAlumno.calculaMaximo(array));
    }
    @Test
    void calculaMaximoTestVacio() {
        double[] array = {};
        double[] res = {0, 0};

        assertArrayEquals(res, AlturaAlumno.calculaMaximo(array));
    }



}
