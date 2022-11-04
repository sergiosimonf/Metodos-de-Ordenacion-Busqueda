package Metodos.Busqueda

fun main() {
    var tamañoArray = 0

    var timeIni = 0L
    var timeFin = 0L

    var timeLineal: Long = 0L
    var timeLinealSuma: Long = 0L

    /**
     * Ejecución de método de búsqueda lineal o secuencial con un tamaño de 1.000 3 veces seguidas con array con datos independientes.
     * Imprime lo que tarda en ordenarlo y además la media del tiempo de ejecución
     * */
    for (i in 0 until 3) {
        var vectorInicial = IntArray(1_000) { (0..100_000).random() }
        val elementoParaBuscar = vectorInicial.random()
        timeIni = System.nanoTime()
        linearSearch(vectorInicial, elementoParaBuscar)
        timeFin = System.nanoTime()
        timeLineal = timeFin - timeIni
        println("Tiempo búsqueda lineal: ${timeFin - timeIni} ns")
        timeLinealSuma += timeLineal
    }
    timeLinealSuma /= 3
    println("Tiempo medio de shell es: $timeLinealSuma ns tamaño 1000")
    timeLinealSuma = 0


    for (i in 0 until 20) {
        tamañoArray += 5_000
        for (i in 0 until 3) {
            var vectorRepetido = IntArray(tamañoArray) { (0..100_000).random() }
            val elementoParaBuscar = vectorRepetido.random()
            timeIni = System.nanoTime()
            linearSearch(vectorRepetido, elementoParaBuscar)
            timeFin = System.nanoTime()
            timeLineal = timeFin - timeIni
            println("Tiempo búsqueda lineal: ${timeFin - timeIni} ns")
            timeLinealSuma += timeLineal
        }
        timeLinealSuma /= 3
        println("Tiempo medio de shell es: $timeLinealSuma ns tamaño $tamañoArray")
        timeLinealSuma = 0
    }
}

/**
 * Método de búsqueda lineal o secuencial
 */
fun linearSearch(array: IntArray, value: Int): Int {
    for (i in array.indices) {
        if (array[i] == value) {
            return i
        }
    }
    return -1
}