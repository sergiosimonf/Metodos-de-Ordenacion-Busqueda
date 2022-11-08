package Metodos.Ordenacion

/**
 * Elimina los comentarios para demostrar que el contenido está ordenado
 */
fun main() {
    var tamañoArray = 0

    var timeIni = 0L
    var timeFin = 0L

    var timeshell: Long = 0L
    var timeshellSuma: Long = 0L

    /**
     * Ejecución de método de ordenación shell con un tamaño de 1.000 3 veces seguidas con array con datos independientes.
     * Imprime lo que tarda en ordenarlo y además la media del tiempo de ejecución
     */
    for (i in 0 until 3) {
        var vectorInicio = IntArray(1_000) { (0..100_000).random() }
//        println("Contenido vector sin ordenar: ${vectorInicio.contentToString()}")
        val vectorshell = vectorInicio
        timeIni = System.nanoTime()
        shellSort(vectorshell)
        timeFin = System.nanoTime()
        timeshell = timeFin - timeIni
//        println("Contenido vector shell: ${vectorshell.contentToString()}")
        println("Tiempo shell: $timeshell ns")
        timeshellSuma += timeshell
//        println("¿Está ordenado? ${vectorshell.contentEquals(vectorInicio.sortedArray())}")
    }
    timeshellSuma /= 3
    println("Tiempo medio de shell es: $timeshellSuma ns tamaño 1000")
    timeshellSuma = 0

    /**
     * Ejecutamos un nuevo array ("@vectorRepetido") el cual su tamaño va de 5.000 en 5.000 hasta llegar a 100.000
     * Con @vectorshellRepe hacemos la misma función que @vectorshell
     */
    for (i in 0 until 20) {
        tamañoArray += 5_000
        for (i in 0 until 3) {
            var vectorRepetido = IntArray(tamañoArray) { (0..100000).random() }
//            println("Contenido vector sin ordenar: ${vectorRepetido.contentToString()}")
            val vectorshellRepe = vectorRepetido
            timeIni = System.nanoTime()
            shellSort(vectorshellRepe)
            timeFin = System.nanoTime()
            timeshell = timeFin - timeIni
//            println("Contenido vector ordenado: ${vectorshellRepe.contentToString()}")
            println("Tiempo shell: $timeshell ns")
            timeshellSuma += timeshell
//            println("¿Está ordenado? ${vectorshellRepe.contentEquals(vectorRepetido.sortedArray())}")
        }
        timeshellSuma /= 3
        println("Tiempo medio de shell es: $timeshellSuma ns tamaño $tamañoArray")
        timeshellSuma = 0
    }
}

fun shellSort(array: IntArray) {
    var h = 1
    while (h < array.size / 3) {
        h = 3 * h + 1
    }
    while (h >= 1) {
        for (i in h until array.size) {
            var j = i
            while (j >= h && array[j] < array[j - h]) {
                val aux = array[j]
                array[j] = array[j - h]
                array[j - h] = aux
                j -= h
            }
        }
        h /= 3
    }
}