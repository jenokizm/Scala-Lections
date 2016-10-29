// Такую запись
class Point(_x:Int, _y:Int) {
	val x = _x
	val y = _y
}
// Можно заменить на
class Point(val x:Int, val y:Int) {
	def length = ...
}

val p = new Point(2,3)
p.x

//
class Point(val x:Int, val y:Int) {
	def length = ...
	private var _color = "black"
	def color = _color // get
	def color_= (s:String) = _color = s // set
}

p.color = "red"

// Наследование 
class Point(val x:Int, val y:Int) {
	def length = Math.sqrt(x^2+y^2)
}

class Point3D(x:Int, y:Int, val z:Int) extends Point(x, y) {
	override def length = ...
}

object ZeroPoint extends Point(0, 0) {
	override val length = 0.0
}

val z = new ZeroPoint

ZeroPoint.x
ZeroPoint.y
ZeroPoint.length

// Есть object, class и trait
// В trait можно описать всё то, что в классах, но
// у него нету конструктора
// У trait может не быть реализации методов
trait HasLength {

}

class A extends BaseClass
	with HasLength
	with ...
	with
{

}
	

	
// Trait это тот же интерфейс
trait Sayable {
	val name: String // Это требование. В классе обязано быть это поле
	// def name: String // Ему норм
	def say() = println(s"Hello $name")
}

class Animal(val name: String) {
	def eat(what: String) = println(s"Съели $what")
}
class Frog(name: String) extends Animal(name)
	with Sayable
	with Ordered[Frog] // Уже существует
{
	override def say() = println("Frog")
	override def compare(that: Fog): Int = name.compareTo(that.name)
	override def eat(what: String): Unit = super.eat(what)
}

object Solution extends App {
	val f = new Frog("frog1")
	f.say()
	
	val s: Sayable = new Frog("frog 2")
	// Если сделал override say в классе, то вызовется последний
	s.say()
}






