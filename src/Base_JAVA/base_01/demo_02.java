package Base_JAVA.base_01;

public class demo_02 {
    public static void main(String[] args) {
        Phone one = getphone();

    }
    public static Phone getphone(){
        Phone phone = new Phone();
        phone.name = "凤梨手机";
        phone.price = 9999;
        return phone;
    }
}
