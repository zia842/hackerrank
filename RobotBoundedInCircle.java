/**
 * On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:

    "G": go straight 1 unit;
    "L": turn 90 degrees to the left;
    "R": turn 90 degrees to the right.

	The robot performs the instructions given in order, and repeats them forever.

	Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
	
	Input: instructions = "GGLLGG"
	Output: true
	Explanation: The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
	When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
	
	Input: instructions = "GG"
	Output: false
	Explanation: The robot moves north indefinitely.
	
	Input: instructions = "GL"
	Output: true
	Explanation: The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
	
	Constraints:

    1 <= instructions.length <= 100
    instructions[i] is 'G', 'L' or, 'R'.


 * @author zia84
 *
 */

/**
 * //https://calcworkshop.com/transformations/rotation-rules/ 
 * 
 * @author zia84
 *
 */

public class RobotBoundedInCircle {
	
	public boolean isRobotBounded(String instructions) {

		
		int dirX = 0;
		int dirY = 1; //Because we are moving in North direction
		int x = 0;
		int y = 0;
		
		for(Character c : instructions.toCharArray()) {
			if(c == 'G') { 
				x = dirX + x;
				y = dirY + y;
			}
			else if(c == 'L') { //The rule for rotation by 90Deg about origin is (x,y) -> (-y,x)
				int temp = dirX;
				dirX = (-1) * dirY;
				dirY = temp;
			}
			else {
				int temp = dirX;
				dirX = dirY;
				dirY = (-1) * temp;
			}
		}
		return ((x == 0 && y == 0)  || (dirX!=0 && dirY!=1)); //If position is not changed there exist cycle OR direction is changed 
	}
	
	public static void main(String []args) {
		RobotBoundedInCircle r = new RobotBoundedInCircle();
		System.out.println(r.isRobotBounded("GGLLGG"));
		System.out.println(r.isRobotBounded("GG"));
		System.out.println(r.isRobotBounded("GL"));
		System.out.println(r.isRobotBounded("GGLL"));
	}

}
