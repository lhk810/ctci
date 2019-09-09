package chapter8;

public class Question13 {

	public static void main(String[] args) {
		Question13 q13 = new Question13();
		Box box1 = new Box(1, 1, 1);
		Box box2 = new Box(2, 2, 2);
		Box box3 = new Box(3, 3, 3);
		
		Box[] boxes = new Box[3];
		boxes[0] = box1;
		boxes[1] = box2;
		boxes[2] = box3;
		
		System.out.println(q13.boxStack(boxes));

	}
	
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
				res = boxStack(stack, newboxes, size, height + boxlast.height, boxlast); //boxlast°¡ Àß¸øµÊ ¤Ð

			}
		}
		
		boxlast =  stack[size-1];
		
		if (box != null) {
			if (checkSize(boxlast, box)) {
				stack[size] = box;
				size++;
				height += box.height;
				for (int i=0; i<boxes.length; i++) {
					if (boxes[i] != null) {
						boxlast = boxes[i];
						Box[] newboxes = new Box[boxes.length];
						for (int j=0; j<boxes.length; j++) {
							newboxes[j] = boxes[j];
						}
						newboxes[i] = null;
						res = boxStack(stack, newboxes, size, height, boxlast);
					}
				}
			}
		}
			
		return Math.max(height, res);
	}
	
	public boolean checkSize(Box boxlast, Box box) {
		if (boxlast.depth>box.depth && boxlast.height>box.height && boxlast.width>box.width) {
			return true;
		} else {
			return false;
		}
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
}
