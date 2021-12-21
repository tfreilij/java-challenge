package com.bewise.challenges.alphabetSoup;

public class WordSearcher {

    private char soup[][];

    public WordSearcher(char soup[][]) {
        this.soup = soup;
    }
    
    /*
     * Lo que vamos a hacer para resolver el problema es hacer una iteración por toda la matriz "soup" y una vez que encontramos
     *  la primera letra de la palabra buscada empezamos una búsqueda recursiva hacia las cuatro direcciones posibles por las que 
     * 	podría desarrollarse la palabra. 'buscarSiguienteLetra()' se encarga de hacer esta recursión.
     * 
     * Por ejemplo si la palabra es 'gato', y encontramos la 'g', empezamos la búsqueda. A partir de esa casilla vamos en las cuatro direcciones a ver si encontramos 
     * la 'a', y así sucesivamente.. 
     *  
     * 
     * Si la palabra está en la grilla, en algún momento de esta búsqueda recursiva llegaremos a la última letra de la palabra buscada y por ende podemos
     *   decir que está en la grilla y devolvemos verdadero.
     *   
     *  Si nunca llegamos a la última letra de la palabra significa que no está en la grilla y devolvemos false.
     *    
     *  Aclaraciones de la solución:
     *  
     *  1) Cuando hacemos controles como i-1 != filaAnterior esto es para evitar el caso de que volvemos por el camino que venimos avanzando en la búsqueda
     *  Por ejemplo si la palabra buscada es 'lele' entonces si no hacemos los controles, en la grilla [ L , E ] nos podría dar que la encontramos.
     *  
     *  2) En cada llamado recursivo decimos hacia dónde avanzamos y de dónde venimos para hacer este control de 1) . De ahí que los últimos cuatro parámetros son
     *  	 a) La posición a la que nos movemos (int i, int j )
     *  	 b) La posición de la que venimos ( int filaAnterior, int columnaAnterior )
     *  
     *  3) En cada control además nos fijamos que no vamos a saltar fuera de la grilla.
     *  	
     */
    
    private boolean buscarSiguienteLetra(String word, int index, int i, int j, int filaAnterior, int columnaAnterior) {
    	if ( index == word.length() ) {
    		return true;
    	}
  	
    	int nColumnas = this.soup[0].length;
    	int nFilas = this.soup.length;
    	char nextChar = word.charAt(index);
    	   	
    	// Buscamos "para arriba" controlando que no venimos de ahí
    	if ( i > 0 && i-1 != filaAnterior && this.soup[i-1][j] == nextChar)
    	{
    		if ( buscarSiguienteLetra(word,index+1,i-1,j,i,j) )
    		{
    			return true;
    		}
    	}
    	// Buscamos "para la derecha" controlando que no venimos de ahí
    	if ( j < nColumnas - 1 && j+1 != columnaAnterior  && this.soup[i][j+1] == nextChar)
    	{
    		if ( buscarSiguienteLetra(word,index+1,i,j+1,i,j) )
    		{
    			return true;
    		}
    	}
    	
    	// Buscamos "para abajo" controlando que no venimos de ahí
    	if ( i < nFilas - 1 && i+1 != filaAnterior && this.soup[i+1][j] == nextChar)
    	{
    		if ( buscarSiguienteLetra(word,index+1,i+1,j,i,j) )
    		{
    			return true;
    		}
    	}
    	
    	// Buscamos "para la izquierda" controlando que no venimos de ahí
    	if ( j > 0 && j-1 != columnaAnterior && this.soup[i][j-1] == nextChar)
    	{
    		if ( buscarSiguienteLetra(word,index+1,i,j-1,i,j) )
    		{
    			return true;
    		}
    	}
    	
    	return false;
    }

    public boolean isPresent(String word) {
        
    	
    	int i = 0;
    	int j = 0;
    	int nColumnas = this.soup[0].length;
    	int nFilas = this.soup.length;
    	char primeraLetra = word.charAt(0);
    	
    	
    	for ( i = 0 ; i < nFilas ; i++ )
    	{    		
	    	for ( j = 0 ; j < nColumnas ; j++ )
	    	{
	    		// Si encontramos la primera letra entonces empezamos la búsqueda recursiva.
	    		if ( this.soup[i][j] == primeraLetra)
	    		{
	    			if ( buscarSiguienteLetra(word,1,i,j,i,j) )
	    			{
	    				// Si este llamado dio verdadero significa que encontramos la palabra
	    				return true;
	    			}
	    				
	    		}
	    	}
    	}
    	
    	// Si llegamos acá significa que no encontramos la palabra y devolvemos falso
    	return false;
    }
}