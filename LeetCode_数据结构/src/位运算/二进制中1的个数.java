package 位运算;

public class 二进制中1的个数 {
    public static void main(String[] args) {
        System.out.println(NumberOf1(8));
        System.out.println(NumberOf2(10));
    }
    public static int NumberOf1(int n){//1不断左移 最终会是0的 防止死循环
        int flag=1;
        int count=0;
        while(flag!=0){
            if((flag&n)!=0){
                count++;
            }
            flag<<=1;
        }
        return count;
    }
    public static int NumberOf2(int n){
        int count=0;
        while(n!=0){//n不为0
            count++;
            n=n&(n-1);
        }
        return count;
    }
}
