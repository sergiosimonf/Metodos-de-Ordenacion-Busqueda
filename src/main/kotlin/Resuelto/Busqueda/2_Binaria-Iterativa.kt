package Resuelto.Busqueda

/**
 * Elimina los comentarios para demostrar que el contenido está ordenado
 */
fun main() {
    var tamañoArray = 0

    var timeIni = 0L
    var timeFin = 0L

    var timeBinario: Long = 0L
    var timeLinealSuma: Long = 0L

    /**
     * Ejecución de método de búsqueda binaria con un tamaño de 1.000 3 veces seguidas con array con datos independientes.
     * Imprime lo que tarda en ordenarlo y además la media del tiempo de ejecución
     */
    for (i in 0 until 3) {
        var vectorInicial = IntArray(1_000) { (0..100_000).random() }
        val elementoParaBuscar = vectorInicial.random()
        timeIni = System.nanoTime()
        linearSearch(vectorInicial, elementoParaBuscar)
        timeFin = System.nanoTime()
        timeBinario = timeFin - timeIni
        println("Tiempo búsqueda lineal: ${timeFin - timeIni} ns")
        timeLinealSuma += timeBinario
    }
    timeLinealSuma /= 3
    println("Tiempo medio de la búsqueda binaria es: $timeLinealSuma ms tamaño 1000")
    timeLinealSuma = 0

    /**
     *
     */

    for (i in 0 until 20) {
        tamañoArray += 5_000
        for (i in 0 until 3) {
            var vectorRepetido = IntArray(tamañoArray) { (0..100_000).random() }
            val elementoParaBuscar = vectorRepetido.random()
            timeIni = System.nanoTime()
            linearSearch(vectorRepetido, elementoParaBuscar)
            timeFin = System.nanoTime()
            timeBinario = timeFin - timeIni
            println("Tiempo búsqueda lineal: ${timeFin - timeIni} ns")
            timeLinealSuma += timeBinario
        }
        timeLinealSuma /= 3
        println("Tiempo medio de la búsqueda binaria es: $timeLinealSuma ns tamaño $tamañoArray")
        timeLinealSuma = 0
    }
}

/**
 * Método de búsqueda binaria iterativa
 */

fun binarySearchIterative(array: IntArray, elemento: Int): Int {
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