package Metodos.Ordenacion

/**
 * Elimina los comentarios para demostrar que el contenido está ordenado
 */
fun main() {
    var tamañoArray = 0

    var timeIni = 0L
    var timeFin = 0L

    var timeSeletion: Long = 0L
    var timeSeletionSuma: Long = 0L

    /**
     * Ejecución de método de ordenación Seletion con un tamaño de 1.000 3 veces seguidas con array con datos independientes.
     * Imprime lo que tarda en ordenarlo y además la media del tiempo de ejecución
     */
    for (i in 0 until 3) {
        var vectorInicio = IntArray(1_000) { (0..100_000).random() }
//        println("Contenido vector sin ordenar: ${vectorInicio.contentToString()}")
        val vectorSeletion = vectorInicio
        timeIni = System.nanoTime()
        selectionSort(vectorSeletion)
        timeFin = System.nanoTime()
        timeSeletion = timeFin - timeIni
//        println("Contenido vector Seletion: ${vectorSeletion.contentToString()}")
        println("Tiempo Seletion: $timeSeletion ns")
        timeSeletionSuma += timeSeletion
//        println("¿Está ordenado? ${vectorSeletion.contentEquals(vectorInicio.sortedArray())}")
    }
    timeSeletionSuma /= 3
    println("Tiempo medio de Seletion es: $timeSeletionSuma ns tamaño 1000")
    timeSeletionSuma = 0

    /**
     * Ejecutamos un nuevo array ("@vectorRepetido") el cual su tamaño va de 5.000 en 5.000 hasta llegar a 100.000
     * Con @vectorSeletionRepe hacemos la misma función que @vectorSeletion
     */
    for (i in 0 until 20) {
        tamañoArray += 5_000
        for (i in 0 until 3) {
            var vectorRepetido = IntArray(tamañoArray) { (0..100000).random() }
//            println("Contenido vector sin ordenar: ${vectorRepetido.contentToString()}")
            val vectorSeletionRepe = vectorRepetido
            timeIni = System.nanoTime()
            selectionSort(vectorSeletionRepe)
            timeFin = System.nanoTime()
            timeSeletion = timeFin - timeIni
//            println("Contenido vector ordenado: ${vectorSeletionRepe.contentToString()}")
            println("Tiempo Seletion: $timeSeletion ns")
            timeSeletionSuma += timeSeletion
//            println("¿Está ordenado? ${vectorSeletionRepe.contentEquals(vectorRepetido.sortedArray())}")
        }
        timeSeletionSuma /= 3
        println("Tiempo medio de Seletion es: $timeSeletionSuma ns tamaño $tamañoArray")
        timeSeletionSuma = 0
    }
}

//  Método de ordenación por selección O(n²)
fun selectionSort(array: IntArray) {
    for (i in 0 until array.size - 1) {
        var min = i
        for (j in i + 1 until array.size) {
            if (array[j] < array[min]) {
                min = j
            }
        }
        val aux = array[i]
        array[i] = array[min]
        array[min] = aux
    }
}