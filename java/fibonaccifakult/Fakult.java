import java.math.BigInteger;

public class Fakult
{
    public int calcFakult(int n){
        int e=1;
        for(int i=1; i<=n; i++){
            e *=i;
        }
        return e;
    }

    public BigInteger calcFakult(BigInteger n){
        BigInteger e = new BigInteger("1");
        for(BigInteger i = new BigInteger("1"); i.compareTo(n) <= 0; i = i.add(new BigInteger("1"))){
            e = e.multiply(i);
        }

        return e;
    }
}

