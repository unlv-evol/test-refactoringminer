import java.awt.*;

class Painter
{
    private Color myColor;
    public Painter(Color c)
    {
        myColor = c;
        InitPainter(myColor);
    }
    private void InitPainter(Color color)
    {
        //init painter
    }
}
class Circle
{
    private Painter myPainter;
    public Circle(Color c)
    {
        myPainter = new Painter(c);
    }
}