public class CollageLab
{
    public static void main (String [] args)
    {
        Picture picture1 = new Picture("johncena.jpg");
        Picture picture2 = new Picture("johncena.jpg");
        Picture picture3 = new Picture("johncena.jpg");
        Picture picture4 = new Picture("johncena.jpg");
        Picture picture5 = new Picture("johncena.jpg");
        Picture picture6 = new Picture("johncena.jpg");
        Picture picture7 = new Picture("johncena.jpg");
        Picture picture8 = new Picture("johncena.jpg");
        Picture picture9 = new Picture("johncena.jpg");
        Picture canvas = new Picture(1080, 1440);
        picture2.fixUnderwater();
        picture3.negate();
        picture4.otherEdgeDetect();
        picture5.customPosterize(3);
        picture6.mirrorDiagonally();
        picture7.sepia();
        picture8.posterize();
        picture9.greyscale();
        canvas.copy(picture1,0,0);
        canvas.copy(picture2,360,480);
        canvas.copy(picture3,360,0);
        canvas.copy(picture4,0,480);
        canvas.copy(picture5,720,0);
        canvas.copy(picture6,720,480);
        canvas.copy(picture7,720,960);
        canvas.copy(picture8,0,960);
        canvas.copy(picture9,360,960);
        canvas.explore();
    }
}