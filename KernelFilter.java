import java.awt.Color;

public class KernelFilter {

    // Strategy : modulo arimathic (example: clock is 12 modulo, 1300 is 0100, such that 13%12 = 1)
    //            for reverse case (e.g. col[-1]), we need offset, for example, (-1 + 5) % 5 = 4

    public static Picture identity(Picture picture){

        int height = picture.height();
        int width = picture.width();

        Picture filtered = new Picture(width,height);

        int[][] a = {

            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

        
        for (int row = 0; row < height; row++){

            for (int col = 0; col < width; col++){

                // initialize the sum of intensity of RGB

                double red = 0;
                double blue = 0;
                double green = 0;

                for (int i = 0; i < a.length; i++){

                    for (int j = 0; j < a.length; j++){

                        // modulo arimatic

                        int offsetRow = i - a.length/2;
                        int offsetCol = j - a.length/2;

                        int neighborRow = (row + offsetRow + height) % height;
                        int neighborCol = (col + offsetCol + width) % width;

                        Color pixel = picture.get(neighborCol, neighborRow);

                        red += pixel.getRed()*a[i][j];
                        blue += pixel.getBlue()*a[i][j];
                        green += pixel.getGreen()*a[i][j];
                    }
                }

                int r = (int)Math.max(0,Math.min(255,Math.round(red)));
                int b = (int)Math.max(0,Math.min(255,Math.round(blue)));
                int g =(int)Math.max(0,Math.min(255,Math.round(green)));

               filtered.set(col,row, new Color(r,g,b));
            }
        }

        return filtered;
    }

    public static Picture gaussian(Picture picture){

        int height = picture.height();
        int width = picture.width();

        Picture filtered = new Picture(width,height);

        int[][] a = {

            {1, 2, 1},
            {2, 4, 2},
            {1, 2, 1}
        };

        
        for (int row = 0; row < height; row++){

            for (int col = 0; col < width; col++){

                // initialize the sum of intensity of RGB

                double red = 0;
                double blue = 0;
                double green = 0;

                for (int i = 0; i < a.length; i++){

                    for (int j = 0; j < a.length; j++){

                        // modulo arimatic

                        int offsetRow = i - a.length/2;
                        int offsetCol = j - a.length/2;

                        int neighborRow = (row + offsetRow + height) % height;
                        int neighborCol = (col + offsetCol + width) % width;

                        Color pixel = picture.get(neighborCol, neighborRow);

                        red += pixel.getRed()*a[i][j]/16.0;
                        blue += pixel.getBlue()*a[i][j]/16.0;
                        green += pixel.getGreen()*a[i][j]/16.0;
                    }
                }

                int r = (int)Math.max(0,Math.min(255,Math.round(red)));
                int b = (int)Math.max(0,Math.min(255,Math.round(blue)));
                int g =(int)Math.max(0,Math.min(255,Math.round(green)));

               filtered.set(col,row, new Color(r,g,b));
            }
        }

        return filtered;
    }

    public static Picture sharpen(Picture picture){

        int height = picture.height();
        int width = picture.width();

        Picture filtered = new Picture(width,height);

        int[][] a = {

            {0, -1, 0},
            {-1, 5, -1},
            {0, -1, 0}
        };

        
        for (int row = 0; row < height; row++){

            for (int col = 0; col < width; col++){

                // initialize the sum of intensity of RGB

                double red = 0;
                double blue = 0;
                double green = 0;

                for (int i = 0; i < a.length; i++){

                    for (int j = 0; j < a.length; j++){

                        // modulo arimatic

                        int offsetRow = i - a.length/2;
                        int offsetCol = j - a.length/2;

                        int neighborRow = (row + offsetRow + height) % height;
                        int neighborCol = (col + offsetCol + width) % width;

                        Color pixel = picture.get(neighborCol, neighborRow);

                        red += pixel.getRed()*a[i][j];
                        blue += pixel.getBlue()*a[i][j];
                        green += pixel.getGreen()*a[i][j];
                    }
                }

                int r = (int)Math.max(0,Math.min(255,Math.round(red)));
                int b = (int)Math.max(0,Math.min(255,Math.round(blue)));
                int g =(int)Math.max(0,Math.min(255,Math.round(green)));

               filtered.set(col,row, new Color(r,g,b));
            }
        }

        return filtered;
    }

    public static Picture laplacian(Picture picture){

        int height = picture.height();
        int width = picture.width();

        Picture filtered = new Picture(width,height);

        int[][] a = {

            {-1, -1, -1},
            {-1, 8, -1},
            {-1, -1, -1}
        };

        
        for (int row = 0; row < height; row++){

            for (int col = 0; col < width; col++){

                // initialize the sum of intensity of RGB

                double red = 0;
                double blue = 0;
                double green = 0;

                for (int i = 0; i < a.length; i++){

                    for (int j = 0; j < a.length; j++){

                        // modulo arimatic

                        int offsetRow = i - a.length/2;
                        int offsetCol = j - a.length/2;

                        int neighborRow = (row + offsetRow + height) % height;
                        int neighborCol = (col + offsetCol + width) % width;

                        Color pixel = picture.get(neighborCol, neighborRow);

                        red += pixel.getRed()*a[i][j];
                        blue += pixel.getBlue()*a[i][j];
                        green += pixel.getGreen()*a[i][j];
                    }
                }

                int r = (int)Math.max(0,Math.min(255,Math.round(red)));
                int b = (int)Math.max(0,Math.min(255,Math.round(blue)));
                int g =(int)Math.max(0,Math.min(255,Math.round(green)));

               filtered.set(col,row, new Color(r,g,b));
            }
        }

        return filtered;
    }

    public static Picture emboss(Picture picture){

        int height = picture.height();
        int width = picture.width();

        Picture filtered = new Picture(width,height);

        int[][] a = {

            {-2, -1, 0},
            {-1, 1, 1},
            {0, 1, 2}
        };

        
        for (int row = 0; row < height; row++){

            for (int col = 0; col < width; col++){

                // initialize the sum of intensity of RGB

                double red = 0;
                double blue = 0;
                double green = 0;

                for (int i = 0; i < a.length; i++){

                    for (int j = 0; j < a.length; j++){

                        // modulo arimatic

                        int offsetRow = i - a.length/2;
                        int offsetCol = j - a.length/2;

                        int neighborRow = (row + offsetRow + height) % height;
                        int neighborCol = (col + offsetCol + width) % width;

                        Color pixel = picture.get(neighborCol, neighborRow);

                        red += pixel.getRed()*a[i][j];
                        blue += pixel.getBlue()*a[i][j];
                        green += pixel.getGreen()*a[i][j];
                    }
                }

                int r = (int)Math.max(0,Math.min(255,Math.round(red)));
                int b = (int)Math.max(0,Math.min(255,Math.round(blue)));
                int g =(int)Math.max(0,Math.min(255,Math.round(green)));

               filtered.set(col,row, new Color(r,g,b));
            }
        }

        return filtered;
    }

    public static Picture motionBlur(Picture picture){

        int height = picture.height();
        int width = picture.width();

        Picture filtered = new Picture(width,height);

        int[][] a = {

            {1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1},
        
        };

        
        for (int row = 0; row < height; row++){

            for (int col = 0; col < width; col++){

                // initialize the sum of intensity of RGB

                double red = 0;
                double blue = 0;
                double green = 0;

                for (int i = 0; i < a.length; i++){

                    for (int j = 0; j < a.length; j++){

                        // modulo arimatic

                        int offsetRow = i - a.length/2;
                        int offsetCol = j - a.length/2;

                        int neighborRow = (row + offsetRow + height) % height;
                        int neighborCol = (col + offsetCol + width) % width;

                        Color pixel = picture.get(neighborCol, neighborRow);

                        red += pixel.getRed()*a[i][j]/9.0;
                        blue += pixel.getBlue()*a[i][j]/9.0;
                        green += pixel.getGreen()*a[i][j]/9.0;
                    }
                }

                int r = (int)Math.max(0,Math.min(255,Math.round(red)));
                int b = (int)Math.max(0,Math.min(255,Math.round(blue)));
                int g =(int)Math.max(0,Math.min(255,Math.round(green)));

               filtered.set(col,row, new Color(r,g,b));
            }
        }

        return filtered;
    }

    public static void main(String[] args){

        Picture picture = new Picture(args[0]);

        identity(picture).show();
        gaussian(picture).show();
        sharpen(picture).show();
        laplacian(picture).show();
        emboss(picture).show();
        motionBlur(picture).show();
    }
    
}
