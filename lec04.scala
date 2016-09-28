// Небольшая правка для прошлой лекции:
// Тип для ламбды описывается таким способом
X:() => Int

// По умолчанию
def add(x:Int, y:Int = 1) = x + y
// Примеры вызова:
add(4, 4)
add(4, 1)
add(y=2,x=3)


// Если у функции 1 аргумент, то он может быть записан
// не в круглых скобках, а в фигурных
def write(x:Int)=??? // ??? - правильное имя метода, стандартное имя функции, кидающее исключение
write(5)
write {5}

// Функции с несколькими списками параметров
def add2(x:Int)(y.Int) = x + y // Тип результата можно опустить, если он явный
add2(4)(3)

// Типы:
add:(Int, Int)=>Int
add2:Int=>(Int=>Int)
add2(4):Int=>Int
// Это называется частичным применением функции (в фп это кодируемые функции)

val inc = add2(1)   
inc(3)

// Шаг 1
def twice(body:=>Unit) = {
    body()
    body()
}

twice(() => println("Ура!"))
// Шаг 2
def twice(body:=>Unit) = {
    body
    body
}

twice(println("Ура!"))

// Шаг 3
twice {
    println("Ура!")
}

// Шаг 4
def repeat(n:Int)(body:=>Unit) = {
    if(n > 0) {
        body
        repeat(n-1)(body)
    }
}

repeat(4) {
    // Code here
}



// Определим стандартный while
def While(cond:=>Boolean)(body:=>Unit) = {
    if(cond) {
        body
        While(cond)(body)
    }
}

// ДЗ: Сделать такое ?
repeat {
} until(условие)
// ============

// Рекурсия и хвостовые рекурсии
// Хвостовая рекурсия - рекурсия является последним действием в коде

foo(n)
{
    ...
    foo(n-1)
    // т.к. переменные не нужны (они уже не используются нигде), то можно
    // их не хранить. 
    // т.к. параметры одинаковые, то можно использовать прежнюю память
}


// Не хвостовая
def sum(list:List[Int]) = {
    if(list.empty) 0 // так тоже никогда не пишут
    else list.head + sum(list.tail)
}
// Хвостовая
@tailrec // проверка хвостовая ли рекурсия
def sum(list:List[Int]) = {
    def _sum(list:List[Int], s:Int) = {
        if(l.empty) s
        else _sum(l.tail, s+l.head)
    }
    _sum(list, 0)
}


// Аналог params в c#
def sum(x:Int*)
    x:seq[Int] // можнно так, ноо обычно foreach

sum(1)
sum(2,3,4)
// Последовательность не массив
