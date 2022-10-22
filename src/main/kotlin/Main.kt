fun main() {
    var vectorInicio = IntArray(1_000) { (0..100000).random() }
    var tamañoArray = 5_000

    var timeIni = 0L
    var timeFin = 0L

    var timeBurbujaSuma: Long = 0L

//  Tiempo de Burbuja y media de ejecución
    for (i in 1 until 4) {
        val vectorBurbuja = bubbleSort(vectorInicio)
        timeIni = System.currentTimeMillis()
        bubbleSort(vectorInicio)
        timeFin = System.currentTimeMillis()
        println("Tiempo burbuja: ${timeFin - timeIni} ms")
        timeBurbujaSuma += (timeFin - timeIni)
        i + 1
    }
    timeBurbujaSuma /= 3
    println("Tiempo medio de burbuja es: $timeBurbujaSuma ms tamaño 1000")

    for (i in 1 until 20) {
        tamañoArray = tamañoArray + 5_000
        var vectorInicio = IntArray(tamañoArray) { (0..100000).random() }
        for (i in 1 until 4) {
            val vectorBurbuja = bubbleSort(vectorInicio)
            timeIni = System.currentTimeMillis()
            bubbleSort(vectorInicio)
            timeFin = System.currentTimeMillis()
            println("Tiempo burbuja: ${timeFin - timeIni} ms")
            timeBurbujaSuma += (timeFin - timeIni)
            i + 1
        }
        timeBurbujaSuma /= 3
        println("Tiempo medio de burbuja es: $timeBurbujaSuma ms tamaño $tamañoArray")
    }
}

//  Algoritmo Burbuja
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
