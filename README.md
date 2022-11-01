- [Métodos de ordenación y búsqueda](#métodos-de-ordenación-y-búsqueda)
- [Ordenación](#ordenación)
  - [Método burbuja](#método-burbuja)
    - [Algoritmo del metodo de ordenación burbuja](#algoritmo-del-metodo-de-ordenación-burbuja)
  - [Método seleción](#método-seleción)
    - [Algoritmo del metodo de ordenación seleción](#algoritmo-del-metodo-de-ordenación-seleción)
  - [Método inserción](#método-inserción)
    - [Algoritmo del metodo de ordenación inserción](#algoritmo-del-metodo-de-ordenación-inserción)
  - [Método shell](#método-shell)
    - [Algoritmo del metodo de ordenación shell](#algoritmo-del-metodo-de-ordenación-shell)
  - [Método quicksort](#método-quicksort)
    - [Algoritmo del metodo de ordenación quicksort](#algoritmo-del-metodo-de-ordenación-quicksort)
- [Búsqueda](#búsqueda)
  - [Método secuencial o lineal](#método-secuencial-o-lineal)
    - [Algoritmo del metodo de búsqueda secuencial](#algoritmo-del-metodo-de-búsqueda-secuencial)
  - [Método Binario](#método-binario)
    - [Algoritmo del metodo de búsqueda binaria](#algoritmo-del-metodo-de-búsqueda-binaria)

<!-- <div align="center"><img src="img/" aling="center"></div> -->


# Métodos de ordenación y búsqueda
En este repositorio veremos diferentes métodos de ordenación y el tiempo que tardan en ordenar o buscar los datos dentro de un array el cual su tamaño inicia con 1.000 sigue con 5.000 en 5.000 hasta 100.000 . Para asegurarnos que la prueba es lo más imparcial posible se ordenara el array 3 veces distintas con números aleatorios del mismo tamaño.

# Ordenación

## Método burbuja

Es un método de [ordenación](https://es.wikipedia.org/wiki/Ordenamiento_de_burbuja) con eficiencia O(n²). Es decir, el tiempo de ejecución es proporcional al cuadrado del tamaño del array. Este método consiste en ir comparando cada elemento con el siguiente, y si el elemento actual es mayor que el siguiente, se intercambian. Este proceso se repite hasta que no se producen más intercambios. Este método es muy sencillo de implementar, pero no es el más eficiente.

- https://www.youtube.com/watch?v=lyZQPjUT5B4

<div align="center"><img src="img/burbuja.gif" aling="center"></div>

### Algoritmo del metodo de ordenación burbuja

````kotlin
fun burbuja(array: IntArray) {
  var aux: Int
  for (i in 0 until array.size) {
    for (j in 0 until array.size - 1) {
      if (array[j] > array[j + 1]) {
        aux = array[j]
        array[j] = array[j + 1]
        array[j + 1] = aux
      }
    }
  }
}
````

## Método seleción

El algoritmo de [selección](https://es.wikipedia.org/wiki/Ordenamiento_por_selecci%C3%B3n). su eficiencia es de O(n²).  Consiste en ir buscando el elemento más pequeño del array y colocarlo en la primera posición, luego el segundo más pequeño y colocarlo en la segunda posición, y así sucesivamente. Este método es más eficiente que el método de la burbuja, ya que solo hace una comparación por cada iteración. En definitiva, en cada iteración, se selecciona el menor elemento del subvector no ordenado y se intercambia con el primer elemento de este subvector.
- https://www.youtube.com/watch?v=Ns4TPTC8whw

<div align="center"><img src="img/Selección.gif" aling="center"></div>

### Algoritmo del metodo de ordenación seleción

````kotlin
fun seleccion(array: IntArray) {
  var aux: Int
  var min: Int
  for (i in 0 until array.size) {
    min = i
    for (j in i + 1 until array.size) {
      if (array[j] < array[min]) {
        min = j
      }
    }
    aux = array[i]
    array[i] = array[min]
    array[min] = aux
  }
}
````

## Método inserción

El algoritmo de [insercción](https://es.wikipedia.org/wiki/Ordenamiento_por_inserci%C3%B3n). Su eficiencia es O(n²). Es decir, el tiempo de ejecución es proporcional al cuadrado del tamaño del array. Inicialmente se tiene un solo elemento, que obviamente es un conjunto ordenado. Después, cuando hay k elementos ordenados de menor a mayor, se toma el elemento k+1 y se compara con todos los elementos ya ordenados, deteniéndose cuando se encuentra un elemento menor (todos los elementos mayores han sido desplazados una posición a la derecha) o cuando ya no se encuentran elementos (todos los elementos fueron desplazados y este es el más pequeño). En este punto se inserta el elemento k+1 debiendo desplazarse los demás elementos. En definitiva, nn cada iteración, se selecciona el menor elemento del subvector no ordenado y se intercambia con el primer elemento de este subvector.
- https://www.youtube.com/watch?v=ROalU379l3U

<div align="center"><img src="img/Inserción.gif" aling="center"></div>

### Algoritmo del metodo de ordenación inserción

````kotlin
fun insercion(array: IntArray) {
  var aux: Int
  var j: Int
  for (i in 1 until array.size) {
    aux = array[i]
    j = i - 1
    while (j >= 0 && array[j] > aux) {
      array[j + 1] = array[j]
      j--
    }
    array[j + 1] = aux
  }
}
````

## Método shell

El algoritmo de [Shell](https://es.wikipedia.org/wiki/Ordenamiento_Shell) es una mejora del algoritmo de inserción. Su eficiencia es de O(n log n). Este método consiste en ordenar los elementos de un array de forma que los elementos que están lejos entre sí se ordenan primero.
En lugar de comparar elementos adyacentes, se comparan elementos que están separados por un intervalo. Este intervalo se va reduciendo hasta que llega a 1. Este método es más eficiente que el método de inserción, ya que en cada iteración, se comparan elementos que están separados por un intervalo. En definitiva, en cada iteración, se selecciona el menor elemento del subvector no ordenado y se intercambia con el primer elemento de este subvector.
- https://www.youtube.com/watch?v=yn0EgXHb5jc

<div align="center"><img src="img/Shell.gif" aling="center"></div>

### Algoritmo del metodo de ordenación shell

````kotlin
fun shell(array: IntArray) {
  var aux: Int
  var j: Int
  var intervalo = 1
  while (intervalo < array.size) {
    intervalo = intervalo * 3 + 1
  }
  while (intervalo > 0) {
    for (i in intervalo until array.size) {
      aux = array[i]
      j = i
      while (j > intervalo - 1 && array[j - intervalo] >= aux) {
        array[j] = array[j - intervalo]
        j -= intervalo
      }
      array[j] = aux
    }
    intervalo = (intervalo - 1) / 3
  }
}
````

## Método quicksort

El algoritmo de [quicksort](https://es.wikipedia.org/wiki/Quicksort) es el algoritmo más rápido que veremos. Su eficiencia es de O(n log n). Consiste en dividir el array en dos partes, una con los elementos menores que el pivote y otra con los elementos mayores que el pivote. Luego se ordenan las dos partes de forma recursiva.
Trabaja de la siguiente manera:
1. Se toma un elemento arbitrario del vector, al que denominaremos pivote (p).
2. Se divide el vector de tal forma que todos los elementos a la izquierda del pivote sean menores que él, mientras que los que quedan a la derecha son mayores que él.
3. Ordenamos, por separado, las dos zonas delimitadas por el pivote.
4. Es recursivo, de ahí su gran ventaja. Repetimos el proceso recursivamente conc ad aparte, hasta que al salir todas las llamadas tenemos el vector completo.
- https://www.youtube.com/watch?v=ywWBy6J5gz8

<div align="center"><img src="img/QuickSort.gif" aling="center"></div>

<div align="center"><img src="img/QuickSort2.png" width="48%" aling="center"></div>

### Algoritmo del metodo de ordenación quicksort

````kotlin
fun pivote(array: IntArray, izq: Int, der: Int): Int {
  var i = izq
  var j = der
  var pivote = array[izq]
  while (i < j) {
    while (array[i] <= pivote && i < j) {
      i++
    }
    while (array[j] > pivote) {
      j--
    }
    if (i < j) {
      val aux = array[i]
      array[i] = array[j]
      array[j] = aux
    }
  }
  array[izq] = array[j]
  array[j] = pivote
  return j
}

fun quicksort(array: IntArray, izq: Int, der: Int) {
  var piv: Int
  if (izq < der) {
    piv = pivote(array, izq, der)
    quicksort(array, izq, piv - 1)
    quicksort(array, piv + 1, der)
  }
}
````

# Búsqueda

## Método secuencial o lineal

La búsqueda [secuencial o lineal](https://es.wikipedia.org/wiki/B%C3%BAsqueda_lineal) consiste en recorrer el vector hasta devolver el elemento buscado. Su eficiencia es de O(n). Es el método más sencillo de búsqueda, pero no es el más eficiente.
- https://www.youtube.com/watch?v=-PuqKbu9K3U

<div align="center"><img src="img/secuencial.png" aling="center"></div>

### Algoritmo del metodo de búsqueda secuencial

````kotlin
fun busquedaSecuencial(array: IntArray, elemento: Int): Int {
  for (i in array.indices) {
    if (array[i] == elemento) {
      return i
    }
  }
  return -1
}
````

## Método Binario

En la [búsqueda binaria](https://es.wikipedia.org/wiki/B%C3%BAsqueda_binaria) partimos de un array ordenado. Su eficiencia es de O(n log n).
Se compara el dato buscado con el elemento en el centro del vector:
1. Si coinciden, hemos encontrado el dato buscado.
2. Si el dato es mayor que el elemento central del vector, tenemos que buscar el dato en segunda mitad del vector (mejor recursivamente).
3. Si el dato es menor que el elemento central del vector, tenemos que buscar el dato en la primera mitad del vector (mejor recursivamente).
- https://www.youtube.com/watch?v=iP897Z5Nerk

<div align="center"><img src="img/binaria.jpeg" aling="center"></div>

### Algoritmo del metodo de búsqueda binaria

````kotlin
// Versión Iterativa
fun busquedaBinariaIterativa(array: IntArray, elemento: Int): Int {
  var centro: Int
  var inf = 0
  var sup = array.size - 1
  while (inf <= sup) {
    centro = (sup + inf) / 2
    if (array[centro] == elemento) {
      return centro
    } else if (elemento < array[centro]) {
      sup = centro - 1
    } else {
      inf = centro + 1
    }
  }
  return -1
}

// Versión recursiva
fun busquedaBinariaRecursiva(array: IntArray, elemento: Int, inf: Int, sup: Int): Int {
  if (inf > sup) {
    return -1
  }
  val centro = (sup + inf) / 2
  return if (array[centro] == elemento) {
    centro
  } else if (elemento < array[centro]) {
    busquedaBinariaRecursiva(array, elemento, inf, centro - 1)
  } else {
    busquedaBinariaRecursiva(array, elemento, centro + 1, sup)
  }
}
````