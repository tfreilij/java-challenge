package com.bewise.challenges.sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/*
 * Implemento dos comparators para los jugadores según lo que pide la consigna de cada ordenamiento.
 * 
 * Con este comparator puedo utilizar el sort de Colections para que se ordenen las listas.
 * 
 * 
 */

class SortPuntuacionYNombre implements Comparator<Jugador>
{
    public int compare(Jugador a, Jugador b)
    {
    	if ( b.getPuntuacion() == a.getPuntuacion() )
    	{
    		// caso de mismo puntaje que desempata por el nombre
    		return a.getNombre().compareTo(b.getNombre());
    	}
    	else 
    	{
    		// caso de que tienen distintos puntaje...
    		return b.getPuntuacion() - a.getPuntuacion();
    	}
    }
}



class SortPuntuacionPerdidasYNombre implements Comparator<Jugador>
{
    public int compare(Jugador a, Jugador b)
    {
        if ( a.getPuntuacion() == b.getPuntuacion() ) 
        {
        	if (b.getPerdidas() == a.getPerdidas() ) 
        	{
        		// Caso de empate con las puntuaciones y perdidas...
        		return a.getNombre().compareTo(b.getNombre());		
        	}
        	else
        	{
        		// Caso de empate en las puntuaciones pero que tienen distitnas perdidas.
        		return a.getPerdidas() - b.getPerdidas();
        	}
        }
        else 
        {
        	// Caso de que tienen puntuacion distinta...
        	return b.getPuntuacion() - a.getPuntuacion();
        }
    }
}


public class Sorting {

    /**
     * Se debe ordenar primero por puntuación de manera descendente, luego por nombre de manera ascendente.
     *
     * @param jugadores la lista de jugadores a ordenar
     * @return la lista ordenada de jugadores
     */
	
    public static List<Jugador> ordenarPorPuntuacionYNombre(List<Jugador> jugadores) {
        
    	Collections.sort(jugadores,new SortPuntuacionYNombre());
		return jugadores;
    	
    
    }

    /**
     * Se debe ordenar primero por puntuación de manera descendente. Cuando 2 jugadores tienen igual cantidad de puntos,
     * el que tiene menos perdidas se lo considerara el mayor. Luego a igual puntos y perdidas se segxxuirá usando el
     * nombre de manera ascendente.
     *
     * @param jugadores la lista de jugadores a ordenar
     * @return la lista ordenada de jugadores
     */
    public static List<Jugador> ordenarPorPuntuacionPerdidasYNombre(List<Jugador> jugadores) {
    	
    	Collections.sort(jugadores,new SortPuntuacionPerdidasYNombre());
        return jugadores;
    }
}
