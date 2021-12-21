package com.bewise.challenges.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RepeatedCharacters {

    /**
     * El metodo debe retornar un booleano indicando si el parametro `cadena` cumple con alguna de las siguientes propiedades:
     * 1- Todos los caracteres aparecen la misma cantidad de veces.
     * Ejemplos: "aabbcc", "abcdef", "aaaaaa"
     * 2- Todos los caracteres aparecen la misma cantidad de veces, a excepcion de 1, que aparece un vez mas o una vez menos.
     * Ejemplos: "aabbccc", "aabbc", "aaaaccccc"
     *
     * @param cadena la cadena a evaluar
     * @return booleano indicando si la cadena cumple con las propiedades
     */
	
	
	// Método auxiliar
	private int cantidadDeApariciones (String cadena, char c)
	{
		/*
		 * Para contar las apariciones tomo el tamaño del string original y le resto el tamaño del mismo sacando todas las apariciones de la letre buscada.
		 * Esto lo hice así porque no encontré algún método en las librerías de String para contar apariciones de un caracter en particular.
		 */
		return  (cadena.length() - (int) cadena.chars().filter(ch -> ch == c).count());
	}
	
    public Boolean isValid(String cadena) 
    {
    	
    	/*
    	 * Itero el string contando la cantidad de apariciones de cada caracter. Con ese valor mantengo actualizado el máximo y mínimo
    	 * de esas apariciones.
    	 * 
    	 * Al llegar al final de la iteración, si hay una diferencia mayor a 1 entre el máximo y el mínimo 
    	 * significa que hay al menos un caracter que aparece 2 veces más o 2 veces menos que el resto.
    	 * 
    	 * Se hizo una pequeña optimización de que cuando encontramos un caracter que ya contamos sus apariciones anteriormente, no hacemos 
    	 * 	el conteo nuevamente.
    	 */
    	int max = cantidadDeApariciones(cadena,cadena.charAt(0));
    	int min = cantidadDeApariciones(cadena,cadena.charAt(0));
    	Set<Character> caracteresBuscados = new HashSet<Character> ();
    	
    	for ( Character c : cadena.toCharArray())
    	{
    		if ( ! caracteresBuscados.contains(c))
    		{
	    		int cantidadDeApariciones = cantidadDeApariciones(cadena, c);
	    		caracteresBuscados.add(c);
	    		
	    		if ( cantidadDeApariciones >= max ) 
	    		{
	    			max = cantidadDeApariciones;
	    		}
	    		else if ( cantidadDeApariciones <= min )
	    		{
	    			min = cantidadDeApariciones;
	    		}
	    		
	    		
    		}
    	}
    
    	return Math.abs(max - min ) <= 1; 	
    	
    
    }
}



