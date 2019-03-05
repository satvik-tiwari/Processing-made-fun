void setup()
{
  size(800,800);
 
}

void draw()
{

  float xoff = 0;
  float yoff = 0;
  loadPixels();
  for(int y=0; y<height; y++)
  
  {
    xoff= 0;
    for(int x=0; x<width; x++) 
    {
      float r = noise(xoff, yoff)*255;
      int idx = x + y * width;
      pixels[idx] = color(r,r,r);
      xoff += 0.001;
    }
    yoff += 0.001;
  }
    
    updatePixels();
 
} 
