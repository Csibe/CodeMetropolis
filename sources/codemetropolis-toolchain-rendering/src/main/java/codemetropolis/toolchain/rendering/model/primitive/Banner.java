package codemetropolis.toolchain.rendering.model.primitive;

import java.io.File;

import codemetropolis.toolchain.commons.cmxml.Point;
import codemetropolis.toolchain.rendering.model.BasicBlock;

public class Banner implements Primitive {
	
	public enum Orientation {
		SOUTH(0),
		SOUTHWEST(2),
		WEST(4),
		NORTHWEST(6),
		NORTH(8),
		NORTHEAST(10),
		EAST(12),
		SOUTHEAST(14);
		
		private final int value;
		
		Orientation(int v) {
			value = v;
		}
		
		public int getValue() {
			return value;
		}
	}
	
	private Point position;
	private Orientation orientation;
	private String color;

	public Banner(int x, int y, int z, Orientation orientation, String color) {
		super();
		this.position = new Point(x, y, z);
		this.orientation = orientation;
		this.color = color;
	}
	
	@Override
	public int toCSVFile(File directory) {
		new Boxel(new BasicBlock((short) 176, orientation.getValue()), position, color).toCSVFile(directory);
		return 1;
	}
	@Override
	public int getNumberOfBlocks() {
		return 1;
	}
	
}
