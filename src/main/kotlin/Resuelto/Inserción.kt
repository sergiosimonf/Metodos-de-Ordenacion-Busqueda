package Resuelto

fun main() {
    var vectorInicio = IntArray(1_000) { (0..100000).random() }
    var tamañoArray = 5_000

    var timeIni = 0L
    var timeFin = 0L

    var timeseletionSuma: Long = 0L

    /**
     * Ejecución de método de ordenación selección con un tamaño de 1.000 3 veces seguidas
     * Imprime lo que tarda en ordenarlo y ademas la media del tiempo de ejecución
     */
    for (i in 1 until 4) {
        val vectorseletion = insertionSort(vectorInicio)
        timeIni = System.currentTimeMillis()
        insertionSort(vectorInicio)
        timeFin = System.currentTimeMillis()
        println("Tiempo seletion: ${timeFin - timeIni} ms")
        timeseletionSuma += (timeFin - timeIni)
        i + 1
    }
    timeseletionSuma /= 3
    println("Tiempo medio de seletion es: $timeseletionSuma ms tamaño 1000")

    /**
     * Ejecución de método de ordenación selección con un tamaño de 5.000 a 100.000 3 veces seguidas
     * Imprime lo que tarda en ordenarlo y además la media del tiempo de ejecución
     */
    for (i in 1 until 20) {
        tamañoArray = tamañoArray + 5_000
        var vectorInicio = IntArray(tamañoArray) { (0..100000).random() }
        for (i in 1 until 4) {
            val vectorseletion = insertionSort(vectorInicio)
            timeIni = System.currentTimeMillis()
            insertionSort(vectorInicio)
            timeFin = System.currentTimeMillis()
            println("Tiempo seletion: ${timeFin - timeIni} ms")
            timeseletionSuma += (timeFin - timeIni)
            i + 1
        }
        timeseletionSuma /= 3
        println("Tiempo medio de seletion es: $timeseletionSuma ms tamaño $tamañoArray")
    }
}

//  Método de ordenación por inserción O(n²)
fun insertionSort(array: IntArray) {
    for (i in 1 until array.size) {
        var j = i
        while (j > 0 && array[j] < array[j - 1]) {
            val aux = array[j]
            array[j] = array[j - 1]
            array[j - 1] = aux
            j--
        }
    }
}
