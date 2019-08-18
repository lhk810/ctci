package chapter7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Question4 {

	public static void main(String[] args) {
		

	}

}

class ParkingLot {
	HashMap<String, Integer> vacantSpots = new HashMap<String, Integer>();
	ArrayList<ParkingSpot> parkinglot = new ArrayList<ParkingSpot>();
	
	public ParkingLot(int numBig, int numSmall, int numSenior, int numOrdinary) {
		//big+small = senior+ordinary
		//or return error
		vacantSpots.put("Big", numBig);
		vacantSpots.put("Small", numSmall);
		vacantSpots.put("Senior",numSenior);
		vacantSpots.put("Ordinary",numOrdinary);
		
		int countSenior = numSenior;
		int countOrdinary = numOrdinary;
		
		for (int i=0;i<numBig;i++) {
			if (countSenior != 0) {
				parkinglot.add(new ParkingSpot(ParkingLotSize.big, DriverState.senior));
				countSenior--;
			} else {
				parkinglot.add(new ParkingSpot(ParkingLotSize.big,DriverState.ordinary));
				countOrdinary--;
			}
		}
		
		for (int j=0;j<numSmall;j++) {
			if (countSenior != 0) {
				parkinglot.add(new ParkingSpot(ParkingLotSize.small, DriverState.senior));
				countSenior--;
			} else {
				parkinglot.add(new ParkingSpot(ParkingLotSize.small,DriverState.ordinary));
				countOrdinary--;
			}
		}
		
	}
	
	public void parkCar(Car car) {
		String cartype = car.type.toString();
		if (cartype == "sedan") {
			cartype = "small";
		} else {
			cartype = "big";
		}
		String driverstate = car.driver.toString();
		
		if (vacantSpots.get(cartype) > 0 && vacantSpots.get(driverstate) > 0) {
			vacantSpots.replace(cartype, vacantSpots.get(cartype)-1);
			vacantSpots.replace(driverstate, vacantSpots.get(driverstate)-1);
			
			for (int i=0; i<parkinglot.size(); i++) {
				if (parkinglot.get(i).forwhom.toString() == driverstate && parkinglot.get(i).size.toString() == driverstate) {
					if (parkinglot.get(i).isVacant) {
						parkinglot.get(i).isVacant = false;
					}
				}
			}
			
			System.out.println("The car is parked");
		} else {
			System.out.println("The car cannot be parked");
		}
		
	}
	
	
}

class ParkingSpot {
	ParkingLotSize size;
	DriverState forwhom;
	boolean isVacant = true;
	
	public ParkingSpot(ParkingLotSize size, DriverState forwhom) {
		this.size = size;
		this.forwhom = forwhom;
	}
	
	public void parkCar() {
		this.isVacant = false;
	}
	
	public void takeCar() {
		this.isVacant = true;
	}
	
}

class Car {
	CarType type;
	DriverState driver;
}

enum CarType {
	sedan, SUV
}

enum ParkingLotSize {
	big, small
}

enum DriverState {
	senior, ordinary
}
