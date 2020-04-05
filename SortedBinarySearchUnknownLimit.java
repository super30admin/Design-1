
public class SortedBinarySearchUnknownLimit {

	/*public int search(ArrayReader reader, int target) {

		int low = 0;
		int high = 1;

		if (reader.get(0) == target)
			return 0;

		while (target > reader.get(high)) {
			high <<= 1;
		}

		int mid, num;

		while (low <= high) {

			mid = low + ((high - low) >> 1);
			num = reader.get(mid);

			if (num == target)
				return mid;
			if (num < target)
				low = mid + 1;
			else
				high = mid - 1;

		}
		return -1;

	}*/

}
