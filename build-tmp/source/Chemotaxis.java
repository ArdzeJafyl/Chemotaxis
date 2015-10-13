import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

 int BacNum = 1000;
 Bacteria [] microbe;

 public void setup()   
 {     
 	
 	background(0);
 	microbe = new Bacteria[BacNum];
 	for(int i = 0; i < microbe.length;i++){
    	microbe[i] = new Bacteria();
    }   
 }

 public void draw()   
 {    
  	fill(0,0,0,10);
  	noStroke();
  	rect(0,0,800,800);
  	for(int i = 0; i < microbe.length; i++){
  		microbe[i].show();
  	}
  	for(int i = 0; i < microbe.length; i++){
  		microbe[i].move();
  	}
 }

 class Bacteria    
 {  
 	int mX, mY, call, d;
 	int photons = color(253,127,8);
 	Bacteria(){
 		mX = (int)(Math.random()*1)+399;
 		mY = (int)(Math.random()*1)+399;
 		call = 0;
 	}

 	public void move(){
		if(call == 20){
			d = (int)(Math.random()*4);
			call = 0;
		}else{
			call = call + 1;
		}
		if (mousePressed == true){
	 		mX = (int)(Math.random()*1)+399;
	 		mY = (int)(Math.random()*1)+399;
	 		call = 0;
	 		d = 0;
		}else{
		 	if(d == 0){
				mX = mX + 1; //right
			}
			else if(d == 1){
				mX = mX - 1; //left
			}
			else if(d == 2){
				mY = mY + 1; //down
			}else{
				mY = mY - 1; //up
			} 
		}
 	}

 	public void show(){
 		fill(0);
 		strokeWeight(2);
 		stroke(photons);
 		ellipse(mX,mY,10,10);
 	}
 } 










  public void settings() { 	size(800,800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
