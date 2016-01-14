public class CollageLab
{
    public static void main (String [] args)
    {
        Picture picture1 = new Picture("johncena.jpg");
        Picture picture2 = new Picture("johncena.jpg");
        Picture picture3 = new Picture("johncena.jpg");
        Picture picture4 = new Picture("johncena.jpg");
        Picture canvas = new Picture(720, 960);
        picture2.fixUnderwater();
        picture3.negate();
        picture4.sepia();
        picture4.negate();
        Pixel[][] finalPic = canvas.getPixels2D();
        Pixel pixel = null;
        Pixel[][] pixels = picture1.getPixels2D();
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                pixel = pixels[row][col];
                finalPic[row][col].setColor(pixel.getColor());
            }
        }
        pixels = picture2.getPixels2D();
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                pixel = pixels[row][col];
                finalPic[row + pixels.length][col].setColor(pixel.getColor());
            }
        }
        pixels = picture3.getPixels2D();
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                pixel = pixels[row][col];
                finalPic[row][col + pixels[0].length].setColor(pixel.getColor());
            }
        }
        pixels = picture4.getPixels2D();
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                pixel = pixels[row][col];
                finalPic[row + pixels.length][col + pixels[0].length].setColor(pixel.getColor());
            }
        }
        canvas.explore();
    }
}