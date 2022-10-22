package Resuelto

fun main() {
    var vectorInicio = IntArray(1_000) { (0..100000).random() }
    var tamañoArray = 5_000

    var timeIni = 0L
    var timeFin = 0L

    var timeBurbujaSuma: Long = 0L

    /**
     * Ejecución de método de ordenación burbuja con un tamaño de 1.000 3 veces seguidas
     * Imprime lo que tarda en ordenarlo y ademas la media del tiempo de ejecución 
     */
    for (i in 0 until 3) {
        val vectorBurbuja = bubbleSort(vectorInicio)
        timeIni = System.currentTimeMillis()
        bubbleSort(vectorInicio)
        timeFin = System.currentTimeMillis()
        println("Tiempo burbuja: ${timeFin - timeIni} ms")
        timeBurbujaSuma += (timeFin - timeIni)
    }
    timeBurbujaSuma /= 3
    println("Tiempo medio de burbuja es: $timeBurbujaSuma ms tamaño 1000")

    /**
     * Ejecución de método de ordenación burbuja con un tamaño de 5.000 a 100.000 3 veces seguidas
     * Imprime lo que tarda en ordenarlo y además la media del tiempo de ejecución
     */
    for (i in 1 until 20) {
        tamañoArray = tamañoArray + 5_000
        var vectorInicio = IntArray(tamañoArray) { (0..100000).random() }
        for (i in 0 until 3) {
            val vectorBurbuja = bubbleSort(vectorInicio)
            timeIni = System.currentTimeMillis()
            bubbleSort(vectorInicio)
            timeFin = System.currentTimeMillis()
            println("Tiempo burbuja: ${timeFin - timeIni} ms")
            timeBurbujaSuma += (timeFin - timeIni)
        }
        timeBurbujaSuma /= 3
        println("Tiempo medio de burbuja es: $timeBurbujaSuma ms tamaño $tamañoArray")
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
