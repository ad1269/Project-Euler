public class Two{

    public static int fibonacci(int n) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String []args){
        int a = 1;
        long sum = 0;
        for(int i = 1; a < 4000000; i++) {
            a = fibonacci(i);
            if(a % 2 == 0)
                sum += a;
        }
        System.out.println(sum);
    }
}