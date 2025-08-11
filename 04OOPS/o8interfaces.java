public class o8interfaces
{
    public static void main(String[] args) 
    {
        Queen q = new Queen();
        q.moves();
    }
}
//Multiiple inheritance

interface Herbivore
{}
interface Carnivore
{}
class Bear implements Herbivore,Carnivore
{}


// Use of interface

interface ChessPlayer
{
    void moves();
}
class Queen implements ChessPlayer
{
    public void moves()     // public is used, otherwise "default" by default
    {
        System.out.println("up,down,left,right,diagonal");
    }
}