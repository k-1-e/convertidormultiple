fun main(){

    var opcion=0

    println("Convertidor multiple")
    println("1 = milimetros a centimetro")
    println ("2 = milimetros a metros")
    println ("3 = milimetros a Kilometros")
    println ("4 = centimetros a milimetros")
    println ("5 = metros  a milimetros")
    println ("6 = kilometros  a milimetros")
    println("¿Que opcion deceas?")
    opcion = readLine()!!.toInt()

    if (opcion == 1){
        var milimetros: Double = 0.0
        println("¿Introduzca La Cantidad de Milimetros que decea  convertir a centimetros?")
        milimetros = readLine()!!.toDouble()

        val centimetros = milimetros / 10.0
        println(" $milimetros  milimetros son  $centimetros  centimetros")

    }
         else if  (opcion ==2)
         {
                var milimetros: Double = 0.0
                println("¿Introduzca La Cantidad de Milimetros que decea convertir a metros?")
                milimetros = readLine()!!.toDouble()

                  val metros = milimetros / 1000.0
                     println(" $milimetros  milimetros son  $metros  metros")
        }
                else if  (opcion ==3)
                {
                        var milimetros: Double = 0.0
                        println("¿Introduzca La Cantidad de Milimetros que decea convertir a kilometros?")
                        milimetros = readLine()!!.toDouble()

                            val kilometros = milimetros / 1000000.0
                         println(" $milimetros  milimetros son  $kilometros  kilometros")
                 }
                            else if  (opcion ==4)
                            {
                                var centimetros: Double = 0.0
                                println("¿Introduzca La Cantidad de centimetros que decea convertir a Milimetros?")
                                centimetros = readLine()!!.toDouble()

                                val milimetros = centimetros / 0.10000
                                println(" $centimetros  centimetros son  $milimetros  milimetros")
                            }
                                else if  (opcion ==5)
                                {
                                    var metros: Double = 0.0
                                    println("¿Introduzca La Cantidad de metros que decea convertir a Milimetros?")
                                    metros = readLine()!!.toDouble()

                                    val milimetros = metros / 0.0010000
                                    println(" $metros  metros son  $milimetros  milimetros")
                                }
                                    else if  (opcion ==6)
                                    {
                                        var kilometros: Double = 0.0
                                        println("¿Introduzca La Cantidad de kilometros que decea convertir a Milimetros?")
                                        kilometros = readLine()!!.toDouble()

                                        val milimetros = kilometros / 0.00000100006
                                        println(" $kilometros  kilometros son  $milimetros  milimetros")
                                    }
    else

        println("Digete un numero que este dentro de nuestro rango")

}

