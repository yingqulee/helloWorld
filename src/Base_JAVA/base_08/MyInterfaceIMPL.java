package Base_JAVA.base_08;

//2.接口的实现类必须覆盖重写(实现)接口中所有的抽象方法.

/*注意事项:
        如果实现类并没有覆盖重写接口中所有的抽象方法,那么这个实现类自己就必须是抽象类

  △一个类的直接父类是唯一的,但是一个类可以同时实现多个接口.
  格式:
        public class MyInterfaceIMPL implements 接口A,接口B,接口C..{
                //覆盖重写所有抽象方法
        }
  △如果实现类所实现的多个接口当中,存在重复的抽象方法,那么只需要覆盖重写一次即可.
  △如果实现类没有覆盖重写所有接口当中的所有抽象方法,那么实现类就必须是一个抽象类
  △如果实现类所实现的多个接口当中,存在重复的默认方法,那么实现类一定要对冲突的默认方法进行覆盖重写
  △一个类如果直接父类当中的方法,和接口当中的默认方法产生了冲突,优先用父类当中的方法(extends > implements)

 */
public class MyInterfaceIMPL implements MyInterfacePractice {
    @Override
    public void method1() {
        System.out.println("第一");
    }

    @Override
    public void method2() {
        System.out.println("第二");
    }

    @Override
    public void method3() {
        System.out.println("第三");
    }

    @Override
    public void method4() {
        System.out.println("第四");
    }


}
