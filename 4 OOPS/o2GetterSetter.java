public class o2GetterSetter
{
    public static void main(String args[])
    {
        Pen p1 = new Pen(); // created a pen object called p1

        p1.setColor("Blue");
        System.out.println(p1.getColor());

        p1.setTip(5);
        System.out.println(p1.getTip());

        p1.setColor("Yellow");
        System.out.println(p1.getColor());
    }
}

class Pen
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
/*
Get : to return the value
Set : to modify the value
this : this keyword is used to refer to the current object
this is mainly used when the variable name and input name is same
*/