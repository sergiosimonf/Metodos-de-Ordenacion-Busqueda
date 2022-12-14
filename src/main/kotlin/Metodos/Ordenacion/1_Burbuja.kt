package Metodos.Ordenacion

/**
 * Elimina los comentarios para demostrar que el contenido está ordenado
 */
fun main() {
    var tamañoArray = 0

    var timeIni = 0L
    var timeFin = 0L

    var timeBurbuja: Long = 0L
    var timeBurbujaSuma: Long = 0L

    /**
     * Ejecución de método de ordenación burbuja con un tamaño de 1.000 3 veces seguidas con array con datos independientes.
     * Imprime lo que tarda en ordenarlo y además la media del tiempo de ejecución
     */
    for (i in 0 until 3) {
        var vectorInicio = IntArray(1_000) { (0..100_000).random() }
//        println("Contenido vector sin ordenar: ${vectorInicio.contentToString()}")
        val vectorBurbuja = vectorInicio
        timeIni = System.nanoTime()
        bubbleSort(vectorBurbuja)
        timeFin = System.nanoTime()
        timeBurbuja = timeFin - timeIni
//        println("Contenido vector burbuja: ${vectorBurbuja.contentToString()}")
        println("Tiempo burbuja: $timeBurbuja ns")
        timeBurbujaSuma += timeBurbuja
//        println("¿Está ordenado? ${vectorBurbuja.contentEquals(vectorInicio.sortedArray())}")
    }
    timeBurbujaSuma /= 3
    println("Tiempo medio de burbuja es: $timeBurbujaSuma ns tamaño 1000")
    timeBurbujaSuma = 0

    /**
     * Ejecutamos un nuevo array ("@vectorRepetido") el cual su tamaño va de 5.000 en 5.000 hasta llegar a 100.000
     * Con @vectorBurbujaRepe hacemos la misma función que @vectorBurbuja
     */
    for (i in 0 until 20) {
        tamañoArray += 5_000
        for (i in 0 until 3) {
            var vectorRepetido = IntArray(tamañoArray) { (0..100000).random() }
//            println("Contenido vector sin ordenar: ${vectorRepetido.contentToString()}")
            val vectorBurbujaRepe = vectorRepetido
            timeIni = System.nanoTime()
            bubbleSort(vectorBurbujaRepe)
            timeFin = System.nanoTime()
            timeBurbuja = timeFin - timeIni
//            println("Contenido vector ordenado: ${vectorBurbujaRepe.contentToString()}")
            println("Tiempo burbuja: $timeBurbuja ns")
            timeBurbujaSuma += timeBurbuja
//            println("¿Está ordenado? ${vectorBurbujaRepe.contentEquals(vectorRepetido.sortedArray())}")
        }
        timeBurbujaSuma /= 3
        println("Tiempo medio de burbuja es: $timeBurbujaSuma ns tamaño $tamañoArray")
        timeBurbujaSuma = 0
    }
}

//  Método de ordenación de burbuja O(n²)
fun bubbleSort(vectorBurbuja: IntArray) {
    for (i in 0 until vectorBurbuja.size - 1) {
        for (j in 0 until vectorBurbuja.size - 1 - i) {
            if (vectorBurbuja[j] > vectorBurbuja[j + 1]) {
                val aux = vectorBurbuja[j]
                vectorBurbuja[j] = vectorBurbuja[j + 1]
                vectorBurbuja[j + 1] = aux
            }
        }
    }
}
