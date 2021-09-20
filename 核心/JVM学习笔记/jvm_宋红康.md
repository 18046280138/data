#第1章  JVM与Java体系结构
##学习路线
![](./image/01_01.jpg)
##底层课程
- 计算机组成原理、操作系统、数据结构、计算机网络
##参考书
- java虚拟机规范
- 深入理解java虚拟机（jvm高级特性与最佳实践）

##虚拟机介绍
- 系统虚拟机，对物理计算机的仿真，WMware
- 程序虚拟机,为执行单个计算机程序而设计的，JVM
- java核心技术就是JVM
- 字节码
- JVM是二进制字节码的运行环境
- 特点
  - 一次编译，到处运行
  - 自动内存管理
  - 自动垃圾回收
- JVM位置
  - 字节码->JVM->操作系统->硬件计算机
![](./image/jvm.png)  
- jdk>jre>jvm
- 计算机只能识别机器指令，java字节码不等于机器指令，所以在jvm中有一个执行引擎就是把字节码解释成机器指令
- 高级语言->汇编指令->机器指令->cpu
- javac把.java文件编译成.class文件，javap把.class文件编译成汇编指令

##整体结构
![jvm架构](./image/JVMjg-jt.jpg)

##java代码执行流程
![java代码执行流程](./image/javadmzxlc.png)

##JVM架构模型
###分类
- 基于栈的指令集架构（jvm）
  - 跨平台性
  - 指令集小
  - 指令多
  - 执行性能比寄存器差
- 基于寄存器的指令集架构
  - 依赖硬件，移植性较差
  - 性能、效率更高
  - 指令集大、指令少

##JVM生命周期
###虚拟机的启动
- java虚拟机的启动是通过引导类加载器（boostrap class loader）创建一个初始类(initial class)来完成，这个类是由虚拟机的具体实现来指定的。
###虚拟机的执行
- 一个运行中的虚拟机有着清晰的任务：执行java程序
- 程序开始执行时他才运行，程序结束时他就停止
- 执行一个java程序时候，真真正正在执行的是一个叫java虚拟机的进程
###虚拟机的退出
- 程序正常执行结束
- 程序运行中出现异常或者错误而异常终止
- 由于操作系统出现错误而导致java虚拟机进程终止
- 某线程调用Runtime类或者System类的exit方法，或者Runtime类halt方法，并且java安全管理器也允许这次exit或者halt操作。
- 除此之外，JNI（java native interface）规范描述了用JNI Innovation API来加载或者卸载java虚拟机时，java虚拟机的退出情况

##常见java虚拟机
- sun classic vm
  - jdk1.1出世
  - 世界上第一款商用虚拟机，jdk.4被淘汰
  - 只提供解释器
  - 如果要用JIT，则需要外挂，但是一旦使用了JIT,解释器就不工作了
  - 现在hospot内置了此虚拟机
- Exact VM
  - jdk1.2出世
  - 编译器解释器混合工作
  - 可以知道内存中某个位置的数据是什么类型（对象引用还是数据）
- hotspot（三大虚拟机）
  - jdk1.3成为默认虚拟机
  - 方法区是hotspot独有概念
  - 解释器和JIT协同工作，解释器响应时间快，JIT性能高
- JRockit（三大虚拟机）
  - 不包含解释器，只含有JIT编译器，
  - 最快的JVM
- J9（三大虚拟机）

#第2章 类加载子系统
##架构详细图
![02_JVM.jpg](./image/02_JVM.jpg)

##类加载器与类加载过程
###类加载器子系统作用
- 类加载器子系统负责从文件系统或者网络中加载Class文件，class文件在文件开头有特定的文件标识
- ClassLoader只负责class文件的加载，至于他是否可以运行，则由执行引擎决定
- 加载的类信息存放在方法区中，除了类信息，方法区还会存放运行时常量池信息，可能还包括字符串字面量和数字常量（这部分常量信息是Class文件中常量池部分的内存映射）

###类加载器class loader角色
![类加载器角色](./image/02_ljzqjs.png)

###类加载过程
![类加载过程](./image/02_ljzgc02.png)

![类加载过程](./image/02_ljzgc.jpg)

###加载
####加载过程
- 通过一个类的全限定名获取定义此类的二进制字节流
- 将这个字节流所代表的的静态存储结构转化为方法区的运行时数据结构
- 在内存中生成一个代表这个类的java.lang.Class对象，作为方法区这个类的各种数据的访问入口

####加载.class文件的方式
![](./image/02_jzclassfs.png)

###链接
![](./image/02_lj.png)

###初始化
![](./image/02_csh.png)

##类加载器分类
![](./image/02_ljzqfl.png)

![](./image/02_ljzqfl1.png)

###启动类加载器
![](./image/02_qdljzq.png)

###扩展类加载器
![](./image/02_kzljzq.png)

###应用程序类加载器
![](./image/02_yycxljzq.png)

###自定义类加载器
![](./image/02_zdyljzq.png)
![](./image/02_zdyljzqbz.png)

##ClassLoader
![](./image/02_classLoader.png)
![](./image/02_classLoader2.png)
![](./image/02_classLoader3.png)

##双亲委派机制
![](./image/02_sqwpjz.png)
![](./image/02_sqwpgzyl.png)
![](./image/02_sqwpjz2.png)
![](./image/02_sqwpjz3.png)
![](./image/02_sqwpjz4.png)
![](./image/02_sqwpjz5.png)
![](./image/02_sxaqjz.png)

##其他
![](./image/02_qt.png)
![](./image/02_qt2.png)
![](./image/02_qt3.png)

#第3章 运行时数据区概述及线程
##概述
![](./image/03_gs.png)
![](./image/03_nc.png)
![](./image/03_01.png)

##运行时数据区结构
![](./image/03_yxssjqjg.png)

![](./image/03_02.png)

![](./image/02_04.png)

##线程
![](./image/03_xc.png)
![](./image/03_xc2.png)

#第4章程序计数器
##PC Register介绍
![](./image/04_01.png)
![](./image/04_02.png)
![](./image/04_03.png)
![](./image/04_04.png)

##举例说明
![](./image/04_05.png)

![](./image/04_06.png)

**说明：**

- 指令地址，寄存器存储的是指令的地址

##两个常见问题
![](./image/04_07.png)

![](./image/04_08.png)

##CPU时间片
![](./image/04_09.png)


#第5章 虚拟机栈
##虚拟机栈概述
###虚拟机栈出现的背景
![](./image/05_01.png)
![](./image/05_02.png)

###虚拟机栈基本内容
![](./image/05_03.png)
![](./image/05_04.png)
![](./image/05_05.png)
![](./image/05_06.png)
![](./image/05_07.png)
![](./image/05_08.png)
![](./image/05_09.png)

##栈的存储单位
![](./image/05_10.png)
![](./image/05_11.png)
![](./image/05_12.png)
![](./image/05_13.png)
![](./image/05_14.png)
![](./image/05_15.png)

###局部变量表
![](./image/05_16.png)
![](./image/05_17.png)
![](./image/05_18.png)
![](./image/05_19.png)
![](./image/05_20.png)
![](./image/05_21.png)
![](./image/05_22.png)
![](./image/05_23.png)
![](./image/05_24.png)

####变量的分类
- 按照数据类型分：
  - 基本数据类型
  - 引用数据类型
- 按照在类中声明的位置分：
  - 成员变量，在使用前都经过默认初始化赋值。1、类变量：linking的prepare阶段：给类变量默认赋值 -->initial阶段：给类变量显示赋值即静态代码块赋值。  2、实例变量，随着对象的创建，会在堆空间中分配实例变量空间，并进行默认赋值。
  - 局部变量，在使用前必须进行显示赋值，否则编译不通过

![](./image/05_25.png)

**注意：**

静态方法和非静态方法都能访问静态成员变量，在这些方法里静态成员变量在局部变量里吗？

个人理解：不在，因为静态成员变量在方法区里

静态方法为什么访问不了实例变量，因为局部变量表里没有this局部变量

![](./image/05_26.png)

###操作数栈
![](./image/05_27.png)
![](./image/05_28.png)
![](./image/05_29.png)
![](./image/05_30.png)

###动态链接
![](./image/05_40.png)

![](./image/05_41.png)
![](./image/05_42.png)

![](./image/05_43.jpg)
![](./image/05_44.jpg)

###方法返回地址
![](./image/05_64.png)
![](./image/05_65.png)
![](./image/05_66.png)
![](./image/05_67.png)

###一些附加信息
![](./image/05_68.png)

###注意
帧数据区=动态链接+方法返回地址+一些附加信息
##代码追踪（操作数栈作用分析）
![](./image/05_31.png)
![](./image/05_32.png)
![](./image/05_33.png)
![](./image/05_34.png)
![](./image/05_35.png)
![](./image/05_36.png)
![](./image/05_37.png)
![](./image/05_38.png)


##栈顶缓存技术
![](./image/05_39.png)


##方法的调用：解析与分配
![](./image/05_45.png)
![](./image/05_46.png)
![](./image/05_47.png)
![](./image/05_48.png)
![](./image/05_49.png)
![](./image/05_50.png)
![](./image/05_51.png)
![](./image/05_52.png)
![](./image/05_54.png)
![](./image/05_53.png)
![](./image/05_55.png)
![](./image/05_56.png)
![](./image/05_57.png)
![](./image/05_58.png)
![](./image/05_59.png)
![](./image/05_60.png)
![](./image/05_61.png)
![](./image/05_62.png)
![](./image/05_63.png)

**注意：**

- 静态方法不能被继承和重写

##栈的相关面试题
![](./image/05_69.png)

###方法中定义的局部变量是否线程安全
![](./image/05_70.png)
![](./image/05_71.png)

**总结**
内部产生，内部消亡则线程安全，如果是外部传进来或者有传到外部则线程不安全

#第6章 本地方法接口
![](./image/06_01.png)
![](./image/06_02.png)
![](./image/06_03.png)
![](./image/06_04.png)
![](./image/06_06.png)

#第7章 本地方法栈
![](./image/07_01.png)
![](./image/07_02.png)
![](./image/07_03.png)

#第8章 堆
##堆的核心概念
![](./image/08_01.png)
![](./image/08_02.png)
![](./image/08_03.png)
![](./image/08_04.png)
![](./image/08_05.png)
![](./image/08_06.png)

##设置堆内存大小和OOM
![](./image/08_07.png)
![](./image/08_08.png)
![](./image/08_09.png)

**注意：**
- RunTime打印出来的初始堆大小和最大堆大小=e+s0(s1),设置时是=e+s0+s1，所以才会出现两个大小不一致

![](./image/08_10.png)
![](./image/08_11.png)
![](./image/08_12.png)
![](./image/08_13.png)

##年轻代和老年代
![](./image/08_14.png)
![](./image/08_15.png)
![](./image/08_16.png)
![](./image/08_17.png)
![](./image/08_18.png)
![](./image/08_19.png)
![](./image/08_20.png)

##图解对象分配过程
![](./image/08_21.png)
![](./image/08_23.png)
![](./image/08_22.jpg)
![](./image/08_24.png)
![](./image/08_25.png)

**举例和jVisualVM演示：**
![](./image/08_26.png)
![](./image/08_27.png)
![](./image/08_28.png)

**注意：**

- 当eden满了时才会触发YGC，s区满了不会触发，s是eden满了时一起进行垃圾回收的
- YGC后，Eden一定是空的

![](./image/08_29.png)

##MinorGC、MajorGC、FullGC
- MajorGC、FullGC的卡顿时间比MinorGC长至少10倍，所以应该尽可能避免这两个GC

![](./image/08_30.png)
![](./image/08_31.png)
![](./image/08_32.png)
![](./image/08_33.png)
![](./image/08_34.png)
![](./image/08_35.png)

**注意：**
- GC日志主要记录垃圾回收前后内存大小变化以及耗费时间

##堆空间分代思想
![](./image/08_36.png)
![](./image/08_37.png)

##内存分配策略
![](./image/08_38.png)
![](./image/08_39.png)

- 空间分配担保
  - miner gc后，s区存不下幸存的对象，则放在老年代（前提是老年代要有空间）

##为对象分配内存:TLAB
![](./image/08_40.png)
![](./image/08_41.png)
![](./image/08_42.png)
![](./image/08_43.png)

- 问题
  - 这跟线程的本地内存、共享内存有啥关系？？
  - 不在tlab中分配时加锁？？啥意思？？
  - tlab内不共享，其他线程就访问不到？？

![](./image/08_44.png)

##小结堆空间的参数设置
![](./image/08_45.png)
![](./image/08_46.png)
![](./image/08_47.png)
![](./image/08_48.png)

##堆是分配对象的唯一选择吗
![](./image/08_49.png)
![](./image/08_50.png)
![](./image/08_51.png)
![](./image/08_52.png)
![](./image/08_53.png)
![](./image/08_54.png)
![](./image/08_55.png)
![](./image/08_56.png)

![](./image/08_57.png)
![](./image/08_58.png)
![](./image/08_59.png)
![](./image/08_60.png)
![](./image/08_61.png)
![](./image/08_62.png)
![](./image/08_63.png)
![](./image/08_64.png)
![](./image/08_65.png)
![](./image/08_67.png)
![](./image/08_66.png)
![](./image/08_68.png)
![](./image/08_69.png)
![](./image/08_70.png)


#第9章 方法区
##栈、堆、方法区的交互关系
![](./image/09_01.png)
![](./image/09_02.png)

##方法区的理解
![](./image/09_03.png)
![](./image/09_04.png)
![](./image/09_05.png)
![](./image/09_06.png)
![](./image/09_07.png)

##设置方法区大小与OOM
![](./image/09_08.png)
![](./image/09_09.png)
![](./image/09_10.png)
![](./image/09_11.png)
![](./image/09_12.png)
![](./image/09_13.png)
![](./image/09_14.png)

##方法区的内部结构
![](./image/09_15.png)
![](./image/09_16.png)
![](./image/09_17.png)
![](./image/09_18.png)
![](./image/09_19.png)
![](./image/09_20.png)
![](./image/09_21.png)
![](./image/09_22.png)
![](./image/09_23.png)
![](./image/09_24.png)
![](./image/09_25.png)
![](./image/09_26.png)
![](./image/09_27.png)
![](./image/09_28.png)
![](./image/09_29.png)
![](./image/09_30.png)
![](./image/09_31.png)

- 动态性，比如运行中String有新的值，就会放到运行时常量池中

##方法区使用举例
![](./image/09_32.png)
![](./image/09_33.png)
![](./image/09_34.png)
![](./image/09_35.png)
![](./image/09_36.png)
![](./image/09_37.png)
![](./image/09_38.png)
![](./image/09_39.png)
![](./image/09_40.png)
![](./image/09_41.png)
![](./image/09_42.png)
![](./image/09_43.png)
![](./image/09_44.png)
![](./image/09_45.png)
![](./image/09_46.png)
![](./image/09_47.png)
![](./image/09_48.png)

##方法区的演进细节
![](./image/09_49.png)
![](./image/09_50.png)
![](./image/09_51.png)
![](./image/09_52.png)
![](./image/09_53.png)
![](./image/09_54.png)
![](./image/09_55.png)
![](./image/09_56.png)

- 结论
  - 对象始终放在堆里
  - 变量即引用，三者不同

![](./image/09_57.png)
![](./image/09_58.png)
![](./image/09_59.png)

##方法区的垃圾回收
![](./image/09_60.png)

- hospot是有方法区的垃圾回收的

![](./image/09_61.png)
![](./image/09_62.png)

##总结
![](./image/09_63.png)

- fullgc包括年轻代、老年代、方法区

![](./image/09_64.png)
![](./image/09_65.png)

#第10章 对象的实例化内存布局与访问定位
![](./image/10_01.png)

##对象的实例化
![](./image/10_02.jpg)
![](./image/10_03.png)
![](./image/10_04.png)
![](./image/10_05.png)
![](./image/10_06.png)
![](./image/10_07.png)
![](./image/10_08.png)
![](./image/10_09.png)

##对象的内存布局
![](./image/10_10.jpg)
![](./image/10_11.png)

![](./image/10_12.png)
![](./image/10_13.png)
![](./image/10_14.png)

##对象的访问定位
![](./image/10_15.png)
![](./image/10_16.png)

**句柄访问:**
![](./image/10_17.jpg)

**使用直接指针访问:**
![](./image/10_18.jpg)

**句柄访问优点：**
![](./image/10_17.png)

**指针访问优点：**

#第11章 直接内存
![](./image/11_01.png)
![](./image/11_02.png)
![](./image/11_03.png)
![](./image/11_04.png)
![](./image/11_05.png)
![](./image/11_06.png)
![](./image/11_07.png)
![](./image/11_08.png)

- 直接内存怎么回收？

![](./image/11_09.png)
![](./image/11_10.png)

#第12章 执行引擎
##执行引擎概述
![](./image/12_01.png)
![](./image/12_02.png)
![](./image/12_03.png)
![](./image/12_04.png)

##java代码编译和执行过程
![](./image/12_05.png)
![](./image/12_06.png)
![](./image/12_07.png)
![](./image/12_08.png)
![](./image/12_09.png)

##机器码、指令、和汇编语言
![](./image/12_10.png)
![](./image/12_11.png)
![](./image/12_12.png)
![](./image/12_13.png)
![](./image/12_14.png)
![](./image/12_15.png)
![](./image/12_16.png)

- 执行引擎通过汇编把字节码变成机器指令？
- 字节码指令具有原子性？不是

##解释器
![](./image/12_17.png)
![](./image/12_18.png)
![](./image/12_19.png)
![](./image/12_20.png)

##JIT编译器
![](./image/12_21.png)
![](./image/12_22.png)
![](./image/12_23.png)
![](./image/12_24.png)
![](./image/12_25.png)
![](./image/12_26.png)
![](./image/12_27.png)
![](./image/12_28.png)
![](./image/12_29.png)
![](./image/12_30.png)
![](./image/12_31.png)
![](./image/12_32.png)
![](./image/12_33.png)
![](./image/12_34.png)
![](./image/12_35.png)
![](./image/12_36.png)
![](./image/12_37.png)
![](./image/12_38.png)
![](./image/12_39.png)
![](./image/12_40.png)
![](./image/12_41.png)
![](./image/12_42.png)
![](./image/12_43.png)

#第13章 StringTable
##String的基本特性
![](./image/13_01.png)
![](./image/13_02.png)
![](./image/13_03.png)
![](./image/13_04.png)
![](./image/13_05.png)
![](./image/13_06.png)
![](./image/13_07.png)
![](./image/13_08.png)
![](./image/13_09.png)
![](./image/13_10.png)

##String的内存分配

- 总结
  - String.intern()方法是一种手动将字符串加入常量池中的方法，原理如下：如果在常量池中存在与调用intern()方法的字符串等值的字符串，就直接返回常量池中相应字符串的引用，否则在常量池中复制一份该字符串，并将其引用返回（Jdk7中会直接在常量池中保存当前字符串的引用）
  -  基本数据类型常量池怎么存？？？？

![](./image/13_11.png)
![](./image/13_12.png)
![](./image/13_13.png)
![](./image/13_14.png)
![](./image/13_15.png)
![](./image/13_16.png)
![](./image/13_17.png)

##String的基本操作
![](./image/13_18.png)
![](./image/13_19.png)
![](./image/13_20.png)
![](./image/13_21.png)
![](./image/13_22.png)
![](./image/13_24.png)

##字符串拼接操作
![](./image/13_23.png)
![](./image/13_25.png)
![](./image/13_26.png)
![](./image/13_27.png)
![](./image/13_28.png)
![](./image/13_29.png)
![](./image/13_30.png)
![](./image/13_31.png)
![](./image/13_32.png)
![](./image/13_33.png)

##intern()的使用
![](./image/13_34.png)
![](./image/13_35.png)
![](./image/13_36.png)
![](./image/13_37.png)
![](./image/13_38.png)
![](./image/13_39.png)
![](./image/13_40.png)
![](./image/13_43.png)
![](./image/13_44.png)
![](./image/13_45.png)
![](./image/13_41.png)
![](./image/13_42.png)
![](./image/13_46.png)
![](./image/13_47.png)
![](./image/13_48.png)
![](./image/13_49.png)
![](./image/13_50.png)
![](./image/13_51.png)
![](./image/13_52.png)
![](./image/13_53.png)

##StringTable的垃圾回收
![](./image/13_54.png)
![](./image/13_55.png)

##G1中的String去重
![](./image/13_56.png)
![](./image/13_57.png)
![](./image/13_58.png)

#第14章 垃圾回收概述
##什么是垃圾
![](./image/14_01.png)
![](./image/14_02.png)
![](./image/14_03.png)
![](./image/14_04.png)

##为什么需要GC
![](./image/14_05.png)

##早期垃圾回收
![](./image/14_06.png)
![](./image/14_07.png)

##java垃圾回收机制
![](./image/14_08.png)
![](./image/14_09.png)
![](./image/14_10.png)
![](./image/14_11.png)

#第15章 垃圾回收相关算法
##标记阶段：引用计数法
![](./image/15_01.png)
![](./image/15_02.png)
![](./image/15_03.png)
![](./image/15_04.png)
![](./image/15_05.png)
![](./image/15_06.png)

##标记阶段：可达性分析算法
![](./image/15_07.png)
![](./image/15_08.png)
![](./image/15_09.png)
![](./image/15_10.png)
![](./image/15_11.png)
![](./image/15_12.png)

##对象的finalization机制
![](./image/15_13.png)
![](./image/15_14.png)
![](./image/15_15.png)
![](./image/15_16.png)
![](./image/15_19.png)
![](./image/15_17.png)
![](./image/15_18.png)
![](./image/15_19.png)

##MAT与JProfiler的GC ROOTS溯源
![](./image/15_20.png)
![](./image/15_21.png)
![](./image/15_22.png)
![](./image/15_23.png)
![](./image/15_24.png)
![](./image/15_25.png)
![](./image/15_26.png)
![](./image/15_27.png)
![](./image/15_28.png)
![](./image/15_29.png)
![](./image/15_30.png)
![](./image/15_31.png)
![](./image/15_32.png)
![](./image/15_33.png)

- 内存溢出分析案例

![](./image/15_34.png)
![](./image/15_35.png)
![](./image/15_36.png)
![](./image/15_37.png)
![](./image/15_38.png)
![](./image/15_39.png)

##清除阶段：标记-清除算法
![](./image/15_40.png)
![](./image/15_41.png)
![](./image/15_42.png)
![](./image/15_43.png)

- 空间碎片，大对象可能放不下，所以会OOM

##清除阶段：复制算法
![](./image/15_44.png)
![](./image/15_45.png)
![](./image/15_46.png)
![](./image/15_47.png)

##清除阶段：标记-压缩算法
![](./image/15_48.png)
![](./image/15_49.png)
![](./image/15_50.png)
![](./image/15_51.png)
![](./image/15_52.png)

##小结
![](./image/15_53.png)

##分代收集算法
![](./image/15_54.png)
![](./image/15_55.png)
![](./image/15_56.png)

##增量收集算法、分区算法
![](./image/15_57.png)
![](./image/15_58.png)
![](./image/15_59.png)
![](./image/15_60.png)
![](./image/15_61.png)

#第16章 垃圾回收相关概念
##System.gc的理解
![](./image/16_01.png)
![](./image/16_02.png)
![](./image/16_03.png)
![](./image/16_04.png)
![](./image/16_05.png)
![](./image/16_06.png)
![](./image/16_07.png)
![](./image/16_08.png)

##内存溢出与内存泄露
![](./image/16_09.png)
![](./image/16_10.png)
![](./image/16_11.png)
![](./image/16_12.png)
![](./image/16_13.png)
![](./image/16_14.png)

##Stop the world
![](./image/16_15.png)
![](./image/16_16.png)
![](./image/16_17.png)
![](./image/16_20.png)
![](./image/16_18.png)
![](./image/16_19.png)

##垃圾回收的并行与并发
![](./image/16_21.png)
![](./image/16_22.png)
![](./image/16_23.png)
![](./image/16_24.png)
![](./image/16_25.png)

##安全点与安全区域
![](./image/16_26.png)
![](./image/16_27.png)
![](./image/16_28.png)
![](./image/16_29.png)

##再谈引用：强引用
![](./image/16_30.png)
![](./image/16_31.png)
![](./image/16_32.png)
![](./image/16_33.png)
![](./image/16_34.png)
![](./image/16_35.png)

##再谈引用：软引用
![](./image/16_36.png)

- 二次回收
  - 一次回收指的是那些不可达的
  - 二次回收指的是一次回收后，再回收一次

![](./image/16_37.png)
![](./image/16_38.png)
![](./image/16_39.png)

##再谈引用：弱引用
![](./image/16_40.png)
![](./image/16_41.png)

##再谈引用：虚引用
![](./image/16_42.png)
![](./image/16_43.png)
![](./image/16_44.png)
![](./image/16_45.png)
![](./image/16_46.png)
![](./image/16_47.png)
![](./image/16_48.png)

##再谈引用：终结器引用
![](./image/16_49.png)

#第17章 垃圾回收器
##GC分类与性能指标
![](./image/17_01.png)
![](./image/17_02.png)
![](./image/17_03.png)
![](./image/17_04.png)
![](./image/17_05.png)
![](./image/17_06.png)
![](./image/17_07.png)
![](./image/17_08.png)
![](./image/17_09.png)
![](./image/17_10.png)
![](./image/17_11.png)
![](./image/17_12.png)
![](./image/17_13.png)

##不同的垃圾回收器概述
![](./image/17_14.png)
![](./image/17_15.png)
![](./image/17_16.png)
![](./image/17_17.png)
![](./image/17_18.png)
![](./image/17_19.png)
![](./image/17_20.png)
![](./image/17_21.png)
![](./image/17_22.png)
![](./image/17_23.png)
![](./image/17_24.png)
![](./image/17_25.png)

##Serial回收器：串行回收
![](./image/17_26.png)
![](./image/17_27.png)
![](./image/17_28.png)
![](./image/17_29.png)

##ParNew回收器：并行回收
![](./image/17_30.png)
![](./image/17_31.png)
![](./image/17_32.png)
![](./image/17_33.png)
![](./image/17_34.png)

##Parallel回收器：吞吐量优先
![](./image/17_35.png)
![](./image/17_36.png)
![](./image/17_37.png)
![](./image/17_38.png)
![](./image/17_39.png)
![](./image/17_40.png)
![](./image/17_41.png)

##CMS回收器：低延迟
![](./image/17_42.png)
![](./image/17_43.png)
![](./image/17_44.png)
![](./image/17_45.png)
![](./image/17_46.png)
![](./image/17_47.png)
![](./image/17_48.png)
![](./image/17_49.png)
![](./image/17_50.png)
![](./image/17_51.png)
![](./image/17_52.png)
![](./image/17_53.png)
![](./image/17_54.png)

##G1回收器：区域化分代式
![](./image/17_55.png)
![](./image/17_56.png)
![](./image/17_57.png)
![](./image/17_58.png)
![](./image/17_59.png)
![](./image/17_60.png)
![](./image/17_61.png)
![](./image/17_62.png)
![](./image/17_63.png)
![](./image/17_65.png)
![](./image/17_66.png)
![](./image/17_67.png)
![](./image/17_68.png)
![](./image/17_69.png)
![](./image/17_70.png)
![](./image/17_71.png)
![](./image/17_72.png)
![](./image/17_73.png)
![](./image/17_74.png)
![](./image/17_75.png)
![](./image/17_76.png)
![](./image/17_77.png)
![](./image/17_78.png)
![](./image/17_79.png)
![](./image/17_80.png)
![](./image/17_81.png)
![](./image/17_82.png)
![](./image/17_83.png)
![](./image/17_84.png)
![](./image/17_85.png)
![](./image/17_86.png)

##垃圾回收器总结
![](./image/17_87.png)
![](./image/17_88.png)
![](./image/17_89.png)
![](./image/17_90.png)
![](./image/17_91.png)
![](./image/17_92.png)
![](./image/17_93.png)

##GC日志分析
![](./image/17_94.png)
![](./image/17_95.png)
![](./image/17_96.png)
![](./image/17_97.png)
![](./image/17_98.png)
![](./image/17_99.png)
![](./image/17_100.png)
![](./image/17_101.png)
![](./image/17_102.png)
![](./image/17_103.png)
![](./image/17_104.png)
![](./image/17_105.png)
![](./image/17_106.png)
![](./image/17_107.png)
![](./image/17_109.png)
![](./image/17_110.png)
![](./image/17_111.png)
![](./image/17_112.png)

##垃圾回收器的新发展
![](./image/17_113.png)
![](./image/17_114.png)
![](./image/17_115.png)
![](./image/17_116.png)
![](./image/17_117.png)
![](./image/17_118.png)
![](./image/17_119.png)
![](./image/17_120.png)
![](./image/17_121.png)
![](./image/17_122.png)
![](./image/17_123.png)
![](./image/17_124.png)
![](./image/17_125.png)
![](./image/17_126.png)
![](./image/17_127.png)

#第18章 Class文件结构
##概述
###字节码文件的跨平台性
![](./image/18_01.png)
![](./image/18_02.png)
![](./image/18_03.png)

###java的前端编译器
![](./image/18_04.png)
![](./image/18_05.png)

###透过字节码指令看代码细节
![](./image/18_06.png)
![](./image/18_07.png)
![](./image/18_08.png)
![](./image/18_09.png)
![](./image/18_10.png)
![](./image/18_11.png)

- 看字节码，理解上述3个例子

##虚拟机的基石：Class文件
![](./image/18_12.png)
![](./image/18_13.png)
![](./image/18_14.png)

##Class文件结构
![](./image/18_15.png)
![](./image/18_16.png)
![](./image/18_17.png)
![](./image/18_18.png)
![](./image/18_19.png)

- Demo字节码的解析.xlsx

###魔数：Class文件的标志
![](./image/18_20.png)

###Class文件的版本号
![](./image/18_21.png)
![](./image/18_22.png)
![](./image/18_23.png)

###常量池：存放所有常量
![](./image/18_24.png)
![](./image/18_25.png)

####常量池计数器
![](./image/18_26.png)

####常量池表
![](./image/18_27.png)
![](./image/18_28.png)

#####字面量和符号引用
![](./image/18_29.png)
![](./image/18_30.png)
![](./image/18_31.png)


#####常量类型和结构
- 详见常见类型和结构.xls
![](./image/18_32.png)
![](./image/18_34.png)
![](./image/18_33.png)
![](./image/18_35.png)
![](./image/18_36.png)

###访问标识
![](./image/18_37.png)
![](./image/18_38.png)
![](./image/18_39.png)

###类索引、父类索引、接口索引集合
![](./image/18_40.png)
![](./image/18_41.png)

###字段表集合
![](./image/18_42.png)
####字段计数器
![](./image/18_43.png)
####字段表
![](./image/18_44.png)
![](./image/18_45.png)
![](./image/18_46.png)
![](./image/18_47.png)
![](./image/18_48.png)
![](./image/18_49.png)

###方法表集合
![](./image/18_50.png)
####方法计数器
![](./image/18_51.png)

####方法表
![](./image/18_52.png)
![](./image/18_53.png)


###属性表集合
![](./image/18_54.png)

- 详细笔记多，图没截到

####属性计数器
![](./image/18_55.png)

####属性表
![](./image/18_56.png)

- 详细笔记多，图没截到

###小结
![](./image/18_57.png)

##使用javap指令解析Class文件
###解析字节码的作用
![](./image/18_58.png)

###javac -g操作
![](./image/18_59.png)

###javap的用法
![](./image/18_60.png)
![](./image/18_61.png)
![](./image/18_62.png)

- javap -v -p *.class拥有最全的信息

###使用举例

###总结
![](./image/18_63.png)

#第19章 字节码指令集与解析举例
##概述
![](./image/19_01.png)

###执行模型
![](./image/19_02.png)

###字节码与数据类型
![](./image/19_03.png)

###指令分类
![](./image/19_04.png)

##加载与存储指令
![](./image/19_05.png)
![](./image/19_07.png)
![](./image/19_06.png)

###复习：再谈操作数栈与局部变量表
![](./image/19_08.png)
![](./image/19_09.png)
![](./image/19_10.png)
![](./image/19_11.png)

###局部变量压栈指令

###常量入栈指令

###出栈装入局部变量表指令

##算数指令

##类型转换指令

##对象的创建与访问指令



#第20章 类的加载过程详解

#第21章 再谈类的加载器

#第22章 概述篇
##大厂面试题
![](./image/22_02.png)
![](./image/22_03.png)
##北背景说明
###生产环境中的问题
![](./image/22_04.png)

###为什么要调优
![](./image/22_05.png)

###不同阶段的考虑
![](./image/22_06.png)

##调优概述
###监控的依据
![](./image/22_07.png)
###调优大方向
![](./image/22_08.png)

##性能优化步骤
###第一步性能监控
![](./image/22_09.png)
![](./image/22_10.png)
###第二步性能分析
![](./image/22_11.png)
![](./image/22_12.png)
###第三步性能优化
![](./image/22_13.png)
![](./image/22_14.png)

##性能评价测试指标
###停顿时间（卡顿时间）
![](./image/22_15.png)
![](./image/22_16.png)
###吞吐量
![](./image/22_17.png)

###并发数
![](./image/22_18.png)

###内存占用
![](./image/22_19.png)

###相互间的关系
![](./image/22_20.png)

#第23章 JVM监控及诊断工具-命令行篇

#第24章 JVM监控及诊断工具-GUI篇

#第25章 JVM运行时参数

#第26章 分析GC日志