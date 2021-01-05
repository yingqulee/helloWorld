package Base_JAVA.base_03;

public class demo_01 {
    public static void main(String[] args) {
        /*//随机数练习
        Random rd = new Random();
        for (int i = 1; i <= 100; i++) {
            int num = rd.nextInt(10);
            System.out.print(num+" ");
            if (i%10==0){
                System.out.println();
            }
        }*/

        /*//猜数字游戏
        Random rd = new Random();
        int randomNum = rd.nextInt(100)+1;
        Scanner in = new Scanner(System.in);

        while(true){
            System.out.println("请输入你猜测的数字: ");
            int guessNum = in.nextInt();
            if(guessNum > randomNum){
                System.out.println("猜大了");
            }else if (guessNum < randomNum){
                System.out.println("猜小了");
            }else{
                System.out.println("恭喜你!猜对了");
                break;
            }
        }
        System.out.println("游戏结束!");*/

    }
}
