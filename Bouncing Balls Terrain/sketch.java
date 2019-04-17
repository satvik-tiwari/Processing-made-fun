import shiffman.box2d.*;
import org.jbox2d.collision.shapes.*;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.*;
import org.jbox2d.dynamics.*;

Box2DProcessing box2d;
ArrayList<Particles> particles;
Surface surface;
void setup()
{
  size(800,800);
  smooth();
  box2d = new Box2DProcessing(this);
   box2d.createWorld();
  
  box2d.setGravity(0, -20);
  particles = new ArrayList<Particles>();
  surface = new Surface();
}


void draw()
{
  background(255);
  if(mousePressed)
  {
   particles.add(new Particles(mouseX, mouseY,random(2,6))); 
  }
  box2d.step();
  surface.display();
  
  
  for(Particles p : particles)
  p.display();
  
  for(int i=particles.size()-1;i>=0;i--)
  {
   Particles p = particles.get(i);
   if(p.done())
   {
    particles.remove(i); 
   }
  }  
  
   fill(0);
  text("framerate: " + (int)frameRate,12,16);
}
