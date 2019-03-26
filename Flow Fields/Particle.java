class Particle
{
  PVector pos;
  PVector vel;
  PVector acc;
  int maxSpeed;
  Particle()
 {
   pos = new PVector(random(width),random(height));
   vel = new PVector(0,0);
   acc = new PVector(0,0);
   maxSpeed = 4;
 }
  void update()
  {
   vel.add(acc);
   vel.limit(maxSpeed); 
   pos.add(vel);
   acc.mult(0);
  }
  
  void applyForce(PVector force)
  {
   acc.add(force); 
  }
  
  void display()
  {
   stroke(floor(random(0,255)),floor(random(0,255)),floor(random(0,255)),5);
   //stroke(255,0,0,5);
   strokeWeight(1);
   point(pos.x, pos.y);
  }
  
  void edges()
  {
   if(pos.x>width)
   pos.x = 0;
   if(pos.x<0)
   pos.x = width;
   if(pos.y>height)
   pos.y = 0;
   if(pos.y<0)
   pos.y = height;
  }
  
  void follow(PVector vectors[])
  {
    int x =floor(pos.x/scl);
    int y= floor(pos.y/scl);
    int idx = x + y*cols;
    idx = idx%400;
   // print(idx+" ");
    PVector force = vectors[idx];
    this.applyForce(force);
  }
}
