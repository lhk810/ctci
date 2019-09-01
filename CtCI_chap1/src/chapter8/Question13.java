package chapter8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Question13 {

	public static void main(String[] args) {
		Question13 q13 = new Question13();
		Box box1 = new Box(1, 1, 1);
		Box box2 = new Box(2, 2, 2);
		Box box3 = new Box(3, 3, 3);
		
		ArrayList<Box> boxes = new ArrayList<>();
		boxes.add(box1);
		boxes.add(box2);
		boxes.add(box3);
		
		System.out.println(q13.createStack(boxes));

	}
	
	
	/* 못풀겠어
	public int boxStack(Box[] boxes) {
		Box[] stack = new Box[boxes.length];
		return boxStack(stack, boxes, 0, 0, null);
	}
	
	public int boxStack(Box[] stack, Box[] boxes, int size, int height, Box box) {
		if (size == stack.length) {
			return height;
		}
		
		Box boxlast;
		int res = height;
		if (size == 0) {
			size++;
			for (int i=0; i<boxes.length; i++) {
				boxlast = boxes[i];
				stack[0] = boxlast;
				Box[] newboxes = new Box[boxes.length];
				for (int j=0; j<boxes.length; j++) {
					newboxes[j] = boxes[j];
				}
				newboxes[i] = null;
				for (int j=0; j<newboxes.length; j++) {
					if (newboxes[j] != null) {
						boxlast = newboxes[j];
						res = Math.max(height, boxStack(stack, newboxes, size, height + boxlast.height, boxlast)); //boxlast가 잘못됨 ㅠ
					}
				}
				

			}
		}
		
		boxlast =  stack[size-1];
		
		if (box != null) {
			if (checkSize(boxlast, box)) {
				stack[size] = box;
				size++;
				//height += box.height;
				for (int i=0; i<boxes.length; i++) {
					if (boxes[i] != null) {
						boxlast = boxes[i];
						Box[] newboxes = new Box[boxes.length];
						for (int j=0; j<boxes.length; j++) {
							newboxes[j] = boxes[j];
						}
						newboxes[i] = null;
						res = Math.max(height, boxStack(stack, newboxes, size, height + box.height, boxlast));
					}
				}
			}
		}
			
		return Math.max(res, height);
	}
	*/
	
	public boolean checkSize(Box boxlast, Box box) {
		if (boxlast.depth>box.depth && boxlast.height>box.height && boxlast.width>box.width) {
			return true;
		} else {
			return false;
		}
	}
	
	//**********************************************************//
	public int createStack(ArrayList<Box> boxes) {
		Collections.sort(boxes, new BoxComparator());
		int maxHeight = 0;
		int[] stackMap = new int[boxes.size()];
		for (int i= 0; i < boxes.size(); i++) {
			int height = createStack(boxes, i, stackMap);
			maxHeight = Math.max(maxHeight, height);
		}
		return maxHeight;
	}
	
	public int createStack(ArrayList<Box> boxes, int idx, int[] stackMap) {
		if (idx < boxes.size() && stackMap[idx] > 0) {
			return stackMap[idx];
		}
		
		Box bottom = boxes.get(idx);
		int maxHeight = 0;
		for (int i=0; i<boxes.size(); i++) {
			if (boxes.get(i).checkSize(bottom)) {
				int height = createStack(boxes, i, stackMap);
				maxHeight = Math.max(maxHeight, height);
			}
		}
		maxHeight += bottom.height;
		stackMap[idx] = maxHeight;
		return maxHeight;
	}
	

}

class BoxComparator implements Comparator<Box> {
	@Override
	public int compare(Box x, Box y) {
		return y.height - x.height;
	}
}

class Box {
	int width;
	int height;
	int depth;
	public Box(int w, int h, int d) {
		this.depth = d;
		this.height = h;
		this.width = w;
	}
	public boolean checkSize(Box box) {
		if (this.depth<box.depth && this.height<box.height && this.width<box.width) {
			return true;
		} else {
			return false;
		}
	}
}
