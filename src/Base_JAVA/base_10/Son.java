package Base_JAVA.base_10;

public class Son extends Father {

    @Override
    public void method() {
        System.out.println("我是子类,我把父类方法覆盖重写了");
    }

    /*@Override
    public void methodFinal() {
        System.out.println("我是子类,我无法把父类final方法覆盖重写");
    }*/

}
