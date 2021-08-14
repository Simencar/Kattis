public class PointsOfSnow {
    static long[] tree;
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int N = io.getInt();
        int K = io.getInt();
        int Q = io.getInt();
        tree = new long[4*N];


        for(int i = 0; i < K+Q; i++) {
            String op = io.getWord();
            if(op.equals("!")) {
                int l = io.getInt();
                int r = io.getInt();
                long val = io.getLong();
                update(idx(l), idx(r)-1, val);
            }
            else {
                int x = io.getInt();
                io.println(get(x-1));
            }
        }
        io.close();

    }

    static void update(int l, int r, long val) {
        boolean leftleft = false; //a parent of l has been left(out of range)
        boolean rightright = false; //a parent of r has been right
        if(l == r) {
            tree[l] += val;
            return;
        }
        while(true) {
            int pl = parent(l);
            int pr = parent(r);
            if(pl == pr) {
                if(!leftleft && !rightright) { //perfect interval
                    tree[pl] += val;
                }
                else if (leftleft && !rightright) {
                    tree[r] += val;
                }
                else if (!leftleft && rightright) {
                    tree[l] += val;
                }
                return;
            }
            if(l%2 != 0) { //left goes left
                if(!leftleft) { //first left
                    tree[l] += val;
                }
                leftleft = true;
            }
            else { //left goes right
                if(leftleft) { //has already gone left, needs to update right child of parent
                    tree[right(pl)] += val;
                }
            }
            if(r%2 != 1) { //right goes right
                if(!rightright) { //first right
                    tree[r] += val;
                }
                rightright = true;
            }
            else { // right goes left
                if(rightright) { //has already gone right, needs to update left child of parent
                    tree[left(pr)] += val;
                }
            }
            l = pl;
            r = pr;
        }
    }

    static long get(int i) {
        int pos = idx(i);
        long sum = 0;
        while(pos > 0) {
            sum += tree[pos];
            pos = parent(pos);
        }
        return sum;
    }

    static int left(int i) {
        return 2*i;
    }

    static int right(int i) {
        return 2*i+1;
    }

    static int parent(int i) {
        return i/2;
    }

    static int idx(int i) {
        return (tree.length)/2+i;
    }
}
