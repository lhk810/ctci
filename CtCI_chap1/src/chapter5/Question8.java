package chapter5;

public class Question8 {
	
	public static void main(String[] args) {
		Question8 q8 = new Question8();
		byte[] screen = new byte[96];
		int width = 16;
		int x1 = 1;
		int x2 = 3;
		int y =2;
		q8.drawLine(screen, width, x1, x2, y);
	}
	
	//이 문제는 난 진짜 모르겠다
	public void drawLine(byte[] screen, int width, int x1, int x2, int y) {
		int start_offset = x1%8;
		int first_full_byte = x1/8;
		if (start_offset != 0) {
			first_full_byte++;
		}
		
		int end_offset = x2%8;
		int last_full_byte = x2/8;
		if (end_offset != 7) {
			last_full_byte--;
		}
		
		for (int b = first_full_byte; b <= last_full_byte; b++) {
			screen[(width/8)*y + b] = (byte) 0xFF;
		}
		
		byte start_mask = (byte) (0xFF >> start_offset);
		byte end_mask = (byte) ~(0xFF >> (end_offset+1));
		
		if ((x1/8) == (x2/8)) {
			byte mask = (byte) (start_mask & end_mask);
			screen[(width/8)*y + (x1/8)] |= mask;
		} else {
			if (start_offset != 0) {
				int byte_number = (width/8)*y + first_full_byte - 1;
				screen[byte_number] |= start_mask;
			}
			if (end_offset != 7) {
				int byte_number = (width / 8)*y + last_full_byte + 1;
				screen[byte_number] |= end_mask;
			}
		}
		
		
	}
	
	
}

