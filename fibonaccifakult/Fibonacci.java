public class Fibonacci
{
    public int fibonacci(int n){
        if(n<2)
            return n;

        return (fibonacci(n-1)+fibonacci(n-2));
    }

    public int fibonaccii(int n){
        int temp1=0;
        int temp2=1;
        int result = 0;
        for(int i=2; i<=n; i++){
                result = temp1 + temp2;
                temp1 = temp2;
                temp2 = result;
        }
        return result;
    }
}
