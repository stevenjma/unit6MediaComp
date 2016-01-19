import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void keepOnlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(0);
        pixelObj.setGreen(0);
      }
    }
  }
  
  public void negate()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(255 - pixelObj.getRed());
        pixelObj.setGreen(255 - pixelObj.getGreen());
        pixelObj.setBlue(255 - pixelObj.getBlue());
      }
    }
  }
  
  public void greyscale()
  {
    Pixel[][] pixels = this.getPixels2D();
    int grey = 0;
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        grey = pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue();
        pixelObj.setRed(grey);
        pixelObj.setGreen(grey);
        pixelObj.setBlue(grey);
      }
    }
  }
  
  public void sepia()
  {
    Pixel[][] pixels = this.getPixels2D();
    int grey = 0;
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        grey = pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue();
        pixelObj.setRed(grey);
        pixelObj.setGreen(grey);
        pixelObj.setBlue(grey);
        if (pixelObj.getRed() < 60)
        {
            pixelObj.setRed((int)0.9 * pixelObj.getRed()); 
            pixelObj.setGreen((int)0.9 * pixelObj.getGreen()); 
            pixelObj.setBlue((int)0.9 * pixelObj.getBlue());
        }
        else if (pixelObj.getRed() < 190)
        {
            pixelObj.setBlue((int)0.8 * pixelObj.getBlue());
        }
        else
        {
            pixelObj.setBlue((int)0.9 * pixelObj.getBlue());
        }
      }
    }
  }
  
  public void posterize()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        if (pixelObj.getRed() < 63)
        {
            pixelObj.setRed(32);
        }
        else if (pixelObj.getRed() < 127)
        {
            pixelObj.setRed(64);
        }
        else if (pixelObj.getRed() < 191)
        {
            pixelObj.setRed(96);
        }
        else
        {
            pixelObj.setRed(128);
        }
        if (pixelObj.getBlue() < 63)
        {
            pixelObj.setBlue(32);
        }
        else if (pixelObj.getBlue() < 127)
        {
            pixelObj.setBlue(64);
        }
        else if (pixelObj.getBlue() < 191)
        {
            pixelObj.setBlue(96);
        }
        else
        {
            pixelObj.setBlue(128);
        }
        if (pixelObj.getGreen() < 63)
        {
            pixelObj.setGreen(32);
        }
        else if (pixelObj.getGreen() < 127)
        {
            pixelObj.setGreen(64);
        }
        else if (pixelObj.getGreen() < 191)
        {
            pixelObj.setGreen(96);
        }
        else
        {
            pixelObj.setGreen(128);
        }
      }
    }
  }
  
  public void customPosterize(int numberOfBins)
  {
    Pixel[][] pixels = this.getPixels2D();
    int thing = 255 / numberOfBins;
    int num = thing / 2;
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        for (int i = 0; i < numberOfBins; i++)
        {
            if (pixelObj.getRed() < thing * i)
            {
                pixelObj.setRed(num * i);
            }
        }
        for (int i = 0; i < numberOfBins; i++)
        {
            if (pixelObj.getBlue() < thing * i)
            {
                pixelObj.setBlue(num * i);
            }
        }
        for (int i = 0; i < numberOfBins; i++)
        {
            if (pixelObj.getGreen() < thing * i)
            {
                pixelObj.setGreen(num *i);
            }
        }
      }
    }
  }
  
  public void edgeDetect()
  {
      Pixel[][] pixels = this.getPixels2D();
      Pixel pixel = null;
      Pixel above = null;
      for (int row = 1; row < pixels.length; row++)
      {
          for (int col = 0; col < pixels[0].length; col++)
          {
              pixel = pixels[row][col];
              above = pixels[row - 1][col];
              double distance = pixel.getAverage() - above.getAverage();
              if (distance < 0)
              {
                  distance = 0 - distance;
              }
              if (distance > 50)
              {
                  pixel.setRed(0);
                  pixel.setGreen(0);
                  pixel.setBlue(0);
              }
              else
              {
                  pixel.setRed(255);
                  pixel.setGreen(255);
                  pixel.setBlue(255);
              }
          }
      }
  }
  
  public void otherEdgeDetect()
  {
      Pixel[][] pixels = this.getPixels2D();
      Pixel pixel = null;
      Pixel above = null;
      for (int row = 0; row < pixels.length; row++)
      {
          for (int col = 1; col < pixels[0].length; col++)
          {
              pixel = pixels[row][col];
              above = pixels[row ][col - 1];
              double distance = pixel.getAverage() - above.getAverage();
              if (distance < 0)
              {
                  distance = 0 - distance;
              }
              if (distance > 50)
              {
                  pixel.setRed(0);
                  pixel.setGreen(0);
                  pixel.setBlue(0);
              }
              else
              {
                  pixel.setRed(255);
                  pixel.setGreen(255);
                  pixel.setBlue(255);
              }
          }
      }
  }
  
  public void fixUnderwater()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(255);
      }
    }
  }
  
  public void cropAndCopy(Picture sourcePicture, int startSourceRow, int startSourceCol, 
    int endSourceRow, int endSourceCol, int startDestRow, int startDestCol)
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel[][] pixels2 = sourcePicture.getPixels2D();
    Pixel pixel = null;
    int count = 0;
    for (int row = startSourceRow; row < endSourceRow; row++)
    {
      int innerCount = 0;
      for (int col = startSourceCol; col < endSourceCol; col++)
      {
        pixel = pixels2[row][col];
        pixels[startDestRow + count][startDestCol + innerCount].setColor(pixel.getColor());
        innerCount++;
      }
      count++;
    } 
  }
  
  public void scaleByHalf()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel[][] pixels2 = pixels;
    Pixel pixel = null;
    int count = 0;
    for (int row = 0; row < pixels.length; row+=2)
    {
      int innerCount = 0;
      for (int col = 0; col < pixels[0].length; col+=2)
      {
        pixel = pixels2[row][col];
        pixels[count][innerCount].setColor(pixel.getColor());
        innerCount++;
      }
      count++;
    } 
  }
  
  public void scaleByFactor(int factor)
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel[][] pixels2 = pixels;
    Pixel pixel = null;
    int count = 0;
    for (int row = 0; row < pixels.length; row+=factor)
    {
      int innerCount = 0;
      for (int col = 0; col < pixels[0].length; col+=factor)
      {
        pixel = pixels2[row][col];
        pixels[count][innerCount].setColor(pixel.getColor());
        innerCount++;
      }
      count++;
    } 
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println(count);
  }
  
  public void mirrorArms()
  {
    int mirrorPoint = 191;
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int col = 104; col < 170; col++)
    {
      // loop from 13 to just before the mirror point
      for (int row = 158; row < mirrorPoint; row++)
      {
        
        topPixel = pixels[row][col];      
        bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    }
    
    mirrorPoint = 196;
    
    for (int col = 239; col < 294; col++)
    {
      // loop from 13 to just before the mirror point
      for (int row = 172; row < mirrorPoint; row++)
      {
        
        topPixel = pixels[row][col];      
        bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    }
  }
  
  public void mirrorGull()
  {
    int mirrorPoint = 344;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 235; row < 321; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 238; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  public void mirrorVerticalRighttoLeft()
  {
      Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = (width / 2); col > 0; col--)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    } 
  }
  
  public void mirrorHorizontal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int length = pixels.length;
    for (int col = 0; col < pixels[0].length; col++)
    {
      for (int row = 0; row < length / 2; row++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[length - 1 - row][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    } 
  }
  
  public void mirrorHorizontalBottomtoTop()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int length = pixels.length;
    for (int col = 0; col < pixels[0].length; col++)
    {
      for (int row = 0; row < length / 2; row++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[length - 1 - row][col];
        topPixel.setColor(bottomPixel.getColor());
      }
    } 
  }
  
  public void mirrorDiagonally()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topleftPixel = null;
    Pixel bottomrightPixel = null;
    int diagonallength = 0;
    for (int row = 0; row < pixels.length; row++)
    {
        for (int col = 0; col < pixels[0].length; col++)
        {
            if ( row == col)
            {
                diagonallength++;
            }
        }
    }
    for (int col = 0; col < diagonallength; col++)
    {
      for (int row = 0; row < diagonallength; row++)
      {
        topleftPixel = pixels[row][col];
        bottomrightPixel = pixels[diagonallength - 1 - col][diagonallength - 1 - row];
        bottomrightPixel.setColor(topleftPixel.getColor());
      }
    } 
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
