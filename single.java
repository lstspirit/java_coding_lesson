package java_19202;

public class single {
	private static single a = new single();
	private single() {
	}
	public static single getSingleInstance() {
		return a;	
	}
	public void show()
	{
		System.out.print("Success!");
	}
	public static void main(String arg0[]) {
		single b = single.getSingleInstance();
		b.show();
	}
}
package java_19202;

public abstract class CPU {
	private String Name;
	private String coreNum;
	private int price;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCoreNum() {
		return coreNum;
	}
	public void setCoreNum(String coreNum) {
		this.coreNum = coreNum;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
package java_19202;

public class AMDCPU extends CPU {
	AMDCPU(){
		this.setName("AMDCPU");
		this.setCoreNum("8th");
		this.setPrice(100);
	}
}
package java_19202;

public class intelCPU extends CPU {
	intelCPU(){
		this.setName("intel");
		this.setCoreNum("8th");
		this.setPrice(200);
	}
}
package java_19202;

public abstract class ROM {
	private String Name;
	private String volume;
	private int price;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
package java_19202;

public class KingstonROM extends ROM{
	 KingstonROM(){
		 this.setName(" Kingston");
		 this.setVolume("A");
		 this.setPrice(500);
	 }
}
package java_19202;

public class SamsungROM extends ROM{
	SamsungROM(){
		this.setName("SamsungROM");
		this.setVolume("B");
		this.setPrice(100);
	}
}
package java_19202;

public abstract class Disk {
	private String Name;
	private String volume;
	private int price;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
package java_19202;

public class WestDigitalsDisk extends Disk{
	WestDigitalsDisk(){
		this.setName("WestDigitals");
		this.setVolume("D");
		this.setPrice(120);
	}
}
package java_19202;

public class SeagateDisk extends Disk {
	SeagateDisk(){
		this.setName("Seagate");
		this.setVolume("C");
		this.setPrice(166);
	}

}
package java_19202;

public abstract class Board {
	private String Name;
	private String speed;
	private	int price;
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
} package java_19202;

public class AsusBoard extends Board{
	AsusBoard(){
		this.setName("Asus");
		this.setSpeed("1000");
		this.setPrice(300);
	}
}
package java_19202;

public class GigabyteBoard extends Board{
	GigabyteBoard(){
		this.setName("Gigabyte");
		this.setSpeed("2000");
		this.setPrice(300);
	}

}
package java_19202;

public class Computer implements show {
	private CPU cpu;
	private ROM rom;
	private Disk disk;
	private Board board;
	Computer(CPU cpu, ROM rom,Disk disk,Board board)
	{
		this.cpu = cpu;
		this.rom = rom;
		this.disk = disk;
		this.board = board;
	}
	public CPU getCpu() {
		return cpu;
	}
	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}
	public ROM getRom() {
		return rom;
	}
	public void setRom(ROM rom) {
		this.rom = rom;
	}
	public Disk getDisk() {
		return disk;
	}
	public void setDisk(Disk disk) {
		this.disk = disk;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	@Override
	public void declare() {
		System.out.print(this.getCpu().getName());
		System.out.println(this.getCpu().getCoreNum());
		System.out.print(this.getRom().getName());
		System.out.println(this.getRom().getVolume());
		System.out.print(this.getDisk().getName());
		System.out.println(this.getDisk().getVolume());
		System.out.print(this.getBoard().getName());
		System.out.println(this.getBoard().getSpeed());
		
	}
	@Override
	public void cost() {
		System.out.println(this.getBoard().getPrice()+this.getCpu().getPrice()+this.getDisk().getPrice()+this.getRom().getPrice());
	}

}
package java_19201;

public interface show {
	public void declare();
	public void cost();
}
package java_19202;

public class ComputerStore {
	public static void main(String arg0[]) {
		CPU cpu1 = new intelCPU();
		CPU cpu2 = new AMDCPU();
		ROM rom1 = new SamsungROM();
		ROM rom2 = new KingstonROM();
		Disk disk1 = new SeagateDisk();
		Disk disk2 = new WestDigitalsDisk();
		Board board = new AsusBoard();
		Computer c1 = new Computer(cpu1,rom1,disk1,board);
		Computer c2 = new Computer(cpu2,rom2,disk2,board);
		Computer c3 = new Computer(cpu1,rom2,disk1,board);
		c1.cost();
		c2.cost();
		c3.cost();
		c1.declare();
		c2.declare();
		c3.declare();
