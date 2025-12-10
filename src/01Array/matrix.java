import java.util.*;
public class matrix
{
    public static void main(String args[])
    {
        int matrix[][]=new int[3][3];
        int row=matrix.length;
        int column=matrix[0].length;

        Scanner sc=new Scanner(System.in);
        //input
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                matrix[i][j]=sc.nextInt();
            }
        }
        //output
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        int min = matrix[0][0]; 
        int max = matrix[0][0];

        for (int i = 0; i < row; i++) 
        {
            for (int j = 0; j < column; j++) 
            {
                if (matrix[i][j] < min) 
                {
                    min = matrix[i][j]; 
                }
                if (matrix[i][j] > max) 
                {
                    max = matrix[i][j]; 
                }
            }
        }
        System.out.println("Minimum value in the matrix: " + min);
        System.out.println("Maximum value in the matrix: " + max);
    }
}