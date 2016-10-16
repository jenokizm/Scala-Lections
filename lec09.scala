trait Doubled extends IntQueue
{
    abstract override def put(x:Int) = {
        // В случае трейтов
        // super приобретает динамическую характеристику
        // и мы не знаем к чему обращаемся
        super.put(2*x)
    }
}

trait Filtered extends IntQueue
{
    abstract override def put(x:Int) = {
        if(x > 0) super.put(x)
    }
}

trait Incremented extends IntQueue
{
    abstract override def put(x:Int) = {
        super.put(x + 1)
    }
}

// В данном случае трейт "перекроет" метод
// и вызовется put для Doubled, а потом для IntQueue (?)
// (трейт примешивается)
class Q1 extends IntQueue
            with Doubled
{
    val q1 = new Q1
    q1.put(2)
}

// Вызовется Doubled, потом Incremented и IntQueue
class Q1 extends IntQueue
            with Incremented
            with Doubled
{
    val q1 = new Q1
    q1.put(3)
}

// Таким образом можно комбинировать, например с Filtered попадет в очередь все что больше нуля

// Можно примешивать к new
val q = new IntQueue with ... // при этом новый класс не создается.
// В случа ниже передать в foo просто очередь нельзя
// (должен быть примешан Filtered) 
def foo(q:IntQueue with Filtered)



// case-классы
// Все параметры конструктора неявно считаются val
// У класса реализованы методы сравнения
// Для класса реализован метод toString
// Реализован метод copy
// Автоматически создается объект-компаньон
case class Point(x:Double, y:Double) {
    // Как правило тело никто не пишет.
    // Они используются для описания каких-то структур.
}

// Создает копию объекта
p.copy(y = 3.2)
// Автоматически создается объект-компаньон
val p = Point(3, 4)

// case класс можно использовать как образец конструктор.


trait Expression
case class Const(value:Double)
case class Plus(left:Expression, right:Expression)
case class Minus(left:Expression, right:Expression)
// Знак минус перед выражением
case class UnaryMinus(exp:Expression) 

// def calc
anyexpr match {
    case Const(x) => x
    case Plus(l,r) => calc(l)+calc(r)
    case Minus(l,r) => calc(l)+calc(r)
}

def simple(e:Expression):Expression = {
    e match {
        case Plus(l, Const(0)) => simple(l) // Упростить упрощенное
        case Plus(Const(0), r)) => r
        case UnaryMinus(UnaryMinus(x)) => x // x == Expression
        // ...
        case x => x
    }
}


// Экстракторы
// Если хочется свой паттерн написать.
object Twice 
{
    // Экстрактор
    def unapply(s:String):Option[String] // приходит из str в match
    {
        val lenn = s.length/2
        val half = s.substring(0, len)
        if(half == s.substring(len))
            Some(half) // уезжать в x
        // Если вернет None, то шаблон не сопоставится.
        else None
    }
}

val str = "abab"
str match {
    case Twice(x /* Должно попасть ab из str (попадает из half) */) => ...
}

// Сложности!
object IsInt {
    def unapply(s:String):Option[Int] // Int, не String
}
str match {
    case IsInt(x) => // x может быть составной шаблон (напоминание) 
}



