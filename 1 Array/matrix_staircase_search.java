public class matrix_staircase_search
{
    public static boolean starircasesearch(int arr[][],int key)
    {                                   
        //start searching either from top right or bottom left
       int row=0;
       int col=arr[0].length-1;
       // in this case we are starting from top right corner
       while(row<arr.length && col>=0)
       {
            if (arr[row][col]==key)
            {
                System.out.println("Key found at (Row:"+row+",Col:"+col+")\n");
                return true;
            }
            else if (arr[row][col]>key)
            {
                col--;
            }
            else
            {
                row++;
            }
       }
       System.out.println("Key not found");
       return false;
    }
    public static void main(String args[])
    {
        int matrix[][]= {
                            {10,20,30,40},
                            {15,25,35,45},
                            {27,31,46,56},
                            {32,33,38,65}
                        }; 
        int key=33; 
        starircasesearch(matrix, key);
    }
}
