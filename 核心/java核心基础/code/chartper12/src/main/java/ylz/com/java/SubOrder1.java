package ylz.com.java;

/**
 * @author shkstart
 * @create 2019 上午 11:18
 */
public class SubOrder1<E> extends Order<E> {//SubOrder1<T>:仍然是泛型类
}

/**
 * 个人理解：子类继承时
 * 1、没有新增泛型，则泛型字母可以随便取，比如Order中是T，子类可以是public class SubOrder1<E> extends Order<E>，只要两个相同
 * 2、有新增泛型时，新增的可以随便取，原本的也可以随便取，但是要象上面一样，继承类和被继承类泛型要对应上，要相同
 * 总结：
 * 如果泛型要继承，没被赋值，泛型符号可以随便取，只是要跟父类对上（相同）
 */