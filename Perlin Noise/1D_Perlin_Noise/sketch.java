float start = 0;
void setup()
{
  size(400,400);
  
}

void draw()
{
  float xoff = start;
  background(51);
  stroke(255);
  noFill();
  beginShape();
  for(int x = 0; x < width; x+=1)
  {
   stroke(255); 
   float y = map(noise(xoff), 0, 1, 0, height);
   vertex(x, y);
   xoff += 0.02;
  }
  endShape();
  start += 0.02;
} 
