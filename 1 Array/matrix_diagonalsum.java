public class matrix_diagonalsum
{
    public static int diagonalsum(int arr[][])
    {
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            //primary diagonal
            sum+=arr[i][i];
            //secondary diagonal
            int j=arr.length-i-1;
            if (i!=j)
            {
                sum+=arr[i][j];
            }
        }
        return sum;
    }
    public static void main(String args[])
    {
        int matrix[][]= {
                            {1,2,3,4},
                            {5,6,7,8},
                            {9,10,11,12},
                            {13,14,15,16}
                        };
        int result = diagonalsum(matrix);
        System.out.println("Diagonal Sum: " + result);   
    }
}
