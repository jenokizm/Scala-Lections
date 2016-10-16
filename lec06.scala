// Guard!
x match {
    case 1 => ...
    case 2 => ...

    // Круглых скобок нету -
    //  это называется защитным условием
    case n if n <= 0 => ... // n здесь не то, что ниже (n - локальная)
    case n if n > 0 => ... // можно не писать это условие (оно для наглядности)
}

// Образцы кортежей (tuple patterns)
val t1 = (5, -3)
t1 match {

    case (x,_) => x // Будет доступен только x

    case (x,y) => x+y
    case (5,2) =>
    case n => // n - кортеж
    case _ => 
}

// Чуть усложним
val p1 = (5, -3)
val p2 = (8, -6)
(p1,p2) match {
    // Читаем снизу вверх
    case ((_,y),p) if y < 0 => // 
    case ((x, y), p) => // p - кортеж, а x==5 и y==-3
    case (p, _) => // есть p типа кортежа
    case _ => // Примет всё
}


// Образец "список"
val l1 = List(5,-3,8)
l1 match {
    case x::tail => // x == 5, tail == List(-3,8)
    case Nil => // Список пустой
    case x::y::z::Nil => // Сопоставится, x == 5, y == -3, z == 8
    case x::y::Nil => // Не сопоставится
}

l1 match {
    case _::x::_::tail => // должно быть минимум 3 элемента
    case List(5,x,_) => // должно быть 3 элемента и первый равен 5
}


// Эквиваленты
case _::_::x::_ =>
List(_,_,x,_*) // Подробнее потом
// ===

// Сопоставление по типам
case x: String => x
case y: Int => y

// Все что сопоставляются по образцу записывается в <идент>
<идент>@<образец>

val r = ((5,-3),(8,-6))
r match {
    // p1,p2 - кортежи, они не участвуют в сопоставлении
    case (p1@(x1,y1),p2@(x2,y2)) =>
}


// Массивы
case Array(...) => ...

// С Option работают через match всегда
o1 match {    
    case Some(x) => ... // Образец "Конструктор"
    case None => ...
} 

// match кидает исключене, если нету сопоставления