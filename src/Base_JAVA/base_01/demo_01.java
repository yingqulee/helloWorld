package Base_JAVA.base_01;

public class demo_01 {

    public static void Swap(int[] array,int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void Print(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String[] args) {
/*        int a[] = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
        System.out.println("=================");

        int b[] = new int[3];
        b = a;
        for (int i = 0; i < 3; i++) {
            System.out.print(b[i]+" ");
        }
        System.out.println();
        System.out.println("=================");
        b[0]=100;
        b[1]=200;
        b[2]=300;
        for (int i = 0; i < 3; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
 */
    int array[] = {0,1,2,3,4,5,6,7,8,9};
        Print(array);
        System.out.println();
        System.out.println("====================");

        for (int i = 0; i < array.length/2; i++) {
//            int temp = array[array.length-i-1];
//            array[array.length-i-1] = array[i] ;
//            array[i] = temp;
           Swap(array,i,array.length-1-i);
        }
        Print(array);
        System.out.println();
    }
}
