package Metodos.Ordenacion

/**
 * Elimina los comentarios para demostrar que el contenido está ordenado
 */
fun main() {
    var tamañoArray = 0

    var timeIni = 0L
    var timeFin = 0L

    var timeInsertion: Long = 0L
    var timeInsertionSuma: Long = 0L

    /**
     * Ejecución de método de ordenación Insertion con un tamaño de 1.000 3 veces seguidas con array con datos independientes.
     * Imprime lo que tarda en ordenarlo y además la media del tiempo de ejecución
     */
    for (i in 0 until 3) {
        var vectorInicio = IntArray(1_000) { (0..100_000).random() }
//        println("Contenido vector sin ordenar: ${vectorInicio.contentToString()}")
        val vectorInsertion = vectorInicio
        timeIni = System.nanoTime()
        insertionSort(vectorInsertion)
        timeFin = System.nanoTime()
        timeInsertion = timeFin - timeIni
//        println("Contenido vector Insertion: ${vectorInsertion.contentToString()}")
        println("Tiempo Insertion: $timeInsertion ns")
        timeInsertionSuma += timeInsertion
//        println("¿Está ordenado? ${vectorInsertion.contentEquals(vectorInicio.sortedArray())}")
    }
    timeInsertionSuma /= 3
    println("Tiempo medio de Insertion es: $timeInsertionSuma ns tamaño 1000")
    timeInsertionSuma = 0

    /**
     * Ejecutamos un nuevo array ("@vectorRepetido") el cual su tamaño va de 5.000 en 5.000 hasta llegar a 100.000
     * Con @vectorInsertionRepe hacemos la misma función que @vectorInsertion
     */
    for (i in 0 until 20) {
        tamañoArray += 5_000
        for (i in 0 until 3) {
            var vectorRepetido = IntArray(tamañoArray) { (0..100000).random() }
//            println("Contenido vector sin ordenar: ${vectorRepetido.contentToString()}")
            val vectorInsertionRepe = vectorRepetido
            timeIni = System.nanoTime()
            insertionSort(vectorInsertionRepe)
            timeFin = System.nanoTime()
            timeInsertion = timeFin - timeIni
//            println("Contenido vector ordenado: ${vectorInsertionRepe.contentToString()}")
            println("Tiempo Insertion: $timeInsertion ns")
            timeInsertionSuma += timeInsertion
//            println("¿Está ordenado? ${vectorInsertionRepe.contentEquals(vectorRepetido.sortedArray())}")
        }
        timeInsertionSuma /= 3
        println("Tiempo medio de Insertion es: $timeInsertionSuma ns tamaño $tamañoArray")
        timeInsertionSuma = 0
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