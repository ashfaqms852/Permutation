package permutation.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class DrawPermutation {

	private static DrawPermutation drawPermutation;
	
	//Singleton
	public static DrawPermutation getInstance(){
		if(drawPermutation==null)
			drawPermutation = new DrawPermutation();
		return drawPermutation;
	}
	
	//Constructor
	private DrawPermutation(){
		
	}
	
	//Printing the output
	public void paintPermutation(Graphics2D graphics2D,List<Integer> permutationList){
		try{
			List<Color>colorList = new ArrayList<Color>();
			colorList.add(Color.YELLOW);
			colorList.add(Color.BLACK);
			colorList.add(Color.RED);
			colorList.add(Color.BLUE);
			colorList.add(Color.darkGray);
			colorList.add(Color.GREEN);
			colorList.add(Color.magenta);
			colorList.add(Color.ORANGE);
			colorList.add(Color.CYAN);
			colorList.add(Color.PINK);
			Integer valueX = 100,valueY=100;
			Integer counter = 1;
			for(Integer itr : permutationList){
				graphics2D.setColor(Color.BLUE);
				graphics2D.drawString(counter+"", valueX-50, valueY);
				String[] str = itr.toString().split("");
				for(Integer itr1=0;itr1<str.length;itr1++){
					graphics2D.setColor(colorList.get(Integer.parseInt(str[itr1])));
					graphics2D.fillRect(valueX, valueY, 50, 50);
					graphics2D.setColor(Color.WHITE);
					graphics2D.drawString(str[itr1], valueX+25, valueY+25);
					valueX+=50;
				}
				counter++;
				valueY+=50;
				valueX=100;
			}
		}catch(Exception e){
			System.out.println("Just skip this error!!:"+e.getMessage());
		}
	}
	
}

