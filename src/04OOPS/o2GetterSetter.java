class Pencil
{
    private String color;
    private int tip;

    String getColor()
    {
        return this.color;
    }
    int getTip()
    {
        return this.tip;
    }
    void setColor (String newColor)
    {
        this.color=newColor;
    }
    void setTip(int newTip)
    {
        this.tip=newTip;
    }
}


public class o2GetterSetter
{
    
    public static void main(String args[])
    {
        Pencil p1 = new Pencil(); // created a pencil object called p1

        p1.setColor("Blue");
        System.out.println(p1.getColor());

        p1.setTip(5);
        System.out.println(p1.getTip());

        p1.setColor("Yellow");
        
        System.out.println(p1.getColor());
    }
}


/*
Get : to return the value
Set : to modify the value
this : this keyword is used to refer to the current object
this is mainly used when the variable name and input name is same
*/