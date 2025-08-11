// Binary string problem
// Print all the binary strings of size "n" without consecutive ones (1's)


public class BinaryString
{
    public static void binaryString(int n, int lastplace, String str)
    {
        if(n==0){
            System.out.println(str);
            return;
        }
        // kaam
        binaryString(n-1, 0, str+"0");
        if (lastplace==0) {
        binaryString(n-1, 1, str+"1");
        }
    }
    public static void main(String[] args) 
    {
        binaryString(3, 0, "");
    }
}