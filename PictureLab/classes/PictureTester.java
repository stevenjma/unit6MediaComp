/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  public static void testKeepOnlyBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.keepOnlyBlue();
    beach.explore();
  }
  
  public static void testNegate()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.negate();
    beach.explore();
  }
  
  public static void testGreyscale()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.greyscale();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  public static void testMirrorVerticalRighttoLeft()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRighttoLeft();
    caterpillar.explore();
  }
  
  public static void testMirrorHorizontal()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontal();
    caterpillar.explore();
  }
  
  public static void testMirrorHorizontalBottomtoTop()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontalBottomtoTop();
    caterpillar.explore();
  }
  
  public static void testMirrorDiagonally()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorDiagonally();
    caterpillar.explore();
  }
  
  public static void testMirrorArms()
  {
      Picture snowman = new Picture("snowman.jpg");
      snowman.explore();
      snowman.mirrorArms();
      snowman.explore();
  }
  
  public static void testMirrorGull()
  {
      Picture gull = new Picture("seagull.jpg");
      gull.explore();
      gull.mirrorGull();
      gull.explore();
  }
  
  public static void testFixUnderwater()
  {
      Picture water = new Picture("water.jpg");
      water.explore();
      water.fixUnderwater();
      water.explore();
  }
  
  public static void testCropAndCopy()
  {
      Picture water = new Picture("water.jpg");
      Picture snowman = new Picture("snowman.jpg");
      water.explore();
      water.cropAndCopy(snowman, 100, 200, 200, 300, 30, 40);
      water.explore();
  }
  
  public static void testScaleByHalf()
  {
      Picture water = new Picture("cool stuff.jpg");
      water.explore();
      water.scaleByHalf().explore();
  }
  
  public static void testScaleByFactor()
  {
      Picture water = new Picture("cool stuff.jpg");
      water.explore();
      water.scaleByFactor(3).explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    testScaleByFactor();
    //testScaleByHalf();
    //testCropAndCopy();
    //testMirrorGull();
    //testMirrorArms();
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testNegate();
    //testGreyscale();
    //testFixUnderwater();
    //testMirrorVerticalRighttoLeft();
    //testMirrorHorizontal();
    //testMirrorHorizontalBottomtoTop();
    //testMirrorDiagonally();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}