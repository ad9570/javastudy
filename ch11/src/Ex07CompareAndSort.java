import java.util.*;

class Ex07CompareAndSort {
	public static void main(String[] args) {
		String[] strArr = {"cat", "Dog", "lion", "tiger"};

		Arrays.sort(strArr); // String의 Comparable(기본 정렬 방식)구현에 의한 정렬
		System.out.println("strArr = " + Arrays.toString(strArr));

		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); // 대소문자 구분 안하는 정렬 방식
		System.out.println("strArr = " + Arrays.toString(strArr));

		Arrays.sort(strArr, new Desc<>()); // 역순 정렬 방식
		System.out.println("strArr = " + Arrays.toString(strArr));
	}
}

class Desc<String> implements Comparator<String> {
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable) o1;	// o1의 기본 정렬방식
			Comparable c2 = (Comparable) o2;	// o2의 기본 정렬방식
//			return c1.compareTo(c2) * -1 ;	// -1을 곱해서 기본 정렬방식의 역으로 변경한다.
			return c2.compareTo(c1);		// 위와 동일한 의미
		}
		return -1;
	} 
}