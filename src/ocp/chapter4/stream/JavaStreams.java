package ocp.chapter4.stream;

import java.util.stream.IntStream;

public class JavaStreams {
	public static void main(String[] args) {
		System.out.println(IntStream.range(1,10).count());
	}
}
