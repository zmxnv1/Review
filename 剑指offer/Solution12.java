public class Solution12{
    public double Power(double base, int exponent) {
        boolean flag = false;
        if(exponent < 0) {
            flag = true;
            exponent *= -1;
        }
        if(exponent == 0) return 1;
        if(exponent == 1) {
            if(flag) return 1 / base;
            return base;
        }
        if(exponent % 2 == 0) {
            if(flag) return 1 / Power(base * base, exponent / 2);
            return Power(base * base, exponent / 2);
        } 
        else {
           if(!flag) return base * Power(base * base, exponent / 2 );
           return 1 / (base * Power(base * base, exponent / 2 ));
        }
    }
}