public class CollageLab
{
    public static void main (String [] args)
    {
        Picture picture1 = new Picture("cool stuff.jpg");
        Picture picture2 = new Picture("cool stuff.jpg");
        Picture picture3 = new Picture("cool stuff.jpg");
        Picture picture4 = new Picture("cool stuff.jpg");
        Picture picture5 = new Picture("cool stuff.jpg");
        Picture picture6 = new Picture("cool stuff.jpg");
        Picture picture7 = new Picture("cool stuff.jpg");
        Picture picture8 = new Picture("cool stuff.jpg");
        Picture picture9 = new Picture("cool stuff.jpg");
        Picture canvas = new Picture(1920, 3072);
        picture2.fixUnderwater();
        picture3.negate();
        picture4.zeroBlue();
        picture5.zeroRed();
        picture6.mirrorDiagonally();
        picture7.zeroGreen();
        picture8.posterize();
        picture9.greyscale();
        canvas.copy(picture1,0,0);
        canvas.copy(picture2,640,1024);
        canvas.copy(picture3,640,0);
        canvas.copy(picture4,0,1024);
        canvas.copy(picture5,1280,0);
        canvas.copy(picture6,1280,1024);
        canvas.copy(picture7,1280,2048);
        canvas.copy(picture8,0,2048);
        canvas.copy(picture9,640,2048);
        canvas.explore();
    }
}