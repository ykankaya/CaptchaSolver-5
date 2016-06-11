/*
*
* author : Ajmal Moochingal 
* This work is licensed under a Creative Commons Attribution 3.0 Unported License
* http://creativecommons.org/licenses/by/3.0/deed.en_US
*
*/



import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.lang.Math;


public class CaptchaSolver
{

        public static void main(String[] args) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("captcha.gif"));
        } catch (IOException e) {

        }
        int height = img.getHeight();
        int width = img.getWidth();
      
       int black = ((0 <<16 ) + (0 << 8) + 0) | 0XFF000000 ; 
       
       
       int topStart= 8, topEnd = 17;
       int rStart = 10, rEnd = 62;
       
       int[] r = new int[6];
       int[] n = new int[6];
       
       
       for (int q=0; q<6 ; q++){
           r[q] = 0;
           n[q] = 0;
        }
       
       for (int h = topStart; h< topEnd+1; h++)
        {
            for (int w = rStart; w<rEnd+1; w++)
            {
                if(img.getRGB(w,h)== black){
                    if(w >= rStart && w<=rStart+7){
                        r[0]++;
                    }
                    else if(w >= rStart+9 && w<=rStart+7+9){
                        r[1]++;
                    }
                    else if(w >= rStart+9+9 && w<=rStart+7+9+9){
                        r[2]++;
                    }
                    else if(w >= rStart+9+9+9 && w<=rStart+7+9+9+9){
                        r[3]++;
                    }
                    else if(w >= rStart+9+9+9+9 && w<=rStart+7+9+9+9+9){
                        r[4]++;
                    }
                    else if(w >= rStart+9+9+9+9+9 && w<=rStart+7+9+9+9+9+9){
                        r[5]++;
                    }
             
                }
                
            }
        }   
       
        int num = 0;
        int xMid = 13;
        int yMid = 12;
        for (int q=0; q<6 ; q++){
                      
           if(r[q] == 39){
                if(img.getRGB(xMid + q*9, yMid) == black )
                    n[q] = 6;
                else 
                    n[q] = 9;                
            }
            
            else if(r[q] == 27){
                n[q] = 1;
            }
            else if(r[q] == 32){
                n[q] = 2;
            }
            else if(r[q] == 31){
                n[q] = 3;
            }
            else if(r[q] == 35){
                n[q] = 4;
            }
            else if(r[q] == 37){
                n[q] = 5;
            }
            else if(r[q] == 26){
                n[q] = 7;
            }
            else if(r[q] == 40){
                n[q] = 8;
            }
                       
            num += ( n[q] ) * Math.pow(10, 5-q);
            
        }
        
        System.out.println(num);
        
      
    
}
}

