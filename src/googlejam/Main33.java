package googlejam;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main33 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(4&7);
		
//		Scanner in = null;
//		try {
//			in = new Scanner(new FileInputStream("C:\\Users\\gu\\Downloads\\A-large.in"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		PrintWriter out = null;
//		try {
//			out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\gu\\Downloads\\A-large.out")));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		int caseCount;
//        caseCount = in.nextInt();
//		for(int i=1; i<=caseCount; i++) {
//			int lineCount = in.nextInt();
//			List<Point> pointList = new ArrayList<Point>();
//			long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
//			long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;
//			for(int j=1; j<=lineCount; j++) {
//				for(int cc=1; cc<=2; cc++) {
//					long x = in.nextLong();
//					long y = in.nextLong();
//					if(x < minX)
//						minX = x;
//					else if(x > maxX)
//						maxX = x;
//					if(y < minY)
//						minY = y;
//					else if(y > maxY)
//						maxY = y;
//					pointList.add(new Point(x, y));
//				}
//			}
//			Circur maxCir = getMaxCir(minX, maxX, minY, maxY);
//			List<Point> candidateList = new ArrayList<Point>();
//			while(candidateList.isEmpty()) {
//				for(Point p : pointList) {
//					if(maxCir.isInCircur(p))
//						candidateList.add(p);
//				}
//				maxCir.r += 1;
//			}
//			minX = candidateList.get(0).x; 
//			for(Point p : candidateList) {
//				if(p.x < minX) {
//					minX = p.x;
//				}
//			}
//			List<Point> candidateXList = new ArrayList<Point>();
//			for(Point p : candidateList) {
//				if(p.x == minX) {
//					candidateXList.add(p);
//				}
//			}
//			Point minPoint = candidateXList.get(0);
//			if(candidateXList.size() > 1) {
//				minY = candidateList.get(0).y;
//				for(Point p : candidateXList) {
//					if(p.y < minY) {
//						minY = p.y;
//					}
//				}
//				for(Point p : candidateList) {
//					if(p.y == minY) {
//						minPoint = p;
//					}
//				}
//			}
//			long sum = 0; 
//			for(Point p : pointList) {
//				sum += Math.abs(p.x-minPoint.x)+Math.abs(p.y-minPoint.y);
//			}
//
//			StringBuffer output = new StringBuffer("Case #"+i+": ");
//			output.append(minPoint.x+" "+minPoint.y+" "+sum);
//			out.println(output.toString());
//		}
//		in.close();
//		out.close();
	}
	
	public static Circur getMaxCir(long minX, long maxX, long minY, long maxY) {
		long widthX = maxX - minX;
		long widthY = maxY - minY;
		long d = (widthX >= widthY) ? widthX : widthY;
		Point point = new Point((minX+maxX)/2, (minY+maxY)/2);
		return new Circur(point, d/2);
	}

}

class Point {
	public long x,y;
	public Point(long x, long y) {
		this.x = x;
		this.y = y;
	}
}

class Circur {
	public Point point;
	public long r;
	public long maxR;
	public Circur(Point point, long maxR) {
		this.point = point;
		this.r = 0;
		this.maxR = maxR;
	}
	public boolean isInCircur(Point p) {
		long deltaX = point.x - p.x;	//x÷·æ‡¿Î≤Ó
		long deltaY = point.y - p.y;	//y÷·æ‡¿Î≤Ó
		double distance = Math.sqrt(Math.pow(deltaX, 2.0) + Math.pow(deltaY, 2.0));
		return distance <= this.r;
	}
}