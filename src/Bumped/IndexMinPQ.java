package Bumped;

import java.util.NoSuchElementException;

public class IndexMinPQ<Key extends Comparable<Key>> implements IIndexPQ<Key> {

	private int N; // number of elements
	private int[] pq; // binary heap
	private int[] qp; // inverse
	private Key[] keys; // items with properties

	public IndexMinPQ(int maxN) {
		keys = (Key[]) new Comparable[maxN + 1];
		pq = new int[maxN + 1];
		qp = new int[maxN + 1];
		for (int i = 0; i <= maxN; i++) {
			qp[i] = -1;
		}
	}

	private void swap(int i, int j) {
		int swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
		qp[pq[i]] = i;
		qp[pq[j]] = j;
	}

	/**
	 * Swaps element at this index with parent if parents element is larger
	 * 
	 * @param index
	 *            the parents of this index will be checked
	 */
	private void swim(int index) {
		while (index > 1 && greater(index / 2, index)) {
			swap(index, index / 2);
			index = index / 2;
		}
	}

	/**
	 * Swaps element at this index with children if the children's element is
	 * smaller
	 * 
	 * @param index
	 *            the children of this index will be checked
	 */
	private void sink(int index) {
		while (2 * index <= N) {
			int j = 2 * index; // index of children
			if (j < N && greater(j, j + 1)) {
				j++;
			}
			if (!greater(index, j)) {
				break;
			}
			swap(index, j);
			index = j;
		}
	}

	/**
	 * Checks if first key is larger than second key
	 * 
	 * @param i
	 *            first key
	 * @param j
	 *            second key
	 * @return true if first is larger than second
	 */
	private boolean greater(int i, int j) {
		return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
	}

	@Override
	public void add(int index, Key key) {
		N++;
		qp[index] = N;
		pq[N] = index;
		keys[index] = key;
		swim(N);
	}

	@Override
	public void changeKey(int index, Key key) {
		keys[index] = key;
		swim(qp[index]);
		sink(qp[index]);

	}

	@Override
	public boolean contains(int index) {
		return qp[index] != -1;
	}

	@Override
	public void delete(int index) {
		int del = qp[index];
		swap(del, N--);
		swim(del);
		sink(del);
		keys[index] = null;
		qp[index] = -1;
	}

	@Override
	public Key getKey(int index) {
		return keys[index];
	}

	@Override
	public Key peekKey() {
		if (isEmpty()) {
			return null;
		}
		return keys[pq[1]];
	}

	@Override
	public int peek() {
		if (isEmpty()) {
			return -1;
		}
		return pq[1];
	}

	@Override
	public int poll() {
		if (isEmpty()) {
			return -1;
		}
		int index = pq[1];
		delete(index);
		return index;
	}

	@Override
	public int size() {
		return N;
	}

	@Override
	public boolean isEmpty() {
		return N == 0;
	}

}
