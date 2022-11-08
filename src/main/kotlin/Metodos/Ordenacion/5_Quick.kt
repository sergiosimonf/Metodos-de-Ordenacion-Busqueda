package Metodos.Ordenacion

/**
 * Elimina los comentarios para demostrar que el contenido está ordenado
 */
fun main() {
    var tamañoArray = 0

    var timeIni = 0L
    var timeFin = 0L

    var timequick: Long = 0L
    var timequickSuma: Long = 0L

    /**
     * Ejecución de método de ordenación quick con un tamaño de 1.000 3 veces seguidas con array con datos independientes.
     * Imprime lo que tarda en ordenarlo y además la media del tiempo de ejecución
     */
    for (i in 0 until 3) {
        var vectorInicio = IntArray(1_000) { (0..100_000).random() }
//        println("Contenido vector sin ordenar: ${vectorInicio.contentToString()}")
        val vectorQuick = vectorInicio
        timeIni = System.nanoTime()
        quickSort(vectorQuick)
        timeFin = System.nanoTime()
        timequick = timeFin - timeIni
//        println("Contenido vector quick: ${vectorQuick.contentToString()}")
        println("Tiempo quick: $timequick ns")
        timequickSuma += timequick
//        println("¿Está ordenado? ${vectorQuick.contentEquals(vectorInicio.sortedArray())}")
    }
    timequickSuma /= 3
    println("Tiempo medio de quick es: $timequickSuma ns tamaño 1000")
    timequickSuma = 0

    /**
     * Ejecutamos un nuevo array ("@vectorRepetido") el cual su tamaño va de 5.000 en 5.000 hasta llegar a 100.000
     * Con @vectorQuickRepe hacemos la misma función que @vectorQuick
     */
    for (i in 0 until 20) {
        tamañoArray += 5_000
        for (i in 0 until 3) {
            var vectorRepetido = IntArray(tamañoArray) { (0..100000).random() }
//            println("Contenido vector sin ordenar: ${vectorRepetido.contentToString()}")
            val vectorQuickRepe = vectorRepetido
            timeIni = System.nanoTime()
            quickSort(vectorQuickRepe)
            timeFin = System.nanoTime()
            timequick = timeFin - timeIni
//            println("Contenido vector ordenado: ${vectorQuickRepe.contentToString()}")
            println("Tiempo quick: $timequick ns")
            timequickSuma += timequick
//            println("¿Está ordenado? ${vectorQuickRepe.contentEquals(vectorRepetido.sortedArray())}")
        }
        timequickSuma /= 3
        println("Tiempo medio de quick es: $timequickSuma ns tamaño $tamañoArray")
        timequickSuma = 0
    }
}

fun quickSort(array: IntArray) {
    quicksort(array, 0, array.size - 1)
}

fun quicksort(array: IntArray, left: Int, right: Int) {
    val piv: Int
    if (left < right) {
        piv = pivot(array, left, right)
        quicksort(array, left, piv - 1)
        quicksort(array, piv + 1, right)
    }
}

fun pivot(array: IntArray, left: Int, right: Int): Int {
    var i = left
    var j = right
    var pivot = array[left]
    while (i < j) {
        while (array[i] <= pivot && i < j) {
            i++
        }
        while (array[j] > pivot) {
            j--
        }
        if (i < j) {
            val aux = array[i]
            array[i] = array[j]
            array[j] = aux
        }
    }
    array[left] = array[j]
    array[j] = pivot
    return j
}