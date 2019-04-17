class Surface
{
  ArrayList<Vec2> surface;
  
 Surface()
 {
  surface = new ArrayList<Vec2>(); 
  ChainShape cs = new ChainShape();
  float xoff = 0.0;
  
  for(int x=0; x<width; x+=2)
  {
    
    float y = map(noise(xoff), 0, 1, height/2, height);
    surface.add(new Vec2(x,y));
    xoff+=0.02;
    
    }
   
   Vec2[] vertices = new Vec2[surface.size()];
   for(int i=0;i<vertices.length;i++)
   vertices[i]=box2d.coordPixelsToWorld(surface.get(i));
   
   cs.createChain(vertices, vertices.length);
   
   BodyDef bd = new BodyDef();
   bd.position.set(0.0f,0.0f);
   Body body = box2d.createBody(bd);
   body.createFixture(cs,1);
 }
 
 void display()
 {
  stroke(0);
  strokeWeight(1);
  fill(200);
  //noFill();
  beginShape();
  vertex(0,height);
  for(Vec2 v: surface)
  {
    vertex(v.x,v.y);
  }
  
    vertex(width,height);
  endShape();
   
 }
  
}
